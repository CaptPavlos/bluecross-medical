import { motion } from 'framer-motion';
import { Mail, Linkedin, Twitter, Github } from 'lucide-react';
import Card from '../Common/Card';
import type { Team } from '../../lib/types';

/**
 * Props for the TeamCard component.
 */
interface TeamCardProps {
  member: Team;
  index?: number;
}

/**
 * Team member profile card with avatar, role, bio, and social links.
 * Features staggered animation on initial render.
 * @param member - Team member data to display
 * @param index - Position in list for animation delay
 */
function TeamCard({ member, index = 0 }: TeamCardProps) {
  const socialIcons = {
    linkedin: Linkedin,
    twitter: Twitter,
    github: Github,
  };

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: index * 0.1 }}
    >
      <Card hoverable className="text-center">
        {/* Avatar */}
        <div className="w-24 h-24 mx-auto mb-4 rounded-full overflow-hidden bg-surface-secondary">
          {member.image_url ? (
            <img
              src={member.image_url}
              alt={member.name}
              className="w-full h-full object-cover"
            />
          ) : (
            <div className="w-full h-full flex items-center justify-center text-brand-ocean text-2xl font-bold">
              {member.name.charAt(0)}
            </div>
          )}
        </div>

        {/* Info */}
        <h3 className="text-h3 font-semibold text-brand-slate mb-1">
          {member.name}
        </h3>
        <p className="text-brand-ocean font-medium mb-3">{member.role}</p>
        
        {member.bio && (
          <p className="text-brand-gray text-sm mb-4 line-clamp-3">
            {member.bio}
          </p>
        )}

        {/* Social links */}
        <div className="flex items-center justify-center gap-3">
          {member.email && (
            <a
              href={`mailto:${member.email}`}
              className="p-2 text-brand-gray hover:text-brand-ocean hover:bg-brand-ocean/10 rounded-full transition-colors"
              aria-label={`Email ${member.name}`}
            >
              <Mail size={18} />
            </a>
          )}
          {member.social_links && Object.entries(member.social_links).map(([platform, url]) => {
            const Icon = socialIcons[platform as keyof typeof socialIcons];
            if (!Icon || !url) return null;
            return (
              <a
                key={platform}
                href={url}
                target="_blank"
                rel="noopener noreferrer"
                className="p-2 text-brand-gray hover:text-brand-ocean hover:bg-brand-ocean/10 rounded-full transition-colors"
                aria-label={`${member.name} on ${platform}`}
              >
                <Icon size={18} />
              </a>
            );
          })}
        </div>
      </Card>
    </motion.div>
  );
}

export default TeamCard;
