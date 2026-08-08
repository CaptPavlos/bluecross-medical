#!/usr/bin/env node

import { execFile } from 'node:child_process';
import { constants as fsConstants } from 'node:fs';
import {
  access,
  mkdir,
  mkdtemp,
  readFile,
  rename,
  rm,
  writeFile,
} from 'node:fs/promises';
import { tmpdir } from 'node:os';
import path from 'node:path';
import { promisify } from 'node:util';
import { fileURLToPath } from 'node:url';

import {
  LANDING_PAGE_URL,
  buildEdition,
  discoverPdfSources,
  sha256,
  stableJson,
  validateEdition,
} from './lib/paris-mou.mjs';

const execFileAsync = promisify(execFile);
const scriptDirectory = path.dirname(fileURLToPath(import.meta.url));
const repositoryRoot = path.resolve(scriptDirectory, '..');
const dataDirectory = path.join(repositoryRoot, 'src/data/parisMou');
const currentPointerPath = path.join(dataDirectory, 'current.ts');
const sourceManifestPath = path.join(dataDirectory, 'source-check.json');
const medicalSourcesPath = path.join(scriptDirectory, 'data/medical-authority-sources.json');
const timeoutMs = Number(process.env.PARIS_MOU_FETCH_TIMEOUT_MS || 20_000);
const dryRun = process.argv.includes('--dry-run');
const skipMedicalChecks = process.argv.includes('--skip-medical-source-checks');

function classifyFetchError(error) {
  if (error?.name === 'TimeoutError' || error?.name === 'AbortError') return 'timeout';
  if (String(error?.message).startsWith('HTTP ')) return 'http-error';
  if (String(error?.message).includes('was not a PDF')) return 'invalid-content';
  return 'network-error';
}

async function fetchResource(url, expectedKind) {
  const response = await fetch(url, {
    redirect: 'follow',
    signal: AbortSignal.timeout(timeoutMs),
    headers: {
      Accept: expectedKind === 'pdf' ? 'application/pdf' : 'text/html,application/xhtml+xml',
      'User-Agent': 'BlueCrossMedical-RegulationSourceMonitor/1.0 (+https://www.bluecross.tech)',
    },
  });
  if (!response.ok) throw new Error(`HTTP ${response.status} for ${url}`);

  const bytes = Buffer.from(await response.arrayBuffer());
  if (expectedKind === 'pdf' && bytes.subarray(0, 4).toString('ascii') !== '%PDF') {
    throw new Error(`HTTP response was not a PDF: ${url}`);
  }
  return {
    bytes,
    finalUrl: response.url,
    headers: response.headers,
  };
}

async function convertPdfToText(pdfBytes, status) {
  const temporaryDirectory = await mkdtemp(path.join(tmpdir(), 'bluecross-paris-mou-'));
  const pdfPath = path.join(temporaryDirectory, `${status}.pdf`);
  const textPath = path.join(temporaryDirectory, `${status}.txt`);
  try {
    await writeFile(pdfPath, pdfBytes);
    await execFileAsync('pdftotext', ['-layout', pdfPath, textPath], {
      timeout: 30_000,
      maxBuffer: 2 * 1024 * 1024,
    });
    return await readFile(textPath, 'utf8');
  } catch (error) {
    if (error?.code === 'ENOENT') {
      throw new Error('pdftotext is required. Install poppler-utils before running the updater.');
    }
    throw error;
  } finally {
    await rm(temporaryDirectory, { recursive: true, force: true });
  }
}

async function readJsonIfPresent(filePath, fallback) {
  try {
    return JSON.parse(await readFile(filePath, 'utf8'));
  } catch (error) {
    if (error?.code === 'ENOENT') return fallback;
    throw error;
  }
}

function contentMetadata(resource) {
  return {
    final_url: resource.finalUrl,
    content_type: resource.headers.get('content-type'),
    etag: resource.headers.get('etag'),
    last_modified: resource.headers.get('last-modified'),
    byte_length: resource.bytes.length,
    sha256: sha256(resource.bytes),
  };
}

async function checkMedicalAuthoritySources(previousManifest) {
  const configuration = JSON.parse(await readFile(medicalSourcesPath, 'utf8'));
  const previousChecks = new Map(
    (previousManifest?.medical_authority_sources ?? []).map((entry) => [entry.id, entry]),
  );

  const checks = await Promise.all(configuration.sources.map(async (source) => {
    const previous = previousChecks.get(source.id);
    try {
      const resource = await fetchResource(source.url, 'pdf');
      const metadata = contentMetadata(resource);
      const changed = !previous
        || previous.sha256 !== metadata.sha256
        || previous.url !== source.url;
      return {
        id: source.id,
        title: source.title,
        url: source.url,
        applies_to: source.applies_to,
        check_status: 'ok',
        ...metadata,
        review_status: changed
          ? 'pending-review'
          : (previous.review_status ?? 'pending-review'),
      };
    } catch (error) {
      return {
        ...(previous ?? {}),
        id: source.id,
        title: source.title,
        url: source.url,
        applies_to: source.applies_to,
        check_status: 'unavailable',
        error_kind: classifyFetchError(error),
        review_status: previous?.review_status ?? 'pending-review',
      };
    }
  }));

  return {
    policy: configuration.policy,
    checks,
  };
}

function updateCurrentPointer(source, edition) {
  const importPattern = /import rawEdition from '\.\/\d{4}\.json';/;
  if (!importPattern.test(source)) {
    throw new Error('Could not locate the versioned Paris MoU import in current.ts');
  }
  return source.replace(importPattern, `import rawEdition from './${edition}.json';`);
}

async function atomicWrite(filePath, content) {
  await mkdir(path.dirname(filePath), { recursive: true });
  const temporaryPath = `${filePath}.${process.pid}.tmp`;
  await writeFile(temporaryPath, content, 'utf8');
  await rename(temporaryPath, filePath);
}

async function serializeJsonPreservingEquivalentFile(filePath, value) {
  const generated = stableJson(value);
  try {
    const existing = await readFile(filePath, 'utf8');
    if (stableJson(JSON.parse(existing)) === generated) return existing;
  } catch (error) {
    if (error?.code !== 'ENOENT') throw error;
  }
  return generated;
}

async function main() {
  await access(repositoryRoot, fsConstants.W_OK);
  const landingResource = await fetchResource(LANDING_PAGE_URL, 'html');
  const landingHtml = landingResource.bytes.toString('utf8');
  const discovery = discoverPdfSources(landingHtml, LANDING_PAGE_URL);

  const currentPointer = await readFile(currentPointerPath, 'utf8');
  const currentEditionMatch = currentPointer.match(/\.\/(\d{4})\.json/);
  const currentEdition = currentEditionMatch ? Number(currentEditionMatch[1]) : null;
  if (currentEdition && discovery.edition < currentEdition) {
    throw new Error(
      `Refusing to downgrade Paris MoU edition ${currentEdition} to ${discovery.edition}`,
    );
  }

  const statuses = ['white', 'grey', 'black'];
  const downloaded = Object.fromEntries(await Promise.all(statuses.map(async (status) => {
    const resource = await fetchResource(discovery.sources[status], 'pdf');
    const text = await convertPdfToText(resource.bytes, status);
    return [status, { resource, text }];
  })));

  const edition = buildEdition({
    edition: discovery.edition,
    sources: discovery.sources,
    texts: Object.fromEntries(statuses.map((status) => [status, downloaded[status].text])),
  });
  validateEdition(edition.entries, { edition: edition.edition });

  const previousManifest = await readJsonIfPresent(sourceManifestPath, {});
  const medical = skipMedicalChecks
    ? {
        policy: previousManifest.medical_source_policy,
        checks: previousManifest.medical_authority_sources ?? [],
      }
    : await checkMedicalAuthoritySources(previousManifest);

  const sourceManifest = {
    schema_version: 1,
    paris_mou: {
      edition: edition.edition,
      performance_period: edition.performance_period,
      valid_from: edition.valid_from,
      valid_until: edition.valid_until,
      landing_page_url: LANDING_PAGE_URL,
      sources: statuses.map((status) => ({
        id: `${status}-pdf`,
        status,
        url: discovery.sources[status],
        ...contentMetadata(downloaded[status].resource),
      })),
    },
    medical_source_policy: medical.policy,
    medical_authority_sources: medical.checks,
  };

  const datasetPath = path.join(dataDirectory, `${edition.edition}.json`);
  const datasetContent = await serializeJsonPreservingEquivalentFile(datasetPath, edition);
  const manifestContent = await serializeJsonPreservingEquivalentFile(
    sourceManifestPath,
    sourceManifest,
  );
  const writes = [
    [datasetPath, datasetContent],
    [sourceManifestPath, manifestContent],
    [currentPointerPath, updateCurrentPointer(currentPointer, edition.edition)],
  ];

  if (dryRun) {
    process.stdout.write(
      `Validated Paris MoU ${edition.edition}: 40 white, 19 grey, 10 black (dry run; no files written).\n`,
    );
    return;
  }

  for (const [filePath, content] of writes) await atomicWrite(filePath, content);
  process.stdout.write(
    `Updated Paris MoU ${edition.edition}: 40 white, 19 grey, 10 black. Medical source changes remain pending human review.\n`,
  );
}

main().catch((error) => {
  process.stderr.write(`${error.stack ?? error.message ?? String(error)}\n`);
  process.exitCode = 1;
});
