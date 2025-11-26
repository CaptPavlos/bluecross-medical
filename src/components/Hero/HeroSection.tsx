import { Link } from 'react-router-dom';
import { ArrowRight, Flag, Database, Ship } from 'lucide-react';
import { motion } from 'framer-motion';
import Container from '../Common/Container';
import Button from '../Common/Button';
import { COMPANY_INFO } from '../../lib/constants';

// Highlight word component with fade effect and delayed red color + underline
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

function HeroSection() {
  const features = [
    { icon: Flag, text: '62 Flag States' },
    { icon: Database, text: 'Knowledge Base' },
    { icon: Ship, text: 'Tested Equipment' },
  ];

  return (
    <section className="relative min-h-[90vh] flex items-center pt-20 pb-32 overflow-hidden">
      {/* Background - Deep ocean gradient */}
      <div className="absolute inset-0 bg-gradient-to-b from-brand-navy via-brand-blue to-brand-navy" />
      
      {/* Decorative ocean elements */}
      <div className="absolute top-1/4 right-0 w-96 h-96 bg-brand-ocean/20 rounded-full blur-3xl" />
      <div className="absolute bottom-1/3 left-0 w-64 h-64 bg-brand-sky/10 rounded-full blur-2xl" />

      <Container className="relative z-10">
        <div className="grid lg:grid-cols-2 gap-12 items-center">
          {/* Content */}
          <div className="animate-fade-in">
            <span className="inline-block px-4 py-1.5 bg-brand-ocean/30 text-brand-sky border border-brand-ocean/50 rounded-full text-sm font-medium mb-6">
              🚑 Everything for Emergency Medicine at Sea
            </span>
            
            <h1 className="text-display md:text-5xl lg:text-6xl font-bold text-white mb-6 leading-tight">
              <HighlightedText text={COMPANY_INFO.tagline} highlightWord="Emergency" />
            </h1>
            
            <p className="text-lg md:text-xl text-brand-sky-light/90 mb-8 max-w-lg">
              {COMPANY_INFO.description}
            </p>

            <div className="flex flex-col sm:flex-row gap-4 mb-10">
              <Link to="/flags">
                <Button size="lg" rightIcon={<ArrowRight size={20} />}>
                  Browse Flag Database
                </Button>
              </Link>
              <Link to="/products">
                <Button variant="outline" size="lg" className="border-brand-sky text-brand-sky hover:bg-brand-sky hover:text-brand-navy">
                  View Equipment
                </Button>
              </Link>
            </div>

            {/* Feature badges */}
            <div className="flex flex-wrap gap-6">
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
                    <div className="text-white font-semibold">62 Flag States</div>
                    <div className="text-brand-sky text-sm">Medical Regulations</div>
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
