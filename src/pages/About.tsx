import { motion } from 'framer-motion';
import { Mail, Linkedin, Anchor, Ship, Award, Heart } from 'lucide-react';
import Container from '../components/Common/Container';

function About() {
  return (
    <main className="flex-1">
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              About BlueCross Medical
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Founded by a Captain & Paramedic to make maritime medical compliance accessible to all.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Founder Section */}
      <section className="py-16 md:py-24">
        <Container>
          <div className="max-w-4xl mx-auto">
            <motion.div
              initial={{ opacity: 0, y: 30 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="grid md:grid-cols-2 gap-12 items-center"
            >
              {/* Photo */}
              <div className="relative">
                <div className="aspect-square rounded-2xl overflow-hidden shadow-2xl">
                  <img
                    src="https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/5a54b920-f88c-4848-ab32-9116a792ea13/Profile_Circle_PF/w=400,quality=90,fit=scale-down"
                    alt="Pavlos-Angelos Filippakis"
                    className="w-full h-full object-cover"
                  />
                </div>
                <div className="absolute -bottom-4 -right-4 bg-brand-ocean text-white px-4 py-2 rounded-lg shadow-lg">
                  <span className="text-sm font-medium">Founder & Captain</span>
                </div>
              </div>

              {/* Bio */}
              <div>
                <h2 className="text-2xl md:text-3xl font-bold text-brand-navy mb-2">
                  Pavlos-Angelos Filippakis
                </h2>
                <p className="text-brand-ocean font-medium mb-4">
                  Managing Director
                </p>
                <div className="space-y-4 text-gray-600">
                  <p>
                    Paul founded BlueCross in Estonia in 2020, driven by a mission to create an affordable 
                    way for vessel owners to equip their ships with necessary medical equipment.
                  </p>
                  <p>
                    He is currently the Captain of an expedition yacht navigating remote waters, and an 
                    active paramedic in Greece and South Africa. This unique combination of maritime 
                    experience and medical expertise informs every aspect of BlueCross's mission.
                  </p>
                  <p>
                    The free Flag Regulations database was created to help seafarers and operators 
                    understand and comply with medical requirements across different flag states.
                  </p>
                </div>

                {/* Contact */}
                <div className="mt-6 flex gap-4">
                  <a
                    href="mailto:paul@bluecross.tech"
                    className="flex items-center gap-2 text-sm text-brand-ocean hover:text-brand-navy transition-colors"
                  >
                    <Mail size={16} />
                    paul@bluecross.tech
                  </a>
                  <a
                    href="https://linkedin.com/company/bluecross-medical"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="flex items-center gap-2 text-sm text-brand-ocean hover:text-brand-navy transition-colors"
                  >
                    <Linkedin size={16} />
                    LinkedIn
                  </a>
                </div>
              </div>
            </motion.div>
          </div>
        </Container>
      </section>

      {/* Mission Section */}
      <section className="py-16 md:py-24 bg-surface-secondary">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="text-center mb-12"
          >
            <h2 className="text-2xl md:text-3xl font-bold text-brand-navy mb-4">
              Our Mission
            </h2>
            <p className="text-lg text-gray-600 max-w-2xl mx-auto">
              Making maritime medical compliance accessible, affordable, and straightforward.
            </p>
          </motion.div>

          <div className="grid md:grid-cols-3 gap-8">
            {[
              {
                icon: Anchor,
                title: 'Free Database',
                description: 'Comprehensive flag state medical requirements available to all seafarers at no cost.',
              },
              {
                icon: Ship,
                title: 'Tested Equipment',
                description: 'We only sell equipment personally tested at sea. Proceeds support our free resources.',
              },
              {
                icon: Heart,
                title: 'Community Support',
                description: '20% of net profits donated annually to Hellenic Red Cross MEDICO service.',
              },
            ].map((item, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className="bg-white p-6 rounded-xl shadow-sm border border-gray-100"
              >
                <div className="w-12 h-12 bg-brand-ocean/10 rounded-lg flex items-center justify-center mb-4">
                  <item.icon className="w-6 h-6 text-brand-ocean" />
                </div>
                <h3 className="font-semibold text-brand-navy mb-2">{item.title}</h3>
                <p className="text-gray-600 text-sm">{item.description}</p>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* Credentials */}
      <section className="py-16 md:py-24">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="text-center mb-12"
          >
            <h2 className="text-2xl md:text-3xl font-bold text-brand-navy mb-4">
              Credentials & Experience
            </h2>
          </motion.div>

          <div className="max-w-2xl mx-auto">
            <div className="grid grid-cols-2 gap-4">
              {[
                { icon: Award, label: 'Master Mariner (Captain)' },
                { icon: Award, label: 'Registered Paramedic' },
                { icon: Award, label: 'STCW Medical Care Certified' },
                { icon: Award, label: 'Expedition Yacht Experience' },
              ].map((item, index) => (
                <motion.div
                  key={index}
                  initial={{ opacity: 0, scale: 0.9 }}
                  whileInView={{ opacity: 1, scale: 1 }}
                  viewport={{ once: true }}
                  transition={{ delay: index * 0.1 }}
                  className="flex items-center gap-3 p-4 bg-brand-ocean/5 rounded-lg"
                >
                  <item.icon className="w-5 h-5 text-brand-ocean flex-shrink-0" />
                  <span className="text-sm font-medium text-brand-navy">{item.label}</span>
                </motion.div>
              ))}
            </div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default About;
