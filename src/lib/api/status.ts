import { supabase, isSupabaseConfigured } from '../supabase';
import { MOCK_SYSTEM_STATUS } from '../constants';
import type { SystemStatus } from '../types';

export async function getSystemStatus(): Promise<SystemStatus> {
  if (!isSupabaseConfigured()) {
    return MOCK_SYSTEM_STATUS;
  }

  const { data, error } = await supabase!
    .from('system_status')
    .select('*')
    .order('updated_at', { ascending: false })
    .limit(1)
    .single();

  if (error) {
    console.error('Error fetching system status:', error);
    return MOCK_SYSTEM_STATUS;
  }

  return data || MOCK_SYSTEM_STATUS;
}

export async function subscribeToStatus(
  callback: (status: SystemStatus) => void
): Promise<() => void> {
  if (!isSupabaseConfigured()) {
    // No-op for demo mode
    return () => {};
  }

  const channel = supabase!
    .channel('system_status_changes')
    .on(
      'postgres_changes',
      { event: '*', schema: 'public', table: 'system_status' },
      (payload) => {
        callback(payload.new as SystemStatus);
      }
    )
    .subscribe();

  // Return unsubscribe function
  return () => {
    supabase!.removeChannel(channel);
  };
}
