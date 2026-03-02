import { supabase, isSupabaseConfigured } from '../supabase';
import { MOCK_TEAM } from '../constants';
import type { Team } from '../types';

/**
 * Fetches all active team members.
 * Falls back to mock data if Supabase is not configured.
 * @returns Array of active team members ordered by display index
 */
export async function getTeamMembers(): Promise<Team[]> {
  if (!isSupabaseConfigured()) {
    // Return mock data when Supabase is not configured
    return MOCK_TEAM;
  }

  const { data, error } = await supabase!
    .from('teams')
    .select('*')
    .eq('active', true)
    .order('order_index', { ascending: true });

  if (error) {
    console.error('Error fetching team members:', error);
    return MOCK_TEAM;
  }

  return data || MOCK_TEAM;
}

/**
 * Fetches a single team member by their unique ID.
 * Falls back to mock data if Supabase is not configured.
 * @param id - Unique identifier for the team member
 * @returns The matching team member or null if not found
 */
export async function getTeamMemberById(id: string): Promise<Team | null> {
  if (!isSupabaseConfigured()) {
    return MOCK_TEAM.find(member => member.id === id) || null;
  }

  const { data, error } = await supabase!
    .from('teams')
    .select('*')
    .eq('id', id)
    .single();

  if (error) {
    console.error('Error fetching team member:', error);
    return null;
  }

  return data;
}
