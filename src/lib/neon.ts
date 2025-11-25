import { neon } from '@neondatabase/serverless';

const databaseUrl = import.meta.env.VITE_NEON_DATABASE_URL;

if (!databaseUrl || databaseUrl.includes('YOUR_PASSWORD')) {
  console.warn('Missing or incomplete Neon database URL. Using fallback mode.');
}

// Create SQL query function
export const sql = databaseUrl && !databaseUrl.includes('YOUR_PASSWORD')
  ? neon(databaseUrl)
  : null;

export const isNeonConfigured = (): boolean => {
  return sql !== null;
};

// Helper to run queries safely
export async function query<T>(queryString: string, _params?: unknown[]): Promise<T[]> {
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
