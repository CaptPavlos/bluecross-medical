import { useState } from 'react';
import { motion, useReducedMotion } from 'framer-motion';
import { ArrowUpRight, Github, Linkedin, Mail, Twitter } from 'lucide-react';
import type { Team } from '../../lib/types';

interface TeamCardProps {
  member: Team;
  index?: number;
}

const socialIcons = {
  linkedin: Linkedin,
  twitter: Twitter,
  github: Github,
};

function getInitials(name: string) {
  return name
    .split(/[\s-]+/)
    .filter(Boolean)
    .slice(0, 2)
    .map((part) => part[0])
    .join('')
    .toUpperCase();
}

/** Team profile with a resilient portrait fallback and complete biography. */
function TeamCard({ member, index = 0 }: TeamCardProps) {
  const [failedImageUrl, setFailedImageUrl] = useState<string | null>(null);
  const reduceMotion = useReducedMotion();
  const showImage = Boolean(member.image_url) && failedImageUrl !== member.image_url;

  return (
    <motion.article
      initial={reduceMotion ? false : { opacity: 0, y: 18 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.45, delay: reduceMotion ? 0 : index * 0.08 }}
      className="group flex h-full flex-col rounded-[1.75rem] border border-sky-100 bg-white p-3 shadow-[0_18px_55px_rgba(15,45,70,0.07)]"
    >
      <div className="relative grid min-h-56 place-items-center overflow-hidden rounded-[1.25rem] bg-gradient-to-br from-sky-100 via-cyan-50 to-white">
        <div className="absolute h-56 w-56 rounded-full border border-brand-ocean/10" />
        <div className="absolute h-80 w-80 rounded-full border border-brand-ocean/5" />

        {showImage ? (
          <img
            src={member.image_url}
            alt={member.name}
            onError={() => setFailedImageUrl(member.image_url ?? null)}
            className="relative z-10 h-36 w-36 rounded-full border-4 border-white object-cover shadow-xl transition-transform duration-500 group-hover:scale-[1.03]"
          />
        ) : (
          <div
            className="relative z-10 grid h-28 w-28 place-items-center rounded-full bg-brand-navy text-3xl font-bold tracking-tight text-white shadow-xl"
            role="img"
            aria-label={`${member.name} initials`}
          >
            {getInitials(member.name)}
          </div>
        )}

        <span className="absolute right-5 top-5 text-xs font-bold tracking-[0.18em] text-brand-ocean/60">
          {String(index + 1).padStart(2, '0')}
        </span>
      </div>

      <div className="flex flex-1 flex-col px-4 pb-4 pt-7">
        <p className="mb-2 text-xs font-bold uppercase tracking-[0.1em] text-brand-ocean">
          {member.role}
        </p>
        <h3 className="text-2xl font-bold leading-tight tracking-[-0.03em] text-brand-navy">
          {member.name}
        </h3>

        {member.bio && (
          <p className="mb-6 mt-4 flex-1 text-sm leading-6 text-brand-gray">
            {member.bio}
          </p>
        )}

        <div className="flex flex-wrap items-center gap-2 border-t border-sky-100 pt-4">
          {member.email && (
            <a
              href={`mailto:${member.email}`}
              className="inline-flex min-h-11 items-center gap-2 rounded-full bg-brand-navy px-4 text-sm font-semibold text-white hover:bg-brand-blue"
              aria-label={`Email ${member.name}`}
            >
              <Mail size={16} aria-hidden="true" />
              Email
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
                className="inline-flex min-h-11 items-center gap-2 rounded-full border border-sky-200 px-4 text-sm font-semibold capitalize text-brand-navy hover:border-brand-ocean hover:text-brand-ocean"
                aria-label={`${member.name} on ${platform}`}
              >
                <Icon size={16} aria-hidden="true" />
                {platform}
                <ArrowUpRight size={14} aria-hidden="true" />
              </a>
            );
          })}
        </div>
      </div>
    </motion.article>
  );
}

export default TeamCard;
