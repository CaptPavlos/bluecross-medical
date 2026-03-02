/**
 * Neon Database Client
 *
 * Serverless PostgreSQL client for Neon database.
 * Falls back gracefully when database URL is not configured.
 *
 * @module lib/neon
 */
import { neon } from '@neondatabase/serverless';

const databaseUrl = import.meta.env.VITE_NEON_DATABASE_URL;

if (!databaseUrl || databaseUrl.includes('YOUR_PASSWORD')) {
  console.warn('Missing or incomplete Neon database URL. Using fallback mode.');
}

/** SQL query function, null if database not configured */
export const sql = databaseUrl && !databaseUrl.includes('YOUR_PASSWORD')
  ? neon(databaseUrl)
  : null;

/**
 * Check if Neon database is properly configured.
 * @returns true if database connection is available
 */
export const isNeonConfigured = (): boolean => {
  return sql !== null;
};

/**
 * Execute a SQL query safely with fallback for unconfigured database.
 * @param queryString - SQL query to execute
 * @returns Query results or empty array if database unavailable
 */
export async function query<T>(queryString: string): Promise<T[]> {
  if (!sql) {
    console.warn('Neon not configured, query skipped:', queryString);
    return [];
  }
  
  try {
    // Use sql as a tagged template literal
    const result = await sql`${queryString}`;
    return result as T[];
  } catch (error) {
    console.error('Neon query error:', error);
    throw error;
  }
}
