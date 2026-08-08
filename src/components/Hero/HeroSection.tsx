import { Link } from 'react-router-dom';
import { ArrowRight, Flag, Database, Ship } from 'lucide-react';
import { motion } from 'framer-motion';
import Container from '../Common/Container';
import { COMPANY_INFO } from '../../lib/constants';

/**
 * Animated text component that highlights a specific word with color and underline.
 * @param text - Full text string to display
 * @param highlightWord - Word within text to highlight with red color and underline
 */
function HighlightedText({ text, highlightWord }: { text: string; highlightWord: string }) {
  const parts = text.split(highlightWord);
  
  return (
    <motion.span
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.8, ease: "easeOut" }}
    >
      {parts[0]}
      <span className="relative inline-block">
        <motion.span
          initial={{ color: "#ffffff" }}
          animate={{ color: "#ef4444" }}
          transition={{ delay: 1, duration: 0.3 }}
        >
          {highlightWord}
        </motion.span>
        <motion.svg 
          className="absolute -bottom-2 left-0 w-full h-3"
          viewBox="0 0 100 12" 
          preserveAspectRatio="none"
          initial={{ opacity: 0, pathLength: 0 }}
          animate={{ opacity: 1, pathLength: 1 }}
          transition={{ delay: 1.2, duration: 0.5, ease: "easeOut" }}
        >
          <motion.path 
            d="M2 8 Q 15 2, 30 7 T 55 6 T 80 8 T 98 5" 
            fill="none" 
            stroke="#ef4444" 
            strokeWidth="2.5"
            strokeLinecap="round"
            initial={{ pathLength: 0 }}
            animate={{ pathLength: 1 }}
            transition={{ delay: 1.2, duration: 0.5, ease: "easeOut" }}
          />
        </motion.svg>
      </span>
      {parts[1]}
    </motion.span>
  );
}

/**
 * Full-height hero section component for the homepage.
 * Features animated title, call-to-action buttons, and flag state preview cards.
 * Includes decorative gradient background and blur effects.
 */
function HeroSection() {
  const features = [
    { icon: Flag, text: 'Current Official Rankings' },
    { icon: Database, text: 'Knowledge Base' },
    { icon: Ship, text: 'Tested Equipment' },
  ];

  return (
    <section className="relative flex min-h-[calc(100svh-4rem)] items-center overflow-hidden pb-8 pt-16 sm:pb-20 sm:pt-20 md:min-h-[90vh] md:pb-32">
      {/* Background - Deep ocean gradient */}
      <div className="absolute inset-0 bg-gradient-to-b from-brand-navy via-brand-blue to-brand-navy" />
      
      {/* Decorative ocean elements */}
      <div className="absolute top-1/4 right-0 w-96 h-96 bg-brand-ocean/20 rounded-full blur-3xl" />
      <div className="absolute bottom-1/3 left-0 w-64 h-64 bg-brand-sky/10 rounded-full blur-2xl" />

      <Container className="relative z-10">
        <div className="grid items-center gap-8 lg:grid-cols-2 lg:gap-12">
          {/* Content */}
          <div className="animate-fade-in">
            <span className="mb-3 inline-block rounded-full border border-brand-ocean/50 bg-brand-ocean/30 px-4 py-1.5 text-sm font-medium text-brand-sky sm:mb-6">
              🚑 Emergency medicine at sea
            </span>
            
            <h1 className="mb-3 text-display font-bold leading-tight text-white sm:mb-6 md:text-5xl lg:text-6xl">
              <HighlightedText text={COMPANY_INFO.tagline} highlightWord="Emergency" />
            </h1>
            
            <p className="mb-4 max-w-lg text-base text-brand-sky-light/90 sm:mb-8 sm:text-lg md:text-xl">
              {COMPANY_INFO.description}
            </p>

            <div className="mb-6 flex flex-col gap-3 sm:mb-10 sm:flex-row sm:gap-4">
              <Link
                to="/flags"
                className="inline-flex min-h-12 items-center justify-center gap-2 rounded-md bg-brand-ocean px-6 py-3 text-base font-medium text-white shadow-md transition-colors hover:bg-brand-ocean-light focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-brand-sky focus-visible:ring-offset-2 focus-visible:ring-offset-brand-navy"
              >
                Browse Flag Database
                <ArrowRight size={20} aria-hidden="true" />
              </Link>
              <Link
                to="/products"
                className="inline-flex min-h-12 items-center justify-center rounded-md border-2 border-brand-sky px-6 py-3 text-base font-medium text-brand-sky transition-colors hover:bg-brand-sky hover:text-brand-navy focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-brand-sky focus-visible:ring-offset-2 focus-visible:ring-offset-brand-navy"
              >
                View Equipment
              </Link>
            </div>

            {/* Feature badges */}
            <div className="flex flex-wrap gap-4 sm:gap-6">
              {features.map((feature, index) => (
                <div
                  key={index}
                  className="flex items-center space-x-2 text-brand-sky-light"
                >
                  <feature.icon size={18} className="text-brand-ocean" />
                  <span className="text-sm">{feature.text}</span>
                </div>
              ))}
            </div>
          </div>

          {/* Visual - Flag cards */}
          <div className="hidden lg:block animate-slide-up">
            <div className="relative">
              <div className="grid grid-cols-2 gap-4">
                {['🇲🇹 Malta', '🇨🇾 Cyprus', '🇬🇷 Greece', '🇬🇧 UK', '🇵🇦 Panama', '🇱🇷 Liberia'].map((flag, i) => (
                  <div 
                    key={i}
                    className="bg-brand-navy/80 border border-brand-ocean/30 rounded-xl p-4 text-center backdrop-blur-sm hover:border-brand-ocean/60 transition-colors"
                  >
                    <span className="text-2xl">{flag.split(' ')[0]}</span>
                    <div className="text-white font-medium mt-2">{flag.split(' ')[1]}</div>
                    <div className="text-brand-sky text-xs mt-1">Medical Requirements</div>
                  </div>
                ))}
              </div>
              {/* Overlay badge */}
              <div className="absolute -bottom-4 -left-4 bg-brand-navy border border-brand-ocean/50 rounded-xl p-4 shadow-lg">
                <div className="flex items-center space-x-3">
                  <div className="w-12 h-12 bg-brand-ocean/20 rounded-lg flex items-center justify-center">
                    <Database className="w-6 h-6 text-brand-ocean" />
                  </div>
                  <div>
                    <div className="text-white font-semibold">Flag-State Records</div>
                    <div className="text-brand-sky text-sm">Performance + Medical Review</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </Container>
    </section>
  );
}

export default HeroSection;
