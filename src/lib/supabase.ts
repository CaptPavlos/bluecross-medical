import { createClient } from '@supabase/supabase-js';

/** Supabase project URL from environment variables */
const supabaseUrl = import.meta.env.VITE_SUPABASE_URL;
/** Supabase anonymous key for public operations */
const supabaseAnonKey = import.meta.env.VITE_SUPABASE_ANON_KEY;

if (!supabaseUrl || !supabaseAnonKey) {
  console.warn('Missing Supabase environment variables. Using mock data.');
}

/**
 * Supabase client instance for database operations.
 * Returns null if environment variables are not configured.
 */
export const supabase = supabaseUrl && supabaseAnonKey
  ? createClient(supabaseUrl, supabaseAnonKey, {
      auth: {
        persistSession: true,
        detectSessionInUrl: true,
      },
    })
  : null;

/**
 * Checks if Supabase is properly configured with environment variables.
 * @returns True if Supabase client is available, false otherwise
 */
export const isSupabaseConfigured = (): boolean => {
  return supabase !== null;
};
