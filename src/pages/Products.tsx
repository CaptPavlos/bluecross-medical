import { motion } from 'framer-motion';
import { Clock, Package, Truck } from 'lucide-react';
import { ProductGrid } from '../components/Features';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';
import { SEOHead } from '../components/SEO';

function Products() {
  return (
    <main className="flex-1">
      <SEOHead 
        title="Maritime Medical Equipment"
        description="Tested medical equipment for yachts and commercial vessels. AEDs, first aid kits, emergency medical supplies. All proceeds support our free maritime medical database."
        url="/products"
        type="product"
        keywords={['maritime medical equipment', 'yacht first aid kit', 'ship medical supplies', 'AED for boats', 'marine medical kit']}
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
              Medical Equipment
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Tested equipment to support our free database mission. All proceeds help maintain this resource.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Lead Time Info */}
      <section className="py-6 bg-surface-secondary border-b border-gray-200">
        <Container>
          <div className="flex flex-wrap justify-center gap-6 md:gap-10 text-sm">
            <div className="flex items-center gap-2">
              <div className="w-8 h-8 bg-green-100 rounded-full flex items-center justify-center">
                <Package size={16} className="text-green-600" />
              </div>
              <div>
                <span className="font-semibold text-green-700">In Stock</span>
                <span className="text-gray-600 ml-1">— Ships next day</span>
              </div>
            </div>
            <div className="flex items-center gap-2">
              <div className="w-8 h-8 bg-yellow-100 rounded-full flex items-center justify-center">
                <Truck size={16} className="text-yellow-600" />
              </div>
              <div>
                <span className="font-semibold text-yellow-700">To Order</span>
                <span className="text-gray-600 ml-1">— 7-10 days</span>
              </div>
            </div>
            <div className="flex items-center gap-2">
              <div className="w-8 h-8 bg-red-100 rounded-full flex items-center justify-center">
                <Clock size={16} className="text-red-600" />
              </div>
              <div>
                <span className="font-semibold text-red-700">Not Available</span>
                <span className="text-gray-600 ml-1">— 30+ days lead time</span>
              </div>
            </div>
          </div>
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
              { title: 'Expert Support', desc: 'Technical assistance available' },
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
