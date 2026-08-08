import { createHash } from 'node:crypto';

export const LANDING_PAGE_URL =
  'https://parismou.org/Statistics%26Current-Lists/white-grey-and-black-list';

export const STATUS_ORDER = Object.freeze(['white', 'grey', 'black']);

const EDITION_EXPECTATIONS = Object.freeze({
  2025: Object.freeze({
    counts: Object.freeze({ white: 40, grey: 19, black: 10 }),
    knownRows: Object.freeze([
      Object.freeze(['KY', 1, 'white']),
      Object.freeze(['SE', 2, 'white']),
      Object.freeze(['FR', 7, 'white']),
      Object.freeze(['PA', 36, 'white']),
      Object.freeze(['KR', 41, 'grey']),
      Object.freeze(['EG', 53, 'grey']),
      Object.freeze(['CM', 69, 'black']),
    ]),
  }),
});

const ISO_BY_OFFICIAL_NAME = new Map(Object.entries({
  'Cayman Islands, UK': 'KY',
  Sweden: 'SE',
  Norway: 'NO',
  Denmark: 'DK',
  Japan: 'JP',
  Singapore: 'SG',
  France: 'FR',
  Finland: 'FI',
  Netherlands: 'NL',
  Luxembourg: 'LU',
  Italy: 'IT',
  'Hong Kong (China)': 'HK',
  Germany: 'DE',
  Portugal: 'PT',
  Bahamas: 'BS',
  Malta: 'MT',
  'Isle of Man, UK': 'IM',
  'Bermuda, UK': 'BM',
  China: 'CN',
  'United States': 'US',
  'Marshall Islands': 'MH',
  Cyprus: 'CY',
  Spain: 'ES',
  'United Kingdom': 'GB',
  Greece: 'GR',
  'Saudi Arabia': 'SA',
  Ireland: 'IE',
  'Gibraltar, UK': 'GI',
  Liberia: 'LR',
  Croatia: 'HR',
  Barbados: 'BB',
  Türkiye: 'TR',
  Estonia: 'EE',
  'Jersey, UK': 'JE',
  'Antigua and Barbuda': 'AG',
  Panama: 'PA',
  'Faroe Islands': 'FO',
  Belgium: 'BE',
  Poland: 'PL',
  Canada: 'CA',
  'Korea, Republic of': 'KR',
  Lithuania: 'LT',
  Latvia: 'LV',
  India: 'IN',
  Morocco: 'MA',
  'San Marino': 'SM',
  Algeria: 'DZ',
  'Sierra Leone': 'SL',
  Thailand: 'TH',
  'Russian Federation': 'RU',
  Lebanon: 'LB',
  Philippines: 'PH',
  Egypt: 'EG',
  'Saint Vincent and the Grenadines': 'VC',
  'Cook Islands': 'CK',
  Albania: 'AL',
  Bangladesh: 'BD',
  Tuvalu: 'TV',
  Tunisia: 'TN',
  'Saint Kitts and Nevis': 'KN',
  Palau: 'PW',
  Togo: 'TG',
  'Guinea-Bissau': 'GW',
  Belize: 'BZ',
  Vanuatu: 'VU',
  'Viet Nam': 'VN',
  Comoros: 'KM',
  'Tanzania, United Republic of': 'TZ',
  Cameroon: 'CM',
}));

const MONTHS = Object.freeze({
  january: 1,
  february: 2,
  march: 3,
  april: 4,
  may: 5,
  june: 6,
  july: 7,
  august: 8,
  september: 9,
  october: 10,
  november: 11,
  december: 12,
});

function decodeHtmlEntities(value) {
  return value
    .replaceAll('&amp;', '&')
    .replaceAll('&#39;', "'")
    .replaceAll('&quot;', '"');
}

function stripHtml(value) {
  return decodeHtmlEntities(value.replace(/<[^>]+>/g, ' ').replace(/\s+/g, ' ').trim());
}

function toIsoDate(day, monthName, year) {
  const month = MONTHS[monthName.toLowerCase()];
  if (!month) throw new Error(`Unknown month in validity period: ${monthName}`);
  return `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
}

export function resolveIsoCode(officialName) {
  const isoCode = ISO_BY_OFFICIAL_NAME.get(officialName.trim());
  if (!isoCode) {
    throw new Error(`Unknown Paris MoU flag alias: ${officialName}`);
  }
  return isoCode;
}

export function discoverPdfSources(html, baseUrl = LANDING_PAGE_URL) {
  const anchors = [...html.matchAll(/<a\b[^>]*\bhref\s*=\s*(['"])(.*?)\1[^>]*>([\s\S]*?)<\/a>/gi)]
    .map((match) => ({
      url: new URL(decodeHtmlEntities(match[2]), baseUrl).href,
      label: stripHtml(match[3]),
    }));

  const sources = {};
  const editions = new Set();

  for (const status of STATUS_ORDER) {
    const candidates = anchors.filter(({ url }) => {
      const parsed = new URL(url);
      const normalizedFileName = decodeURIComponent(parsed.pathname)
        .split('/')
        .at(-1)
        ?.toLowerCase()
        .replace(/[^a-z0-9]/g, '');
      return normalizedFileName?.includes(`${status}list`) && normalizedFileName.endsWith('pdf');
    });

    const officialCandidates = candidates.filter(({ url }) => {
      const parsed = new URL(url);
      return parsed.hostname === 'parismou.org' || parsed.hostname.endsWith('.parismou.org');
    });

    if (officialCandidates.length !== 1) {
      throw new Error(
        `Expected one official ${status} list PDF, found ${officialCandidates.length}`,
      );
    }

    const source = officialCandidates[0];
    const editionMatch = `${source.url} ${source.label}`.match(/Paris(?:%20|\s)+MoU(?:%20|\s)+(\d{4})/i);
    if (!editionMatch) throw new Error(`Could not determine edition from ${source.url}`);
    editions.add(Number(editionMatch[1]));
    sources[status] = source.url;
  }

  if (editions.size !== 1) {
    throw new Error(`Performance PDF editions do not agree: ${[...editions].join(', ')}`);
  }

  return { edition: [...editions][0], sources };
}

export function parsePerformancePdfText(text, status, { edition } = {}) {
  if (!STATUS_ORDER.includes(status)) throw new Error(`Unknown performance status: ${status}`);

  const entries = [];
  for (const rawLine of text.replaceAll('\u00a0', ' ').split(/\r?\n/)) {
    const match = rawLine.match(
      /^\s*(\d+)\s+(.+?)\s+([\d,]+)\s+([\d,]+)\s+([\d,]+)(?:\s|$)/,
    );
    if (!match) continue;

    const rank = Number(match[1]);
    const displayName = match[2].replace(/\s+/g, ' ').trim();
    const parseInteger = (value) => Number(value.replaceAll(',', ''));
    entries.push({
      rank,
      iso_code: resolveIsoCode(displayName),
      display_name: displayName,
      status,
      inspections: parseInteger(match[3]),
      detentions: parseInteger(match[4]),
      source_id: `${status}-pdf`,
    });
  }

  if (entries.length === 0) {
    throw new Error(`Parsed no ${status} rows. Refusing a partial update.`);
  }

  const expectedCount = EDITION_EXPECTATIONS[edition]?.counts[status];
  if (expectedCount !== undefined && entries.length !== expectedCount) {
    throw new Error(
      `Parsed ${entries.length} ${status} rows; expected ${expectedCount}. Refusing a partial update.`,
    );
  }
  return entries;
}

export function extractValidityPeriod(text) {
  const match = text.match(
    /valid:\s*(\d{1,2})\s+([A-Za-z]+)\s+(\d{4})\s+until\s+(\d{1,2})\s+([A-Za-z]+)\s+(\d{4})/i,
  );
  if (!match) throw new Error('Could not parse the Paris MoU validity period');
  return {
    valid_from: toIsoDate(match[1], match[2], match[3]),
    valid_until: toIsoDate(match[4], match[5], match[6]),
  };
}

export function extractPerformancePeriod(text) {
  const periods = [...text.matchAll(/\b(20\d{2})-(20\d{2})\b/g)]
    .map((match) => `${match[1]}-${match[2]}`);
  const uniquePeriods = [...new Set(periods)];
  if (uniquePeriods.length !== 1) {
    throw new Error(`Expected one performance period, found: ${uniquePeriods.join(', ') || 'none'}`);
  }
  return uniquePeriods[0];
}

export function validateEdition(entries, { edition } = {}) {
  const errors = [];
  if (entries.length === 0) errors.push('edition must contain at least one entry');

  const ranks = entries.map(({ rank }) => rank).sort((a, b) => a - b);
  const expectedRanks = Array.from({ length: entries.length }, (_, index) => index + 1);
  if (ranks.some((rank, index) => rank !== expectedRanks[index])) {
    errors.push(`ranks must be unique and contiguous from 1 through ${entries.length}`);
  }

  const isoCodes = new Set(entries.map(({ iso_code: isoCode }) => isoCode));
  if (isoCodes.size !== entries.length) errors.push('ISO codes must be unique');

  for (const status of STATUS_ORDER) {
    const statusEntries = entries.filter((entry) => entry.status === status);
    if (statusEntries.length === 0) errors.push(`${status} block must not be empty`);
  }

  const statusIndexes = new Map(STATUS_ORDER.map((status, index) => [status, index]));
  const rankedEntries = [...entries].sort((a, b) => a.rank - b.rank);
  for (let index = 1; index < rankedEntries.length; index += 1) {
    const previousStatusIndex = statusIndexes.get(rankedEntries[index - 1].status);
    const currentStatusIndex = statusIndexes.get(rankedEntries[index].status);
    if (previousStatusIndex === undefined || currentStatusIndex === undefined) {
      errors.push('entries contain an unknown performance status');
      break;
    }
    if (currentStatusIndex < previousStatusIndex) {
      errors.push('status blocks must be ordered white, grey, then black by global rank');
      break;
    }
  }

  const expectation = EDITION_EXPECTATIONS[edition];
  if (expectation) {
    const expectedTotal = Object.values(expectation.counts).reduce((sum, count) => sum + count, 0);
    if (entries.length !== expectedTotal) {
      errors.push(`expected ${expectedTotal} entries for edition ${edition}, found ${entries.length}`);
    }
    for (const status of STATUS_ORDER) {
      const actualCount = entries.filter((entry) => entry.status === status).length;
      const expectedCount = expectation.counts[status];
      if (actualCount !== expectedCount) {
        errors.push(`expected ${expectedCount} ${status} entries for edition ${edition}, found ${actualCount}`);
      }
    }
    for (const [isoCode, rank, status] of expectation.knownRows) {
      const row = entries.find((entry) => entry.iso_code === isoCode);
      if (!row || row.rank !== rank || row.status !== status) {
        errors.push(`known ${edition} row ${isoCode} must be ${status} rank ${rank}`);
      }
    }
  }

  if (errors.length) throw new Error(`Invalid Paris MoU edition: ${errors.join('; ')}`);
  return true;
}

export function buildEdition({ edition, sources, texts }) {
  const statuses = STATUS_ORDER;
  const entries = statuses.flatMap((status) => parsePerformancePdfText(
    texts[status],
    status,
    { edition },
  ));
  validateEdition(entries, { edition });

  const validityPeriods = statuses.map((status) => extractValidityPeriod(texts[status]));
  const uniqueValidity = new Set(validityPeriods.map((period) => JSON.stringify(period)));
  if (uniqueValidity.size !== 1) throw new Error('Performance PDFs have different validity periods');

  const performancePeriods = new Set(statuses.map((status) => extractPerformancePeriod(texts[status])));
  if (performancePeriods.size !== 1) throw new Error('Performance PDFs have different data periods');

  const validity = validityPeriods[0];
  return {
    schema_version: 1,
    edition,
    performance_period: [...performancePeriods][0],
    ...validity,
    publisher: 'Paris Memorandum of Understanding on Port State Control',
    landing_page_url: LANDING_PAGE_URL,
    sources: statuses.map((status) => ({
      id: `${status}-pdf`,
      status,
      url: sources[status],
    })),
    entries,
  };
}

export function sha256(content) {
  return createHash('sha256').update(content).digest('hex');
}

export function stableJson(value) {
  return `${JSON.stringify(value, null, 2)}\n`;
}
