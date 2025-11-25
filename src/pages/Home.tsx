import { Link } from 'react-router-dom';
import { motion, useScroll, useTransform } from 'framer-motion';
import { useRef } from 'react';
import { ArrowRight, Anchor, Ship, Flag, Database, Headphones, Globe } from 'lucide-react';
import { HeroSection } from '../components/Hero';
import { ProductGrid } from '../components/Features';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { FLAG_STATES } from '../lib/flagStates';

function Home() {
  const containerRef = useRef<HTMLDivElement>(null);
  const { scrollYProgress } = useScroll({
    target: containerRef,
    offset: ["start start", "end end"]
  });
  
  const statsScale = useTransform(scrollYProgress, [0.1, 0.2], [0.95, 1]);
  const statsOpacity = useTransform(scrollYProgress, [0.1, 0.2], [0.8, 1]);

  const highlights = [
    {
      icon: Flag,
      title: 'Free Flag Database',
      description: 'Comprehensive medical requirements for Malta, Cyprus, Panama, Liberia, UK, Greece and more. Always free.',
    },
    {
      icon: Database,
      title: 'Advanced Training',
      description: 'Curated courses that exceed STCW requirements. No license needed. Community rated.',
    },
    {
      icon: Ship,
      title: 'Tested Equipment',
      description: 'We resell only equipment personally tested at sea. All proceeds support our free database.',
    },
  ];

  const stats = [
    { value: '62', label: 'Flag States' },
    { value: '6', label: 'Knowledge Articles' },
    { value: '100%', label: 'Free Forever' },
    { value: '24/7', label: 'TMAS Support' },
  ];

  const services = [
    { icon: Headphones, title: '24/7 Emergency Line', description: 'Round-the-clock medical advice through our partnership with Hellenic Red Cross MEDICO.' },
    { icon: Anchor, title: 'Community Ratings', description: 'Anonymous course ratings help seafarers find the best training programs worldwide.' },
    { icon: Globe, title: 'Worldwide Coverage', description: 'Flag state requirements from major maritime registries around the world. Always free.' },
  ];

  return (
    <main ref={containerRef}>
      {/* Hero Section */}
      <HeroSection />

      {/* Highlights Section */}
      <section className="py-16 md:py-24 bg-surface-secondary -mt-1">
        <Container>
          <motion.div 
            className="text-center mb-12"
            initial={{ opacity: 0, y: 30 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-100px" }}
            transition={{ duration: 0.6 }}
          >
            <h2 className="text-h1 md:text-display font-bold text-brand-navy mb-4">
              Why BlueCross Medical?
            </h2>
            <p className="text-lg text-brand-gray max-w-2xl mx-auto">
              Free flag state database. Curated advanced training. Tested equipment. All to keep seafarers safe.
            </p>
          </motion.div>

          <div className="grid md:grid-cols-3 gap-8">
            {highlights.map((item, index) => (
              <motion.div 
                key={index}
                initial={{ opacity: 0, y: 30 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true, margin: "-50px" }}
                transition={{ duration: 0.5, delay: index * 0.15 }}
                whileHover={{ y: -8, boxShadow: "0 20px 40px rgba(0,119,182,0.15)" }}
                className="bg-white p-6 md:p-8 rounded-xl shadow-sm text-center border border-brand-ocean/10 cursor-pointer"
              >
                <motion.div 
                  className="w-14 h-14 bg-brand-ocean/10 rounded-xl flex items-center justify-center mx-auto mb-4"
                  whileHover={{ scale: 1.1, rotate: 5 }}
                  transition={{ type: "spring", stiffness: 300 }}
                >
                  <item.icon className="w-7 h-7 text-brand-ocean" />
                </motion.div>
                <h3 className="text-h3 font-semibold text-brand-navy mb-2">
                  {item.title}
                </h3>
                <p className="text-brand-gray">{item.description}</p>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* Stats Section - Maritime wave background */}
      <motion.section 
        className="py-12 bg-gradient-to-r from-brand-navy via-brand-blue to-brand-navy relative overflow-hidden"
        style={{ scale: statsScale, opacity: statsOpacity }}
      >
        {/* Wave decoration */}
        <div className="absolute inset-0 opacity-20">
          <svg className="absolute top-0 w-full h-16 transform rotate-180" viewBox="0 0 1440 100" preserveAspectRatio="none">
            <path fill="#0077B6" d="M0,50 C150,100 350,0 600,50 C850,100 1050,0 1200,50 C1350,100 1440,80 1440,80 L1440,100 L0,100 Z"></path>
          </svg>
        </div>
        <Container className="relative z-10">
          <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
            {stats.map((stat, index) => (
              <motion.div 
                key={index} 
                className="text-center"
                initial={{ opacity: 0, scale: 0.8 }}
                whileInView={{ opacity: 1, scale: 1 }}
                viewport={{ once: true }}
                transition={{ duration: 0.4, delay: index * 0.1 }}
                whileHover={{ scale: 1.05 }}
              >
                <div className="text-3xl md:text-4xl font-bold text-white mb-1">{stat.value}</div>
                <div className="text-brand-sky text-sm">{stat.label}</div>
              </motion.div>
            ))}
          </div>
        </Container>
      </motion.section>

      {/* Products Preview */}
      <section className="py-16 md:py-24">
        <Container>
          <motion.div 
            className="flex flex-col md:flex-row justify-between items-start md:items-center mb-10"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-50px" }}
            transition={{ duration: 0.5 }}
          >
            <div>
              <h2 className="text-h1 md:text-display font-bold text-brand-slate mb-2">
                Medical Equipment Categories
              </h2>
              <p className="text-brand-gray">
                Comprehensive solutions for hospitals, clinics, and healthcare facilities.
              </p>
            </div>
            <Link to="/products" className="mt-4 md:mt-0">
              <motion.div whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.95 }}>
                <Button variant="outline" rightIcon={<ArrowRight size={16} />}>
                  View All Equipment
                </Button>
              </motion.div>
            </Link>
          </motion.div>
          <ProductGrid limit={3} />
        </Container>
      </section>

      {/* Services Section */}
      <section className="py-16 md:py-24 bg-surface-secondary">
        <Container>
          <motion.div 
            className="text-center mb-12"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-100px" }}
            transition={{ duration: 0.5 }}
          >
            <h2 className="text-h1 md:text-display font-bold text-brand-navy mb-4">
              Our Services
            </h2>
            <p className="text-lg text-brand-gray max-w-2xl mx-auto">
              Full-service support from port to hospital – consultation, delivery, and maintenance.
            </p>
          </motion.div>

          <div className="grid md:grid-cols-3 gap-8">
            {services.map((service, index) => (
              <motion.div 
                key={index}
                initial={{ opacity: 0, x: index === 0 ? -30 : index === 2 ? 30 : 0, y: index === 1 ? 30 : 0 }}
                whileInView={{ opacity: 1, x: 0, y: 0 }}
                viewport={{ once: true, margin: "-50px" }}
                transition={{ duration: 0.5, delay: index * 0.1 }}
                whileHover={{ y: -4, borderColor: "rgba(0,119,182,0.3)" }}
                className="bg-white p-6 rounded-xl shadow-sm border border-brand-ocean/10 transition-colors"
              >
                <motion.div 
                  className="w-12 h-12 bg-brand-ocean/10 rounded-lg flex items-center justify-center mb-4"
                  whileHover={{ scale: 1.1 }}
                >
                  <service.icon className="w-6 h-6 text-brand-ocean" />
                </motion.div>
                <h3 className="text-h3 font-semibold text-brand-navy mb-2">{service.title}</h3>
                <p className="text-brand-gray">{service.description}</p>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* Flag Regulations Preview */}
      <section className="py-16 md:py-24 bg-surface-secondary">
        <Container>
          <motion.div 
            className="flex flex-col md:flex-row justify-between items-start md:items-center mb-10"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-50px" }}
            transition={{ duration: 0.5 }}
          >
            <div>
              <h2 className="text-h1 md:text-display font-bold text-brand-navy mb-2">
                🌍 Flag State Requirements
              </h2>
              <p className="text-brand-gray">
                Browse medical requirements by flag state or read our maritime health guides.
              </p>
            </div>
            <Link to="/flags" className="mt-4 md:mt-0">
              <motion.div whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.95 }}>
                <Button variant="outline" rightIcon={<ArrowRight size={16} />}>
                  View All Regulations
                </Button>
              </motion.div>
            </Link>
          </motion.div>
          {/* Flag Preview Grid */}
          <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
            {FLAG_STATES.filter(f => f.paris_mou_status === 'white').slice(0, 6).map((flag, index) => (
              <motion.div
                key={flag.id}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
              >
                <Link to={`/flags/${flag.slug}`}>
                  <div className="bg-white rounded-xl border border-gray-200 p-4 hover:shadow-lg hover:border-brand-ocean/30 transition-all group">
                    <div className="flex items-center gap-3">
                      <span className="text-3xl">{flag.flag_emoji}</span>
                      <div>
                        <h3 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors">
                          {flag.country_name}
                        </h3>
                        <span className="text-xs text-green-600 font-medium">
                          WHITE LIST {flag.paris_mou_rank && `#${flag.paris_mou_rank}`}
                        </span>
                      </div>
                    </div>
                  </div>
                </Link>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* CTA Section */}
      <section className="py-16 md:py-24 bg-gradient-to-b from-brand-navy via-brand-blue to-brand-navy relative overflow-hidden">
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
    </main>
  );
}

export default Home;
