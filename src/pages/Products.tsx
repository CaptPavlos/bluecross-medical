/** Maritime medical equipment catalog and comparison page. */
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import {
  AlertTriangle,
  ArrowRight,
  CheckCircle,
  ClipboardCheck,
  Clock,
  Package,
  ShieldCheck,
  Truck,
} from 'lucide-react';
import { ProductGrid } from '../components/Features';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';
import { SEOHead } from '../components/SEO';
import { MOCK_PRODUCTS } from '../lib/constants';

const SITE_URL = 'https://www.bluecross.tech';
const PAGE_URL = `${SITE_URL}/products`;
const PAGE_DESCRIPTION = 'Compare maritime medical equipment for ships and yachts, including portable ECG, AED, oxygen, trauma, vital-sign and telemedicine options for onboard use.';

const comparisonDetails: Record<string, { use: string; model: string; certification: string }> = {
  'vital-signs-monitor': {
    use: 'Portable ECG, SpO₂, heart-rate and basic vital-sign checks',
    model: 'Checkme Pro+',
    certification: 'CE marking stated in the product information',
  },
  '12-lead-ecg': {
    use: 'Recording and transmitting a diagnostic 12-lead ECG',
    model: 'Lepu Neo ECG S120',
    certification: 'CE marking stated in the product information',
  },
  'telemedicine-base-station': {
    use: 'Multi-parameter examinations during remote medical consultation',
    model: 'Parsys S3',
    certification: 'CE 0459, Class IIa under MDR 2017/745 and ISO 13485:2016 stated',
  },
  'semi-automatic-defibrillator': {
    use: 'AED response with real-time CPR feedback',
    model: 'HeartSine samaritan PAD 500P',
    certification: 'CE and FDA approval stated in the product information',
  },
  'oxygen-resuscitation-kit': {
    use: 'Emergency oxygen delivery and assisted ventilation',
    model: 'Configurable 2 L or 5 L kit',
    certification: 'MCA MSN 1768 and SOLAS compliance stated',
  },
  'bleeding-control-kit': {
    use: 'Initial control of severe external bleeding and penetrating trauma',
    model: 'Configured trauma pouch',
    certification: 'Contents selected around TCCC guidance; no device certification stated',
  },
};

const availabilityDetails = {
  'in-stock': 'In stock — indicative dispatch next business day',
  'to-order': 'To order — indicative lead time 7–10 days',
  'not-available': 'Not currently available — allow 30+ days if sourcing reopens',
};

const faqEntries = [
  {
    question: 'Which medical equipment does my vessel need?',
    answer: 'The required inventory depends on the flag state, vessel type and size, operating area and voyage, and the number and role of people onboard. Check the applicable authority sources and obtain professional advice before purchasing.',
  },
  {
    question: 'How should I verify a product certification?',
    answer: 'Ask for the current declaration of conformity, certificate and manufacturer documentation for the exact model and market supplied. A product-family statement or website description is not a substitute for model-specific evidence.',
  },
  {
    question: 'What do the availability labels mean?',
    answer: 'In stock usually means indicative dispatch the next business day; to order usually means 7–10 days; not currently available may require 30 days or more if sourcing reopens. Confirm stock and delivery timing in a written quote.',
  },
  {
    question: 'Does carrying equipment replace medical training or telemedical support?',
    answer: 'No. Equipment should be supported by trained responders, drills, maintenance and access to appropriate medical or telemedical advice. Follow the device instructions and your vessel procedures during an emergency.',
  },
];

const productsJsonLd = {
  '@context': 'https://schema.org',
  '@graph': [
    {
      '@type': 'CollectionPage',
      '@id': `${PAGE_URL}#collection`,
      url: PAGE_URL,
      name: 'Maritime Medical Equipment for Ships and Yachts',
      description: PAGE_DESCRIPTION,
      isPartOf: { '@id': `${SITE_URL}/#website` },
      mainEntity: { '@id': `${PAGE_URL}#equipment-list` },
      inLanguage: 'en',
    },
    {
      '@type': 'ItemList',
      '@id': `${PAGE_URL}#equipment-list`,
      name: 'Onboard maritime medical equipment',
      numberOfItems: MOCK_PRODUCTS.length,
      itemListElement: MOCK_PRODUCTS.map((product, index) => ({
        '@type': 'ListItem',
        position: index + 1,
        item: {
          '@type': 'Product',
          '@id': `${SITE_URL}/products/${product.slug}#product`,
          name: product.name,
          description: product.description,
          image: `${SITE_URL}${product.image_url}`,
          url: `${SITE_URL}/products/${product.slug}`,
        },
      })),
    },
    {
      '@type': 'FAQPage',
      '@id': `${PAGE_URL}#faq`,
      mainEntity: faqEntries.map((entry) => ({
        '@type': 'Question',
        name: entry.question,
        acceptedAnswer: {
          '@type': 'Answer',
          text: entry.answer,
        },
      })),
    },
  ],
};

/** Catalog page with evidence-qualified claims and vessel-selection guidance. */
function Products() {
  return (
    <main className="flex-1 overflow-x-clip">
      <SEOHead
        title="Maritime Medical Equipment for Ships & Yachts"
        description={PAGE_DESCRIPTION}
        url="/products"
        image="/og-image.png"
        imageAlt="BlueCross Medical maritime equipment guide for ships and yachts"
        keywords={['maritime medical equipment', 'ship medical equipment', 'yacht medical supplies', 'marine AED', 'onboard ECG']}
        jsonLd={productsJsonLd}
      />

      <section className="bg-gradient-to-br from-brand-navy to-brand-blue pb-12 pt-24 md:pb-16 md:pt-28">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="mx-auto max-w-3xl text-center"
          >
            <p className="mb-3 text-sm font-semibold uppercase tracking-[0.16em] text-brand-sky">
              Onboard equipment guide
            </p>
            <h1 className="mb-4 text-3xl font-bold leading-tight text-white sm:text-display md:text-5xl">
              Maritime Medical Equipment for Ships and Yachts
            </h1>
            <p className="mx-auto max-w-2xl text-base leading-relaxed text-brand-sky-light sm:text-lg md:text-xl">
              Compare practical options for monitoring, resuscitation, trauma response and remote medical consultation at sea.
            </p>
          </motion.div>
        </Container>
      </section>

      <section className="border-b border-gray-200 bg-surface-secondary py-6" aria-labelledby="availability-heading">
        <Container>
          <h2 id="availability-heading" className="sr-only">Availability guide</h2>
          <div className="grid gap-3 sm:grid-cols-3 sm:gap-4">
            {[
              { icon: Package, title: 'In stock', detail: 'Indicative next-business-day dispatch', bgClass: 'bg-green-100', textClass: 'text-green-600' },
              { icon: Truck, title: 'To order', detail: 'Indicative 7–10 day lead time', bgClass: 'bg-yellow-100', textClass: 'text-yellow-600' },
              { icon: Clock, title: 'Not available', detail: '30+ days if sourcing reopens', bgClass: 'bg-red-100', textClass: 'text-red-600' },
            ].map(({ icon: Icon, title, detail, bgClass, textClass }) => (
              <div key={title} className="flex min-w-0 items-center gap-3 rounded-xl bg-white p-3 shadow-sm">
                <span className={`flex h-10 w-10 shrink-0 items-center justify-center rounded-full ${bgClass}`}>
                  <Icon size={18} className={textClass} aria-hidden="true" />
                </span>
                <span className="min-w-0">
                  <span className="block font-semibold text-brand-navy">{title}</span>
                  <span className="block text-xs leading-snug text-brand-gray">{detail}</span>
                </span>
              </div>
            ))}
          </div>
          <p className="mt-3 text-center text-xs text-brand-gray">
            Availability is indicative and can change; request a written quote for current stock and delivery timing.
          </p>
        </Container>
      </section>

      <section className="py-12 md:py-16" aria-labelledby="catalog-heading">
        <Container>
          <ScrollReveal>
            <div className="mb-7 max-w-3xl">
              <h2 id="catalog-heading" className="mb-3 text-h1 font-bold text-brand-navy">
                Compare onboard medical equipment
              </h2>
              <p className="text-brand-gray">
                Start with the onboard use case, then confirm the exact model, documentation, consumables and service support before ordering.
              </p>
            </div>
            <ProductGrid showFilters />
          </ScrollReveal>
        </Container>
      </section>

      <section className="bg-surface-secondary py-12 md:py-16" aria-labelledby="comparison-heading">
        <Container>
          <ScrollReveal>
            <div className="mb-7 max-w-3xl">
              <h2 id="comparison-heading" className="mb-3 text-h1 font-bold text-brand-navy">
                Equipment comparison and certification notes
              </h2>
              <p className="text-brand-gray">
                These notes reflect the product information shown on this site. Ask for current, model-specific evidence before relying on any conformity or compliance statement.
              </p>
            </div>

            <div className="max-w-full overflow-x-auto rounded-xl border border-slate-200 bg-white shadow-sm" tabIndex={0} aria-label="Scrollable medical equipment comparison table">
              <table className="min-w-[980px] border-collapse text-left text-sm">
                <caption className="sr-only">Comparison of model, onboard use, stated certifications and indicative availability</caption>
                <thead className="bg-brand-navy text-white">
                  <tr>
                    <th scope="col" className="px-4 py-4 font-semibold">Equipment</th>
                    <th scope="col" className="px-4 py-4 font-semibold">Model or configuration</th>
                    <th scope="col" className="px-4 py-4 font-semibold">Primary onboard use</th>
                    <th scope="col" className="px-4 py-4 font-semibold">Certification / guidance shown</th>
                    <th scope="col" className="px-4 py-4 font-semibold">Availability / lead time</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-slate-200">
                  {MOCK_PRODUCTS.map((product) => {
                    const detail = comparisonDetails[product.slug];
                    return (
                      <tr key={product.slug} className="align-top odd:bg-white even:bg-slate-50/70">
                        <th scope="row" className="px-4 py-4 font-semibold text-brand-navy">
                          <Link to={`/products/${product.slug}`} className="text-brand-ocean hover:underline">
                            {product.name}
                          </Link>
                        </th>
                        <td className="px-4 py-4 text-brand-slate">{detail.model}</td>
                        <td className="px-4 py-4 text-brand-slate">{detail.use}</td>
                        <td className="px-4 py-4 text-brand-slate">{detail.certification}</td>
                        <td className="px-4 py-4 text-brand-slate">{availabilityDetails[product.status]}</td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          </ScrollReveal>
        </Container>
      </section>

      <section className="py-12 md:py-16" aria-labelledby="method-heading">
        <Container>
          <ScrollReveal>
            <div className="mx-auto mb-9 max-w-3xl text-center">
              <h2 id="method-heading" className="mb-3 text-h1 font-bold text-brand-navy">
                How to select and verify equipment
              </h2>
              <p className="text-brand-gray">
                We review suitability for constrained onboard environments, the documentation made available for the listed model, and how the equipment fits training, maintenance and remote-support workflows.
              </p>
            </div>
          </ScrollReveal>

          <div className="grid gap-5 md:grid-cols-3">
            {[
              { icon: ClipboardCheck, title: 'Start with the use case', desc: 'Define likely incidents, operating environment, connectivity, power, storage and responder capability.' },
              { icon: ShieldCheck, title: 'Check exact-model evidence', desc: 'Review current declarations, certificates, instructions, service life and consumable availability.' },
              { icon: CheckCircle, title: 'Plan the full response', desc: 'Pair equipment with training, drills, maintenance records and appropriate medical support.' },
            ].map(({ icon: Icon, title, desc }) => (
              <article key={title} className="rounded-xl border border-brand-ocean/10 bg-white p-5 shadow-sm sm:p-6">
                <span className="mb-4 flex h-11 w-11 items-center justify-center rounded-xl bg-brand-ocean/10 text-brand-ocean">
                  <Icon size={23} aria-hidden="true" />
                </span>
                <h3 className="mb-2 text-lg font-semibold text-brand-navy">{title}</h3>
                <p className="text-sm leading-relaxed text-brand-gray">{desc}</p>
              </article>
            ))}
          </div>

          <div className="mt-8 rounded-xl border border-amber-200 bg-amber-50 p-5 sm:p-6">
            <div className="flex items-start gap-3">
              <AlertTriangle className="mt-0.5 h-6 w-6 shrink-0 text-amber-700" aria-hidden="true" />
              <div>
                <h3 className="mb-1 font-semibold text-amber-900">Vessel-specific safety and compliance note</h3>
                <p className="text-sm leading-relaxed text-amber-800">
                  Requirements vary by flag state, vessel type and size, voyage or operating area, and the number and roles of people onboard. Product information on this page is not a substitute for the applicable rules, a competent risk assessment or professional medical advice.
                </p>
              </div>
            </div>
          </div>

          <div className="mt-7 flex flex-col gap-3 sm:flex-row sm:justify-center">
            <Link to="/flags" className="inline-flex min-h-[44px] items-center justify-center gap-2 rounded-lg bg-brand-ocean px-5 py-3 font-semibold text-white hover:bg-brand-ocean-light">
              Check flag requirements <ArrowRight size={18} aria-hidden="true" />
            </Link>
            <Link to="/training" className="inline-flex min-h-[44px] items-center justify-center gap-2 rounded-lg border-2 border-brand-ocean px-5 py-3 font-semibold text-brand-ocean hover:bg-brand-ocean hover:text-white">
              Explore medical training <ArrowRight size={18} aria-hidden="true" />
            </Link>
          </div>
        </Container>
      </section>

      <section className="bg-brand-navy py-12 text-white md:py-16" aria-labelledby="faq-heading">
        <Container size="md">
          <h2 id="faq-heading" className="mb-7 text-h1 font-bold">Maritime equipment FAQs</h2>
          <div className="space-y-3">
            {faqEntries.map((entry) => (
              <details key={entry.question} className="group rounded-xl border border-white/15 bg-white/5">
                <summary className="flex min-h-[52px] cursor-pointer list-none items-center justify-between gap-4 px-4 py-3 font-semibold text-white marker:content-none sm:px-5">
                  <span>{entry.question}</span>
                  <span className="text-2xl font-light text-brand-sky transition-transform group-open:rotate-45" aria-hidden="true">+</span>
                </summary>
                <p className="px-4 pb-5 leading-relaxed text-brand-sky-light sm:px-5">{entry.answer}</p>
              </details>
            ))}
          </div>
        </Container>
      </section>
    </main>
  );
}

export default Products;
