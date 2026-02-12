/**
 * @fileoverview Homepage component with hero section and feature highlights.
 */
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { useState, useEffect, useRef } from 'react';
import { ArrowRight, Anchor, Heart, AlertTriangle, GraduationCap, ChevronDown, ChevronUp } from 'lucide-react';
import { HeroSection } from '../components/Hero';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { SEOHead } from '../components/SEO';

/**
 * Homepage with hero section, statistics, and call-to-action sections.
 * Features scroll-triggered animations and expandable content sections.
 */
function Home() {
  const [showMoreStats, setShowMoreStats] = useState(false);
  const [showTrainingDetails, setShowTrainingDetails] = useState(false);
  const trainingGapRef = useRef<HTMLElement>(null);
  const heartDiseaseRef = useRef<HTMLElement>(null);
  const [hasOpenedTraining, setHasOpenedTraining] = useState(false);
  const [hasOpenedStats, setHasOpenedStats] = useState(false);

  // Auto-open sections when scrolled into view
  useEffect(() => {
    const trainingObserver = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting && !hasOpenedTraining) {
            setShowTrainingDetails(true);
            setHasOpenedTraining(true);
          }
        });
      },
      { threshold: 0.3 }
    );

    const statsObserver = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting && !hasOpenedStats) {
            setShowMoreStats(true);
            setHasOpenedStats(true);
          }
        });
      },
      { threshold: 0.4 }
    );

    if (trainingGapRef.current) {
      trainingObserver.observe(trainingGapRef.current);
    }
    if (heartDiseaseRef.current) {
      statsObserver.observe(heartDiseaseRef.current);
    }

    return () => {
      trainingObserver.disconnect();
      statsObserver.disconnect();
    };
  }, [hasOpenedTraining, hasOpenedStats]);

  // AED requirement data by flag state
  const aedData = [
    { flag: '🇲🇹 Malta', required: true, percentage: 100 },
    { flag: '🇨🇾 Cyprus', required: true, percentage: 100 },
    { flag: '🇬🇧 UK', required: true, percentage: 100 },
    { flag: '🇳🇴 Norway', required: true, percentage: 100 },
    { flag: '🇩🇰 Denmark', required: true, percentage: 100 },
    { flag: '🇵🇦 Panama', required: false, percentage: 0 },
    { flag: '🇱🇷 Liberia', required: false, percentage: 0 },
    { flag: '🇲🇭 Marshall Is.', required: false, percentage: 0 },
  ];

  return (
    <main>
      <SEOHead 
        url="/"
        title="Maritime Emergency Medicine"
        description="Your complete resource for emergency medicine at sea. Flag state regulations, advanced training courses, knowledge articles, and tested equipment for yachts and commercial vessels."
        keywords={['maritime medicine', 'emergency medicine at sea', 'yacht medical', 'superyacht medical', 'flag state regulations']}
      />
      
      {/* Hero Section */}
      <HeroSection />

      {/* Heart Disease Statistics Section */}
      <section className="py-16 md:py-20 bg-gradient-to-br from-red-50 to-white border-y border-red-100" ref={heartDiseaseRef}>
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-50px" }}
            transition={{ duration: 0.5 }}
          >
            <div className="flex items-center gap-3 mb-6">
              <motion.div 
                className="w-12 h-12 bg-red-100 rounded-full flex items-center justify-center"
                animate={{ scale: [1, 1.15, 1] }}
                transition={{ duration: 0.8, repeat: Infinity, ease: "easeInOut" }}
              >
                <Heart className="w-6 h-6 text-red-600" fill="currentColor" />
              </motion.div>
              <h2 className="text-h1 md:text-2xl font-bold text-brand-navy">
                Heart Disease: The Silent Killer at Sea
              </h2>
            </div>
            
            <div className="grid md:grid-cols-2 gap-8 items-start">
              <div>
                <p className="text-brand-gray mb-4 leading-relaxed">
                  According to P&I Club studies, <span className="font-semibold text-red-600">cardiovascular disease is the leading cause of death</span> among seafarers, accounting for approximately <span className="font-semibold">30-40% of all deaths onboard</span> commercial vessels.
                </p>
                <p className="text-brand-gray mb-4 leading-relaxed">
                  The UK P&I Club reports that heart attacks and strokes are responsible for more crew fatalities than any other medical condition, with many occurring in seafarers under 50 years old.
                </p>
                <p className="text-brand-gray leading-relaxed">
                  Early detection through regular ECG monitoring and immediate access to defibrillators can significantly improve survival rates. Studies show that <span className="font-semibold text-green-600">AEDs can increase survival chances up to 85%</span> for witnessed cardiac arrests.
                </p>
                
                {/* Interactive Stats Toggle */}
                <button 
                  onClick={() => setShowMoreStats(!showMoreStats)}
                  className="mt-4 flex items-center gap-2 text-brand-ocean font-medium hover:text-brand-blue transition-colors"
                >
                  {showMoreStats ? 'Hide detailed statistics' : 'Show detailed statistics'}
                  {showMoreStats ? <ChevronUp size={18} /> : <ChevronDown size={18} />}
                </button>
                
                {showMoreStats && (
                  <motion.div 
                    initial={{ opacity: 0, height: 0 }}
                    animate={{ opacity: 1, height: 'auto' }}
                    transition={{ duration: 0.4 }}
                    className="mt-4 p-4 bg-white rounded-lg border border-gray-200"
                  >
                    <motion.h4 
                      className="font-semibold text-brand-navy mb-2"
                      initial={{ opacity: 0, x: -10 }}
                      animate={{ opacity: 1, x: 0 }}
                      transition={{ duration: 0.3 }}
                    >
                      Additional P&I Club Findings:
                    </motion.h4>
                    <ul className="text-sm text-brand-gray space-y-2">
                      <motion.li
                        initial={{ opacity: 0, x: -20 }}
                        animate={{ opacity: 1, x: 0 }}
                        transition={{ duration: 0.3, delay: 0.1 }}
                      >
                        • <strong>Gard P&I:</strong> 22% of all crew illness claims are cardiovascular
                      </motion.li>
                      <motion.li
                        initial={{ opacity: 0, x: -20 }}
                        animate={{ opacity: 1, x: 0 }}
                        transition={{ duration: 0.3, delay: 0.2 }}
                      >
                        • <strong>Swedish Club:</strong> Average age of cardiac death at sea is 52 years
                      </motion.li>
                      <motion.li
                        initial={{ opacity: 0, x: -20 }}
                        animate={{ opacity: 1, x: 0 }}
                        transition={{ duration: 0.3, delay: 0.3 }}
                      >
                        • <strong>UK P&I:</strong> 60% of cardiac events occur during rest periods
                      </motion.li>
                      <motion.li
                        initial={{ opacity: 0, x: -20 }}
                        animate={{ opacity: 1, x: 0 }}
                        transition={{ duration: 0.3, delay: 0.4 }}
                      >
                        • <strong>Skuld:</strong> Repatriation costs for cardiac cases average $45,000
                      </motion.li>
                    </ul>
                  </motion.div>
                )}
              </div>
              
              {/* AED Requirements Chart */}
              <div className="bg-white p-6 rounded-xl shadow-sm border border-gray-200">
                <h4 className="font-semibold text-brand-navy mb-4">AED Requirements by Flag State</h4>
                <div className="space-y-3">
                  {aedData.map((item, index) => (
                    <motion.div 
                      key={index}
                      initial={{ opacity: 0, x: 20 }}
                      whileInView={{ opacity: 1, x: 0 }}
                      viewport={{ once: true }}
                      transition={{ delay: index * 0.05 }}
                      className="flex items-center gap-3"
                    >
                      <span className="text-lg w-32">{item.flag}</span>
                      <div className="flex-1 h-6 bg-gray-100 rounded-full overflow-hidden">
                        <motion.div 
                          className={`h-full ${item.required ? 'bg-green-500' : 'bg-red-400'}`}
                          initial={{ width: 0 }}
                          whileInView={{ width: `${item.required ? 100 : 15}%` }}
                          viewport={{ once: true }}
                          transition={{ duration: 0.8, delay: index * 0.05 }}
                        />
                      </div>
                      <span className={`text-sm font-medium w-20 text-right ${item.required ? 'text-green-600' : 'text-red-500'}`}>
                        {item.required ? 'Required' : 'Not Req.'}
                      </span>
                    </motion.div>
                  ))}
                </div>
                <p className="text-xs text-brand-gray mt-4 italic">
                  Only ~40% of major flag states mandate AEDs onboard. Many vessels sail without this life-saving equipment.
                </p>
              </div>
            </div>
            
            <div className="mt-6 p-4 bg-amber-50 rounded-lg border border-amber-200 flex items-start gap-3">
              <AlertTriangle className="w-5 h-5 text-amber-600 flex-shrink-0 mt-0.5" />
              <p className="text-sm text-amber-800">
                <span className="font-semibold">P&I Club Recommendation:</span> All vessels should carry AEDs and ECG monitoring equipment. Regular health screenings for crew members, especially those over 40 or with risk factors, are strongly advised.
              </p>
            </div>

            </motion.div>
        </Container>
      </section>

      {/* CTA Section - Equipment */}
      <section className="py-16 md:py-20 bg-gradient-to-b from-brand-navy via-brand-blue to-brand-navy relative overflow-hidden">
        <Container className="relative z-10">
          <motion.div 
            className="text-center"
            initial={{ opacity: 0, y: 30 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ duration: 0.6 }}
          >
            <motion.div 
              className="inline-flex items-center space-x-2 mb-6"
              animate={{ rotate: [0, 10, -10, 0] }}
              transition={{ duration: 4, repeat: Infinity, repeatType: "reverse" }}
            >
              <Anchor className="w-8 h-8 text-brand-ocean" />
            </motion.div>
            <h2 className="text-h1 md:text-display font-bold text-white mb-4">
              Need Equipment for Your Vessel?
            </h2>
            <p className="text-lg text-brand-sky-light mb-8 max-w-2xl mx-auto">
              We resell tested medical equipment to support our free database mission. All proceeds help maintain this resource.
            </p>
            <div className="flex flex-col sm:flex-row gap-4 justify-center">
              <Link to="/products">
                <motion.div whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.95 }}>
                  <Button size="lg" rightIcon={<ArrowRight size={20} />}>
                    Browse Equipment
                  </Button>
                </motion.div>
              </Link>
              <Link to="/contact">
                <motion.div whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.95 }}>
                  <Button
                    variant="outline"
                    size="lg"
                    className="border-brand-sky text-brand-sky hover:bg-brand-sky hover:text-brand-navy"
                  >
                    Contact Us
                  </Button>
                </motion.div>
              </Link>
            </div>
          </motion.div>
        </Container>
      </section>

      {/* Training Gap Section */}
      <section className="py-16 md:py-20 bg-white" ref={trainingGapRef}>
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-50px" }}
            transition={{ duration: 0.5 }}
          >
            <motion.div 
              className="flex items-center gap-3 mb-6"
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ duration: 0.5 }}
            >
              <motion.div 
                className="w-12 h-12 bg-blue-100 rounded-full flex items-center justify-center"
                whileHover={{ rotate: 15 }}
              >
                <GraduationCap className="w-6 h-6 text-blue-600" />
              </motion.div>
              <h2 className="text-h1 md:text-2xl font-bold text-brand-navy">
                The Training Gap: A Critical Problem
              </h2>
            </motion.div>
            
            <motion.p 
              className="text-brand-gray mb-6 leading-relaxed max-w-3xl"
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              transition={{ duration: 0.5, delay: 0.1 }}
            >
              P&I Club studies reveal that seafarer medical skills are often significantly below required standards. This gap costs lives.
            </motion.p>

            <div 
              className="cursor-pointer"
              onClick={() => setShowTrainingDetails(!showTrainingDetails)}
            >
              <div className="flex items-center gap-2 text-brand-ocean font-medium hover:text-brand-blue transition-colors mb-4">
                {showTrainingDetails ? 'Hide detailed findings' : 'Show detailed findings'}
                {showTrainingDetails ? <ChevronUp size={18} /> : <ChevronDown size={18} />}
              </div>
            </div>
            
            {showTrainingDetails && (
              <motion.div 
                initial={{ opacity: 0, height: 0 }}
                animate={{ opacity: 1, height: 'auto' }}
                transition={{ duration: 0.4 }}
                className="space-y-4"
              >
                <div className="grid md:grid-cols-2 gap-4">
                  <motion.div 
                    className="bg-blue-50 p-5 rounded-xl border border-blue-100"
                    initial={{ opacity: 0, x: -20 }}
                    animate={{ opacity: 1, x: 0 }}
                    transition={{ duration: 0.4, delay: 0.1 }}
                  >
                    <h5 className="font-semibold text-brand-navy mb-3">Gard P&I Club Survey</h5>
                    <ul className="text-sm text-brand-gray space-y-2">
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        Only <strong>47%</strong> of officers felt confident handling medical emergencies
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        <strong>68%</strong> said onboard medical training was inadequate
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        <strong>82%</strong> wanted more practical, hands-on training
                      </li>
                    </ul>
                  </motion.div>
                  <motion.div 
                    className="bg-blue-50 p-5 rounded-xl border border-blue-100"
                    initial={{ opacity: 0, x: 20 }}
                    animate={{ opacity: 1, x: 0 }}
                    transition={{ duration: 0.4, delay: 0.2 }}
                  >
                    <h5 className="font-semibold text-brand-navy mb-3">Swedish Club Analysis</h5>
                    <ul className="text-sm text-brand-gray space-y-2">
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        Inadequate first aid training contributed to <strong>preventable deaths</strong>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        Basic STCW medical training is <strong>insufficient</strong> for real emergencies
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="text-blue-500 font-bold">•</span>
                        <strong>5-year refresh</strong> cycle too long for skill retention
                      </li>
                    </ul>
                  </motion.div>
                </div>
                <motion.div 
                  className="bg-amber-50 p-5 rounded-xl border border-amber-200"
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  transition={{ duration: 0.4, delay: 0.3 }}
                >
                  <h5 className="font-semibold text-brand-navy mb-2">The Reality Gap</h5>
                  <p className="text-sm text-brand-gray">
                    STCW requires only <strong>basic first aid</strong> for ratings and <strong>medical care</strong> for officers—typically a 3-5 day course renewed every 5 years. Compare this to shore-based EMTs who complete <strong>120-150 hours</strong> of initial training with <strong>annual refreshers</strong>. Seafarers are expected to handle the same emergencies with a fraction of the training, often days away from professional medical help.
                  </p>
                  <Link to="/training" className="inline-flex items-center gap-2 mt-3 text-sm font-medium text-brand-ocean hover:text-brand-blue transition-colors">
                    Explore our training resources
                    <ArrowRight size={16} />
                  </Link>
                </motion.div>
              </motion.div>
            )}
          </motion.div>
        </Container>
      </section>

      {/* About Section - Personal Story */}
      <section className="py-16 md:py-20 bg-gradient-to-br from-brand-navy via-brand-blue to-brand-navy">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-50px" }}
            transition={{ duration: 0.5 }}
            className="max-w-4xl mx-auto"
          >
            <div className="grid md:grid-cols-3 gap-8 items-start">
              <div className="md:col-span-1">
                <motion.div 
                  className="sticky top-24 text-center md:text-left"
                  initial={{ opacity: 0, x: -30 }}
                  whileInView={{ opacity: 1, x: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.6 }}
                >
                  <motion.div 
                    className="w-40 h-40 mx-auto md:mx-0 mb-4 rounded-full overflow-hidden shadow-xl border-4 border-white/20"
                    whileHover={{ scale: 1.05 }}
                    transition={{ duration: 0.3 }}
                  >
                    <img 
                      src="/Profile Picture - Circular.webp" 
                      alt="Pavlos-Angelos Filippakis"
                      className="w-full h-full object-cover"
                    />
                  </motion.div>
                  <h3 className="text-xl font-bold text-white">Pavlos-Angelos Filippakis</h3>
                  <p className="text-brand-sky text-sm mt-1">Master Mariner • R-EMT</p>
                </motion.div>
              </div>
              
              <div className="md:col-span-2 space-y-4">
                <motion.h2 
                  className="text-2xl font-bold text-white mb-4"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5 }}
                >
                  From Bridge to Ambulance
                </motion.h2>
                <motion.p 
                  className="text-brand-sky-light leading-relaxed text-lg"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5, delay: 0.1 }}
                >
                  <span className="font-semibold text-white">I was a cadet on an oil tanker</span> when I first witnessed how unprepared we are for medical emergencies at sea.
                </motion.p>
                <motion.p 
                  className="text-brand-sky-light leading-relaxed"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5, delay: 0.2 }}
                >
                  After a routine maintenance of a fuel oil filter, an incorrect setup led to the 2nd Engineer being sprayed with <span className="font-semibold text-white">70°C fuel oil</span>. He survived, but with second-degree burns. Calling the TMAS service saved his life—but it also showed me just how unprepared we were. We had the medical chest, the procedures, but standing there with a man screaming in pain, I realized how woefully inadequate our training really was.
                </motion.p>
                <motion.p 
                  className="text-brand-sky-light leading-relaxed"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5, delay: 0.3 }}
                >
                  That experience stayed with me. Years later, I volunteered as an <span className="font-semibold text-white">Emergency Medical Technician</span> in South Africa. Working on ambulances, I learned what real emergency response looks like—the protocols, the muscle memory, the confidence that comes from proper training.
                </motion.p>
                <motion.p 
                  className="text-brand-sky-light leading-relaxed"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5, delay: 0.4 }}
                >
                  The contrast was stark. Shore-based EMTs get 150+ hours of training with regular refreshers. Seafarers get a 3-day course every 5 years and are expected to handle the same emergencies, often days from help.
                </motion.p>
                <motion.p 
                  className="text-white leading-relaxed font-medium"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ duration: 0.5, delay: 0.5 }}
                >
                  <span className="text-brand-sky font-bold">BlueCross Medical</span> exists to bridge that gap. Free resources, practical training guides, and equipment that actually works at sea—because no seafarer should feel as helpless as I did that day in the engine room.
                </motion.p>
              </div>
            </div>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default Home;
