import rawEdition from './2025.json';
import type { ParisMouStatus } from '../../lib/types';

export interface ParisMouSource {
  id: string;
  status: Exclude<ParisMouStatus, 'not-listed'>;
  url: string;
}

export interface ParisMouEntry {
  rank: number;
  iso_code: string;
  display_name: string;
  status: Exclude<ParisMouStatus, 'not-listed'>;
  inspections: number;
  detentions: number;
  source_id: string;
}

export interface ParisMouEdition {
  schema_version: number;
  edition: number;
  performance_period: string;
  valid_from: string;
  valid_until: string;
  publisher: string;
  landing_page_url: string;
  sources: ParisMouSource[];
  entries: ParisMouEntry[];
}

/** The edition displayed by the application. Updated only through a review PR. */
export const CURRENT_PARIS_MOU_EDITION = rawEdition as ParisMouEdition;

