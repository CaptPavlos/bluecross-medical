import { useState, useEffect } from 'react';
import { getTeamMembers } from '../../lib/api/teams';
import type { Team } from '../../lib/types';
import TeamCard from './TeamCard';
import { SkeletonTeamCard } from '../Common/Skeleton';

/**
 * Props for the TeamGrid component.
 */
interface TeamGridProps {
  limit?: number;
}

/**
 * Responsive grid layout for displaying team member cards.
 * Handles data fetching, loading states, and empty states.
 * @param limit - Maximum number of team members to display
 */
function TeamGrid({ limit }: TeamGridProps) {
  const [team, setTeam] = useState<Team[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchTeam = async () => {
      setIsLoading(true);
      try {
        const data = await getTeamMembers();
        setTeam(limit ? data.slice(0, limit) : data);
      } catch (error) {
        console.error('Error fetching team:', error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchTeam();
  }, [limit]);

  if (isLoading) {
    return (
      <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-6">
        {Array.from({ length: limit || 4 }).map((_, i) => (
          <SkeletonTeamCard key={i} />
        ))}
      </div>
    );
  }

  if (team.length === 0) {
    return (
      <div className="text-center py-12 text-brand-gray">
        No team members found.
      </div>
    );
  }

  return (
    <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-6">
      {team.map((member, index) => (
        <TeamCard key={member.id} member={member} index={index} />
      ))}
    </div>
  );
}

export default TeamGrid;
