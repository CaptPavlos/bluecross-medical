import { useParams, Link } from 'react-router-dom';
import { ArrowLeft, CheckCircle, Star, ExternalLink, AlertTriangle, Phone, Mail } from 'lucide-react';
import { motion } from 'framer-motion';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { Badge } from '../components/Common';
import { ScrollReveal } from '../components/Animations';
import { MOCK_PRODUCTS } from '../lib/constants';

const QUOTE_EMAIL = 'bluecross@marsoft.ai';

// Helper to format long description into readable sections
function formatDescription(text: string) {
  const sentences = text.split('. ').filter(s => s.trim());
  const items: string[] = [];
  
  sentences.forEach((sentence) => {
    const trimmed = sentence.trim();
    if (!trimmed) return;
    
    // Add period back if not last
    const formatted = trimmed.endsWith('.') ? trimmed : trimmed + '.';
    items.push(formatted);
  });

  return items;
}

function ProductDetail() {
  const { slug } = useParams<{ slug: string }>();
  const product = MOCK_PRODUCTS.find((p) => p.slug === slug);

  if (!product) {
    return (
      <main className="pt-20 pb-16">
        <Container size="md">
          <div className="py-12 text-center">
            <h1 className="text-h1 font-bold text-brand-slate mb-4">Product Not Found</h1>
            <p className="text-brand-gray mb-6">The product you're looking for doesn't exist.</p>
            <Link to="/products" className="text-brand-ocean hover:underline">
              ← Back to Products
            </Link>
          </div>
        </Container>
      </main>
    );
  }

  // Product images based on slug
  const productImages: Record<string, string> = {
    'vital-signs-monitor': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/143ad6b6-6b0e-4f05-b803-c7086e8a796c/VSP_(1)/w=800,quality=90,fit=scale-down',
    '12-lead-ecg': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/26f68a92-706c-42cd-8b35-02a84c3c98d7/12-lead_Notion_Cover/w=800,quality=90,fit=scale-down',
    'telemedicine-base-station': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c52c8fd3-dce9-4989-a374-49cb6534f5db/Telemedicine_Base_Station_(1)/w=800,quality=90,fit=scale-down',
    'semi-automatic-defibrillator': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/7f19e4a7-df0b-4bca-abee-453050f6f9fb/DeFib_Notion_Cover/w=800,quality=90,fit=scale-down',
    'oxygen-resuscitation-kit': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/24552e5d-9512-467b-a55a-86f6892cf0ab/Oxygen_Resuscitation_Kit_-_Notion_Cover_(1)/w=800,quality=90,fit=scale-down',
    'bleeding-control-kit': 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/01628833-765e-492a-92a1-dcd3d4b6dc01/Bleeding_Control_Kit_Notion_Cover/w=800,quality=90,fit=scale-down',
  };

  return (
    <main className="flex-1">
      {/* Header */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-brand-navy text-white">
        <Container>
          <motion.div initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }}>
            <Link to="/products" className="inline-flex items-center text-brand-sky hover:text-white mb-6">
              <ArrowLeft size={16} className="mr-2" />
              Back to Products
            </Link>
            
            <div className="grid lg:grid-cols-2 gap-8 lg:gap-12 items-center">
              <div>
                <div className="flex items-center gap-3 mb-4">
                  <Badge variant={
                    product.status === 'in-stock' ? 'success' : 
                    product.status === 'to-order' ? 'warning' : 'danger'
                  }>
                    {product.status === 'in-stock' ? 'In Stock' : 
                     product.status === 'to-order' ? 'To Order' : 'Not Available'}
                  </Badge>
                  <Badge variant="info">✓ Tested at Sea</Badge>
                </div>
                <h1 className="text-3xl md:text-4xl lg:text-display font-bold mb-4">{product.name}</h1>
                <p className="text-lg text-brand-sky-light/90 mb-6">{product.description}</p>
                
                <div className="flex items-center gap-4 mb-8">
                  <div className="flex items-center">
                    {[...Array(5)].map((_, i) => (
                      <Star key={i} size={18} className={i < 4 ? 'text-yellow-400 fill-yellow-400' : 'text-gray-500'} />
                    ))}
                  </div>
                  <span className="text-brand-sky text-sm">Verified by seafarers</span>
                </div>
                
                <div className="flex items-center gap-4">
                  {/* Show price unless it's telemedicine-base-station */}
                  {product.price && product.slug !== 'telemedicine-base-station' ? (
                    <span className="text-2xl font-bold text-white">
                      €{product.price.toLocaleString()}
                    </span>
                  ) : product.slug === 'telemedicine-base-station' ? (
                    <span className="text-xl font-semibold text-brand-sky">
                      Contact for pricing
                    </span>
                  ) : null}
                  <a 
                    href={`mailto:${QUOTE_EMAIL}?subject=Quote Request: ${encodeURIComponent(product.name)}`}
                    className="inline-flex items-center gap-2 px-6 py-3 bg-white text-[#0A1628] font-semibold rounded-lg hover:bg-gray-100 transition-colors"
                  >
                    Request Quote
                    <Mail size={20} />
                  </a>
                </div>
              </div>
              
              {/* Product Image */}
              <div className="bg-white rounded-2xl p-6 shadow-xl">
                <img
                  src={productImages[product.slug] || productImages['vital-signs-monitor']}
                  alt={product.name}
                  className="w-full h-auto object-contain max-h-80"
                />
              </div>
            </div>
          </motion.div>
        </Container>
      </section>

      {/* Features */}
      <section className="py-16">
        <Container>
          <ScrollReveal>
            <h2 className="text-h1 font-bold text-brand-slate mb-8">Key Features</h2>
            <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
              {product.features.map((feature, index) => (
                <div key={index} className="flex items-start gap-3 p-4 bg-surface-secondary rounded-lg">
                  <CheckCircle className="w-6 h-6 text-brand-green flex-shrink-0 mt-0.5" />
                  <span className="text-brand-slate font-medium">{feature}</span>
                </div>
              ))}
            </div>
          </ScrollReveal>
        </Container>
      </section>

      {/* Description */}
      <section className="py-16 bg-surface-secondary">
        <Container>
          <ScrollReveal>
            <h2 className="text-h1 font-bold text-brand-slate mb-8">Product Details</h2>
            <div className="grid md:grid-cols-2 gap-8">
              {/* Main Description */}
              <div className="bg-white rounded-xl p-6 shadow-sm">
                <h3 className="text-lg font-semibold text-brand-navy mb-4">Overview</h3>
                <div className="space-y-3">
                  {formatDescription(product.long_description || '').map((sentence, index) => (
                    <p key={index} className="text-brand-gray leading-relaxed flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>{sentence}</span>
                    </p>
                  ))}
                </div>
              </div>
              
              {/* Specifications Card */}
              <div className="bg-white rounded-xl p-6 shadow-sm">
                <h3 className="text-lg font-semibold text-brand-navy mb-4">Specifications</h3>
                <div className="space-y-3">
                  {product.features.map((feature, index) => (
                    <div key={index} className="flex items-center gap-3 py-2 border-b border-gray-100 last:border-0">
                      <CheckCircle className="w-5 h-5 text-brand-green flex-shrink-0" />
                      <span className="text-brand-slate">{feature}</span>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </ScrollReveal>
        </Container>
      </section>

      {/* Important Notice */}
      <section className="py-12 bg-amber-50 border-y border-amber-200">
        <Container>
          <ScrollReveal>
            <div className="flex flex-col md:flex-row items-start gap-6">
              <div className="flex-shrink-0">
                <div className="w-14 h-14 bg-amber-100 rounded-full flex items-center justify-center">
                  <AlertTriangle className="w-7 h-7 text-amber-600" />
                </div>
              </div>
              <div className="flex-1">
                <h3 className="text-lg font-bold text-amber-800 mb-2">Important Notice</h3>
                <p className="text-amber-700 mb-4">
                  Medical equipment alone is not sufficient to handle a medical emergency at sea. 
                  Effective communication with an emergency medicine doctor is essential for proper 
                  diagnosis and treatment guidance during any medical incident onboard.
                </p>
                <div className="flex items-start gap-3 bg-amber-100/50 rounded-lg p-4">
                  <Phone className="w-5 h-5 text-amber-700 mt-0.5 flex-shrink-0" />
                  <div>
                    <p className="font-semibold text-amber-800">We recommend MSOS (Medical Support Offshore)</p>
                    <p className="text-sm text-amber-700 mt-1">
                      24/7 telemedicine service providing immediate access to emergency medicine physicians 
                      who can guide you through any medical situation at sea.
                    </p>
                    <a 
                      href="https://www.msos.org.uk/telemedical-support" 
                      target="_blank" 
                      rel="noopener noreferrer"
                      className="inline-flex items-center gap-1 text-amber-800 hover:text-amber-900 hover:underline mt-2 text-sm font-medium"
                    >
                      Learn more about MSOS <ExternalLink size={14} />
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </ScrollReveal>
        </Container>
      </section>

      {/* CTA */}
      <section className="py-16 bg-brand-navy text-white">
        <Container>
          <ScrollReveal>
            <div className="text-center">
              <h2 className="text-h1 font-bold mb-4">Interested in {product.name}?</h2>
              <p className="text-brand-sky mb-8 max-w-2xl mx-auto">
                Contact us for pricing, availability, and technical specifications. Our team is ready to help equip your vessel.
              </p>
              <div className="flex flex-col sm:flex-row gap-4 justify-center items-center">
                <div className="flex items-center gap-4">
                  {/* Show price unless it's telemedicine-base-station */}
                  {product.price && product.slug !== 'telemedicine-base-station' ? (
                    <span className="text-2xl font-bold text-white">
                      €{product.price.toLocaleString()}
                    </span>
                  ) : product.slug === 'telemedicine-base-station' ? (
                    <span className="text-xl font-semibold text-brand-sky">
                      Contact for pricing
                    </span>
                  ) : null}
                  <a 
                    href={`mailto:${QUOTE_EMAIL}?subject=Quote Request: ${encodeURIComponent(product.name)}`}
                    className="inline-flex items-center gap-2 px-6 py-3 bg-brand-ocean text-white font-semibold rounded-lg hover:bg-brand-ocean/90 transition-colors"
                  >
                    Request Quote
                    <Mail size={20} />
                  </a>
                </div>
                <Link to="/contact">
                  <Button variant="outline" size="lg" className="border-white text-white hover:bg-white hover:text-brand-navy">
                    Contact Us
                  </Button>
                </Link>
              </div>
            </div>
          </ScrollReveal>
        </Container>
      </section>
    </main>
  );
}

export default ProductDetail;
