/**
 * @fileoverview Team page displaying company team members.
 */
import { motion } from 'framer-motion';
import { TeamGrid } from '../components/Team';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';

/**
 * Team page showing company team member profiles and roles.
 */
function Team() {
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
            <h1 className="text-display md:text-5xl font-bold text-white mb-4">
              The Team
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Meet the crew behind BlueCross Medical - seafarers who test and trust our products.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Team Grid */}
      <section className="py-12 md:py-16">
        <Container>
          <ScrollReveal>
            <TeamGrid />
          </ScrollReveal>
        </Container>
      </section>

      {/* Values */}
      <section className="py-12 md:py-16 bg-surface-secondary">
        <Container>
          <ScrollReveal>
            <div className="text-center mb-12">
              <h2 className="text-h1 font-bold text-brand-slate mb-4">
                Our Values
              </h2>
              <p className="text-brand-gray max-w-2xl mx-auto">
                The principles that guide everything we do.
              </p>
            </div>
          </ScrollReveal>

          <div className="grid md:grid-cols-3 gap-8">
            {[
              {
                title: 'Patient First',
                description: 'Every decision we make starts with the question: how does this benefit patients?',
              },
              {
                title: 'Innovation',
                description: 'We continuously push boundaries to deliver cutting-edge healthcare technology.',
              },
              {
                title: 'Integrity',
                description: 'Trust is earned through transparency, honesty, and ethical practices.',
              },
            ].map((value, index) => (
              <ScrollReveal key={index} delay={index * 0.1}>
                <div className="bg-white p-6 rounded-xl shadow-sm">
                  <h3 className="text-h3 font-semibold text-brand-slate mb-3">
                    {value.title}
                  </h3>
                  <p className="text-brand-gray">{value.description}</p>
                </div>
              </ScrollReveal>
            ))}
          </div>
        </Container>
      </section>

      {/* Join Us CTA */}
      <section className="py-12 md:py-16">
        <Container>
          <ScrollReveal>
            <div className="bg-brand-ocean/10 rounded-2xl p-8 md:p-12 text-center">
              <h2 className="text-h1 font-bold text-brand-slate mb-4">
                Join Our Team
              </h2>
              <p className="text-brand-gray max-w-2xl mx-auto mb-6">
                We're always looking for talented individuals who share our passion for improving healthcare through technology.
              </p>
              <a
                href="mailto:bluecross@marsoft.ai"
                className="inline-flex items-center justify-center px-6 py-3 bg-brand-ocean text-white font-medium rounded-lg hover:bg-brand-ocean-light transition-colors"
              >
                View Open Positions
              </a>
            </div>
          </ScrollReveal>
        </Container>
      </section>
    </main>
  );
}

export default Team;
