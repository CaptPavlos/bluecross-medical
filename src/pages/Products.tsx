import { motion } from 'framer-motion';
import { ProductGrid } from '../components/Features';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';

function Products() {
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
              Medical Equipment
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Tested equipment to support our free database mission. All proceeds help maintain this resource.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Products Grid */}
      <section className="py-12 md:py-16">
        <Container>
          <ScrollReveal>
            <ProductGrid showFilters />
          </ScrollReveal>
        </Container>
      </section>

      {/* Features Overview */}
      <section className="py-12 md:py-16 bg-surface-secondary">
        <Container>
          <ScrollReveal>
            <div className="text-center mb-12">
              <h2 className="text-h1 font-bold text-brand-navy mb-4">
                Why Our Products?
              </h2>
              <p className="text-brand-gray max-w-2xl mx-auto">
                We only sell what we've tested ourselves at sea.
              </p>
            </div>
          </ScrollReveal>

          <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-6">
            {[
              { title: 'Tested at Sea', desc: 'Every product proven onboard' },
              { title: 'FDA & CE Approved', desc: 'Medical grade certification' },
              { title: '24/7 Support', desc: 'Always available assistance' },
              { title: 'Yachting & Shipping', desc: 'For all vessel types' },
            ].map((feature, index) => (
              <ScrollReveal key={index} delay={index * 0.1}>
                <div className="bg-white p-6 rounded-lg shadow-sm text-center border border-brand-ocean/10">
                  <h3 className="font-semibold text-brand-navy mb-2">{feature.title}</h3>
                  <p className="text-sm text-brand-gray">{feature.desc}</p>
                </div>
              </ScrollReveal>
            ))}
          </div>
        </Container>
      </section>
    </main>
  );
}

export default Products;
