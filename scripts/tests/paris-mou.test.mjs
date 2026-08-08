import assert from 'node:assert/strict';
import { readFile } from 'node:fs/promises';
import test from 'node:test';
import { fileURLToPath } from 'node:url';
import path from 'node:path';

import {
  buildEdition,
  discoverPdfSources,
  parsePerformancePdfText,
  resolveIsoCode,
  stableJson,
  validateEdition,
} from '../lib/paris-mou.mjs';

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const repositoryRoot = path.resolve(testDirectory, '../..');
const fixtureDirectory = path.join(repositoryRoot, 'scripts/fixtures');

async function readFixtures() {
  const pairs = await Promise.all(
    ['white', 'grey', 'black'].map(async (status) => [
      status,
      await readFile(path.join(fixtureDirectory, `paris-mou-2025-${status}.txt`), 'utf8'),
    ]),
  );
  return Object.fromEntries(pairs);
}

const sourceUrls = {
  white: 'https://parismou.org/system/files/2026-06/Paris%20MoU%202025_WhiteList.pdf',
  grey: 'https://parismou.org/system/files/2026-06/Paris%20MoU%202025_GreyList.pdf',
  black: 'https://parismou.org/system/files/2026-06/Paris%20MoU%202025_BlackList.pdf',
};

test('discovers all current PDF links and the edition from single-quoted HTML', () => {
  const html = `
    <h2>Flag Performance list 2025</h2>
    <a href='${sourceUrls.white}'>Paris MoU 2025 White List</a>
    <a href='${sourceUrls.black}'>Paris MoU 2025 Black List</a>
    <a href='${sourceUrls.grey}'>Paris MoU 2025 Grey List</a>
  `;
  assert.deepEqual(discoverPdfSources(html), { edition: 2025, sources: sourceUrls });
});

test('parses and validates the complete 69-row 2025 edition', async () => {
  const texts = await readFixtures();
  const edition = buildEdition({ edition: 2025, sources: sourceUrls, texts });

  assert.equal(edition.entries.length, 69);
  assert.deepEqual(
    Object.fromEntries(
      ['white', 'grey', 'black'].map((status) => [
        status,
        edition.entries.filter((entry) => entry.status === status).length,
      ]),
    ),
    { white: 40, grey: 19, black: 10 },
  );
  assert.equal(edition.valid_from, '2026-07-01');
  assert.equal(edition.valid_until, '2027-07-06');
  assert.equal(edition.performance_period, '2023-2025');

  const knownRows = {
    KY: [1, 'white'],
    SE: [2, 'white'],
    FR: [7, 'white'],
    PA: [36, 'white'],
    KR: [41, 'grey'],
    EG: [53, 'grey'],
    CM: [69, 'black'],
  };
  for (const [isoCode, [rank, status]] of Object.entries(knownRows)) {
    const entry = edition.entries.find((candidate) => candidate.iso_code === isoCode);
    assert.ok(entry, `${isoCode} should be present`);
    assert.equal(entry.rank, rank);
    assert.equal(entry.status, status);
  }

  const committed = JSON.parse(
    await readFile(path.join(repositoryRoot, 'src/data/parisMou/2025.json'), 'utf8'),
  );
  assert.equal(stableJson(edition), stableJson(committed));
});

test('maps official aliases to ISO 3166-1 alpha-2 codes', () => {
  assert.equal(resolveIsoCode('Cayman Islands, UK'), 'KY');
  assert.equal(resolveIsoCode('Hong Kong (China)'), 'HK');
  assert.equal(resolveIsoCode('Korea, Republic of'), 'KR');
  assert.equal(resolveIsoCode('Türkiye'), 'TR');
  assert.equal(resolveIsoCode('Viet Nam'), 'VN');
  assert.equal(resolveIsoCode('Tanzania, United Republic of'), 'TZ');
  assert.throws(() => resolveIsoCode('Unreviewed Alias'), /Unknown Paris MoU flag alias/);
});

test('refuses partial PDFs and non-contiguous editions', async () => {
  const texts = await readFixtures();
  const partialWhite = texts.white.replace(/^\s*40\s+Canada.*$/m, '');
  assert.throws(
    () => parsePerformancePdfText(partialWhite, 'white', { edition: 2025 }),
    /expected 40.*partial update/i,
  );

  const entries = Object.entries(texts).flatMap(([status, text]) =>
    parsePerformancePdfText(text, status),
  );
  entries[68] = { ...entries[68], rank: 68 };
  assert.throws(() => validateEdition(entries), /contiguous/);
});

test('accepts a structurally valid future edition with changed block counts and ranks', () => {
  const futureTexts = {
    white: `Paris MoU White performance list valid: 1 July 2027 until 30 June 2028
INSPECTIONS 2024-2026 DETENTIONS 2024-2026
  1 Sweden 300 1 30 12 -1.2
  2 France 290 2 29 11 -1.1`,
    grey: `Paris MoU Grey performance list valid: 1 July 2027 until 30 June 2028
INSPECTIONS 2024-2026 DETENTIONS 2024-2026
  3 Egypt 80 4 9 2 0.4
  4 Panama 200 12 20 8 0.6`,
    black: `Paris MoU Black performance list valid: 1 July 2027 until 30 June 2028
INSPECTIONS 2024-2026 DETENTIONS 2024-2026
  5 Cameroon 90 20 10 2.2`,
  };
  const futureSources = {
    white: 'https://parismou.org/example/2026_WhiteList.pdf',
    grey: 'https://parismou.org/example/2026_GreyList.pdf',
    black: 'https://parismou.org/example/2026_BlackList.pdf',
  };

  const edition = buildEdition({
    edition: 2026,
    sources: futureSources,
    texts: futureTexts,
  });

  assert.equal(edition.entries.length, 5);
  assert.deepEqual(
    edition.entries.map(({ rank, iso_code: isoCode, status }) => [rank, isoCode, status]),
    [
      [1, 'SE', 'white'],
      [2, 'FR', 'white'],
      [3, 'EG', 'grey'],
      [4, 'PA', 'grey'],
      [5, 'CM', 'black'],
    ],
  );
  assert.equal(edition.performance_period, '2024-2026');
  assert.equal(edition.valid_from, '2027-07-01');
  assert.equal(edition.valid_until, '2028-06-30');
});

test('future edition validation still rejects reordered or empty status blocks', () => {
  const reordered = [
    { rank: 1, iso_code: 'SE', status: 'white' },
    { rank: 2, iso_code: 'EG', status: 'grey' },
    { rank: 3, iso_code: 'FR', status: 'white' },
    { rank: 4, iso_code: 'CM', status: 'black' },
  ];
  assert.throws(
    () => validateEdition(reordered, { edition: 2026 }),
    /ordered white, grey, then black/,
  );

  const noGrey = [
    { rank: 1, iso_code: 'SE', status: 'white' },
    { rank: 2, iso_code: 'CM', status: 'black' },
  ];
  assert.throws(
    () => validateEdition(noGrey, { edition: 2026 }),
    /grey block must not be empty/,
  );
});

test('source manifest keeps medical interpretation changes review-gated', async () => {
  const manifest = JSON.parse(
    await readFile(path.join(repositoryRoot, 'src/data/parisMou/source-check.json'), 'utf8'),
  );
  assert.equal(manifest.paris_mou.edition, 2025);
  assert.equal(manifest.paris_mou.sources.length, 3);
  assert.ok(manifest.paris_mou.sources.every((source) => /^[a-f0-9]{64}$/.test(source.sha256)));
  assert.equal(manifest.medical_source_policy.auto_publish_interpretations, false);
  assert.ok(manifest.medical_authority_sources.length > 0);
  assert.ok(manifest.medical_authority_sources.every(
    (source) => source.review_status === 'pending-review',
  ));
});
