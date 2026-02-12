/**
 * @fileoverview Contact page with form and company information.
 */
import { motion } from 'framer-motion';
import { Mail, Phone, MapPin, Clock } from 'lucide-react';
import { ContactForm } from '../components/Forms';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';
import Card from '../components/Common/Card';
import { COMPANY_INFO } from '../lib/constants';
import { SEOHead } from '../components/SEO';

/**
 * Contact page displaying company information and contact form.
 * Includes email, phone, address, and working hours.
 */
function Contact() {
  const contactInfo = [
    { icon: Mail, label: 'Email', value: COMPANY_INFO.email, href: `mailto:${COMPANY_INFO.email}` },
    { icon: Phone, label: 'Phone', value: COMPANY_INFO.phone, href: `tel:${COMPANY_INFO.phone}` },
    { icon: MapPin, label: 'Address', value: COMPANY_INFO.address },
    { icon: Clock, label: 'Hours', value: COMPANY_INFO.workingHours || 'Mon-Fri 09:00 - 18:00 (EET/EEST)' },
  ];

  return (
    <main className="flex-1">
      <SEOHead 
        title="Contact Us"
        description="Get in touch with BlueCross Medical for maritime medical training, equipment, and consulting services. We're here to help with your yacht and vessel medical needs."
        url="/contact"
        keywords={['contact maritime medical', 'yacht medical consulting', 'maritime medical support']}
      />
      
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <h1 className="text-display md:text-5xl font-bold text-white mb-4">
              Contact
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Questions about flag regulations, training courses, or equipment? We're here to help.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Contact Section */}
      <section className="py-12 md:py-16">
        <Container>
          <div className="grid lg:grid-cols-3 gap-8 lg:gap-12">
            {/* Contact Info */}
            <div className="lg:col-span-1">
              <ScrollReveal direction="left">
                <h2 className="text-h2 font-bold text-brand-slate mb-6">
                  Get in Touch
                </h2>
                <p className="text-brand-gray mb-8">
                  Whether you need help understanding flag state requirements, want to recommend a training course, or are looking for tested medical equipment, our team is here to help.
                </p>

                <div className="space-y-4">
                  {contactInfo.map((item, index) => (
                    <div key={index} className="flex items-start gap-4">
                      <div className="p-2 bg-brand-ocean/10 rounded-lg">
                        <item.icon className="w-5 h-5 text-brand-ocean" />
                      </div>
                      <div>
                        <div className="text-sm text-brand-gray">{item.label}</div>
                        {item.href ? (
                          <a
                            href={item.href}
                            className="text-brand-slate font-medium hover:text-brand-ocean transition-colors"
                          >
                            {item.value}
                          </a>
                        ) : (
                          <div className="text-brand-slate font-medium">{item.value}</div>
                        )}
                      </div>
                    </div>
                  ))}
                </div>
              </ScrollReveal>
            </div>

            {/* Contact Form */}
            <div className="lg:col-span-2">
              <ScrollReveal direction="right">
                <Card variant="elevated" padding="lg">
                  <h2 className="text-h2 font-bold text-brand-slate mb-6">
                    Send us a Message
                  </h2>
                  <ContactForm />
                </Card>
              </ScrollReveal>
            </div>
          </div>
        </Container>
      </section>

      {/* FAQ Preview */}
      <section className="py-12 md:py-16 bg-surface-secondary">
        <Container>
          <ScrollReveal>
            <div className="text-center mb-12">
              <h2 className="text-h1 font-bold text-brand-slate mb-4">
                Frequently Asked Questions
              </h2>
              <p className="text-brand-gray max-w-2xl mx-auto">
                Find quick answers to common questions about our services.
              </p>
            </div>
          </ScrollReveal>

          <div className="grid md:grid-cols-2 gap-6 max-w-4xl mx-auto">
            {[
              { q: 'Is the flag regulations database really free?', a: 'Yes! Our database is 100% free. We fund it through equipment sales and donations to the Hellenic Red Cross.' },
              { q: 'Do you sell STCW courses?', a: 'No. We only recommend advanced training courses that exceed STCW requirements. STCW courses are available at any maritime training center.' },
              { q: 'How do I suggest a training course?', a: 'Contact us with details about the course. We personally evaluate all recommendations before adding them.' },
              { q: 'Is the equipment you sell tested?', a: 'Yes! We only resell equipment that has been personally tested at sea by our team. All proceeds support our free database mission.' },
            ].map((faq, index) => (
              <ScrollReveal key={index} delay={index * 0.1}>
                <Card>
                  <h3 className="font-semibold text-brand-slate mb-2">{faq.q}</h3>
                  <p className="text-brand-gray text-sm">{faq.a}</p>
                </Card>
              </ScrollReveal>
            ))}
          </div>
        </Container>
      </section>
    </main>
  );
}

export default Contact;
