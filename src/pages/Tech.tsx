import { motion, useScroll, useTransform } from 'framer-motion';
import { Download, Monitor, Apple, Award, CheckCircle, ExternalLink, FileCheck } from 'lucide-react';
import { useRef } from 'react';
import Container from '../components/Common/Container';
import Badge from '../components/Common/Badge';
import Button from '../components/Common/Button';

const windowsSoftware = [
  { 
    name: 'Vital Signs Pro+', 
    description: 'Complete vital signs monitoring software for Windows',
    url: 'https://storage.viatomtech.com.cn/download/pc/checkme_browser_pro_setup_v2.5.0_signed.exe'
  },
  { 
    name: '12-lead AI ECG', 
    description: 'AI-powered ECG analysis system',
    url: 'https://storage.viatomtech.com.cn/download/pc/ai_ecg_analysis_system_ecg_browser_latest.exe'
  },
];

const macSoftware = [
  { 
    name: 'Vital Signs Pro+', 
    description: 'Complete vital signs monitoring for macOS',
    url: 'http://itunes.apple.com/app/id1544419304'
  },
  { 
    name: '12-lead AI ECG', 
    description: 'AI-powered ECG analysis for Mac',
    url: 'https://apps.apple.com/us/app/ai-ecg-analysis-system/id1582117738'
  },
];

const certificates = [
  { name: 'FDA Cleared', description: 'US Food & Drug Administration approved' },
  { name: 'CE Marked', description: 'European conformity certification' },
  { name: 'ISO 13485', description: 'Medical device quality management' },
  { name: 'MDD/MDR', description: 'Medical Device Directive compliant' },
];

const features = [
  'Real-time vital signs monitoring',
  'AI-powered ECG analysis',
  'Cloud data synchronization',
  'Remote telemedicine support',
  'Multi-device compatibility',
  'Encrypted data transmission',
];

function Tech() {
  const containerRef = useRef<HTMLDivElement>(null);
  const { scrollYProgress } = useScroll({
    target: containerRef,
    offset: ["start start", "end end"]
  });
  
  const backgroundY = useTransform(scrollYProgress, [0, 1], ["0%", "50%"]);
  const opacity = useTransform(scrollYProgress, [0, 0.3], [1, 0.8]);

  return (
    <main className="flex-1" ref={containerRef}>
      {/* Hero with parallax */}
      <motion.section 
        className="pt-24 pb-16 md:pt-28 md:pb-20 bg-gradient-to-br from-brand-navy to-brand-blue relative overflow-hidden"
        style={{ opacity }}
      >
        <motion.div 
          className="absolute inset-0 opacity-10"
          style={{ y: backgroundY }}
        >
          <div className="absolute top-20 left-10 w-32 h-32 border border-white/20 rounded-full" />
          <div className="absolute top-40 right-20 w-24 h-24 border border-white/20 rounded-full" />
          <div className="absolute bottom-20 left-1/3 w-40 h-40 border border-white/20 rounded-full" />
        </motion.div>
        
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.6 }}
            className="text-center relative z-10"
          >
            <Badge variant="info" className="mb-4">Software & Certificates</Badge>
            <h1 className="text-display md:text-5xl font-bold text-white mb-4">
              The Tech
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Download our companion software and learn about our medical certifications.
            </p>
          </motion.div>
        </Container>
      </motion.section>

      {/* Software Downloads */}
      <section className="py-16 md:py-20">
        <Container>
          <motion.div 
            className="text-center mb-12"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-100px" }}
            transition={{ duration: 0.5 }}
          >
            <h2 className="text-h1 font-bold text-brand-navy mb-4">
              Software Downloads
            </h2>
            <p className="text-brand-gray max-w-2xl mx-auto">
              Download our companion software to get the most out of your medical devices.
            </p>
          </motion.div>

          <div className="grid md:grid-cols-2 gap-8">
            {/* Windows */}
            <motion.div 
              className="bg-white rounded-2xl shadow-lg border border-gray-100 overflow-hidden"
              initial={{ opacity: 0, x: -30 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true, margin: "-50px" }}
              transition={{ duration: 0.5 }}
              whileHover={{ y: -4, boxShadow: "0 20px 40px rgba(0,0,0,0.1)" }}
            >
              <div className="bg-gradient-to-r from-blue-600 to-blue-500 p-6 text-white">
                <div className="flex items-center gap-3">
                  <Monitor className="w-8 h-8" />
                  <h3 className="text-2xl font-bold">Windows</h3>
                </div>
              </div>
              <div className="p-6 space-y-4">
                {windowsSoftware.map((software, index) => (
                  <motion.a
                    key={software.name}
                    href={software.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="flex items-center justify-between p-4 bg-surface-secondary rounded-xl hover:bg-brand-ocean/5 transition-colors group"
                    initial={{ opacity: 0, y: 10 }}
                    whileInView={{ opacity: 1, y: 0 }}
                    viewport={{ once: true }}
                    transition={{ delay: index * 0.1 }}
                    whileHover={{ scale: 1.02 }}
                  >
                    <div>
                      <h4 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors">
                        {software.name}
                      </h4>
                      <p className="text-sm text-brand-gray">{software.description}</p>
                    </div>
                    <Download className="w-5 h-5 text-brand-ocean group-hover:translate-y-1 transition-transform" />
                  </motion.a>
                ))}
              </div>
            </motion.div>

            {/* macOS */}
            <motion.div 
              className="bg-white rounded-2xl shadow-lg border border-gray-100 overflow-hidden"
              initial={{ opacity: 0, x: 30 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true, margin: "-50px" }}
              transition={{ duration: 0.5 }}
              whileHover={{ y: -4, boxShadow: "0 20px 40px rgba(0,0,0,0.1)" }}
            >
              <div className="bg-gradient-to-r from-gray-800 to-gray-700 p-6 text-white">
                <div className="flex items-center gap-3">
                  <Apple className="w-8 h-8" />
                  <h3 className="text-2xl font-bold">macOS</h3>
                </div>
              </div>
              <div className="p-6 space-y-4">
                {macSoftware.map((software, index) => (
                  <motion.a
                    key={software.name}
                    href={software.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="flex items-center justify-between p-4 bg-surface-secondary rounded-xl hover:bg-brand-ocean/5 transition-colors group"
                    initial={{ opacity: 0, y: 10 }}
                    whileInView={{ opacity: 1, y: 0 }}
                    viewport={{ once: true }}
                    transition={{ delay: index * 0.1 }}
                    whileHover={{ scale: 1.02 }}
                  >
                    <div>
                      <h4 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors">
                        {software.name}
                      </h4>
                      <p className="text-sm text-brand-gray">{software.description}</p>
                    </div>
                    <ExternalLink className="w-5 h-5 text-brand-ocean group-hover:translate-x-1 transition-transform" />
                  </motion.a>
                ))}
              </div>
            </motion.div>
          </div>
        </Container>
      </section>

      {/* Certificates */}
      <section className="py-16 md:py-20 bg-surface-secondary">
        <Container>
          <motion.div 
            className="text-center mb-12"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true, margin: "-100px" }}
            transition={{ duration: 0.5 }}
          >
            <h2 className="text-h1 font-bold text-brand-navy mb-4">
              Certificates
            </h2>
            <p className="text-brand-gray max-w-2xl mx-auto">
              Our products meet the highest international medical device standards.
            </p>
          </motion.div>

          <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
            {certificates.map((cert, index) => (
              <motion.div
                key={cert.name}
                className="bg-white p-6 rounded-xl shadow-sm text-center border border-brand-ocean/10"
                initial={{ opacity: 0, scale: 0.9 }}
                whileInView={{ opacity: 1, scale: 1 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                whileHover={{ 
                  scale: 1.05,
                  boxShadow: "0 10px 30px rgba(0,119,182,0.15)"
                }}
              >
                <motion.div 
                  className="w-14 h-14 bg-brand-ocean/10 rounded-full flex items-center justify-center mx-auto mb-4"
                  whileHover={{ rotate: 10 }}
                >
                  <Award className="w-7 h-7 text-brand-ocean" />
                </motion.div>
                <h3 className="font-bold text-brand-navy mb-1">{cert.name}</h3>
                <p className="text-sm text-brand-gray">{cert.description}</p>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* Features with staggered animation */}
      <section className="py-16 md:py-20">
        <Container>
          <div className="grid md:grid-cols-2 gap-12 items-center">
            <motion.div
              initial={{ opacity: 0, x: -30 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true, margin: "-50px" }}
              transition={{ duration: 0.5 }}
            >
              <Badge variant="success" className="mb-4">All Products</Badge>
              <h2 className="text-h1 font-bold text-brand-navy mb-4">
                Software Features
              </h2>
              <p className="text-brand-gray mb-6">
                Our companion software provides powerful tools for monitoring, analyzing, and sharing vital health data.
              </p>
              <ul className="space-y-3">
                {features.map((feature, index) => (
                  <motion.li 
                    key={index} 
                    className="flex items-center gap-3"
                    initial={{ opacity: 0, x: -20 }}
                    whileInView={{ opacity: 1, x: 0 }}
                    viewport={{ once: true }}
                    transition={{ delay: index * 0.1 }}
                  >
                    <CheckCircle className="w-5 h-5 text-brand-green flex-shrink-0" />
                    <span className="text-brand-slate">{feature}</span>
                  </motion.li>
                ))}
              </ul>
            </motion.div>

            <motion.div
              className="relative"
              initial={{ opacity: 0, x: 30 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true, margin: "-50px" }}
              transition={{ duration: 0.5 }}
            >
              <div className="bg-gradient-to-br from-brand-navy to-brand-blue rounded-2xl p-8 text-white">
                <div className="flex items-center gap-3 mb-6">
                  <FileCheck className="w-8 h-8" />
                  <h3 className="text-xl font-bold">Compliance Status</h3>
                </div>
                <div className="space-y-4">
                  {[
                    { label: 'FDA Clearance', status: 'Approved' },
                    { label: 'CE Marking', status: 'Certified' },
                    { label: 'Data Security', status: 'Encrypted' },
                    { label: 'Quality Control', status: 'ISO 13485' },
                  ].map((item, index) => (
                    <motion.div 
                      key={item.label}
                      className="flex justify-between items-center py-2 border-b border-white/10 last:border-0"
                      initial={{ opacity: 0 }}
                      whileInView={{ opacity: 1 }}
                      viewport={{ once: true }}
                      transition={{ delay: 0.3 + index * 0.1 }}
                    >
                      <span className="text-brand-sky-light">{item.label}</span>
                      <Badge variant="success" size="sm">{item.status}</Badge>
                    </motion.div>
                  ))}
                </div>
              </div>
              
              {/* Floating decorative elements */}
              <motion.div 
                className="absolute -top-4 -right-4 w-20 h-20 bg-brand-ocean/20 rounded-full blur-xl"
                animate={{ scale: [1, 1.2, 1], opacity: [0.5, 0.8, 0.5] }}
                transition={{ duration: 3, repeat: Infinity }}
              />
              <motion.div 
                className="absolute -bottom-4 -left-4 w-16 h-16 bg-brand-sky/20 rounded-full blur-xl"
                animate={{ scale: [1.2, 1, 1.2], opacity: [0.8, 0.5, 0.8] }}
                transition={{ duration: 3, repeat: Infinity }}
              />
            </motion.div>
          </div>
        </Container>
      </section>

      {/* CTA */}
      <section className="py-16 md:py-20 bg-brand-navy text-white">
        <Container>
          <motion.div 
            className="text-center"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
          >
            <h2 className="text-h1 font-bold mb-4">Need Help With Setup?</h2>
            <p className="text-brand-sky-light max-w-2xl mx-auto mb-8">
              Our technical support team is available to assist with software installation and device configuration.
            </p>
            <motion.a
              href="mailto:bluecross@marsoft.ai"
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.95 }}
            >
              <Button size="lg" rightIcon={<ExternalLink size={20} />}>
                Contact Support
              </Button>
            </motion.a>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default Tech;
