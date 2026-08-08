/** Individual maritime medical equipment detail page. */
import { useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import {
  AlertTriangle,
  ArrowLeft,
  CheckCircle,
  ExternalLink,
  Mail,
  Package,
  Phone,
} from 'lucide-react';
import { motion } from 'framer-motion';
import Container from '../components/Common/Container';
import { Badge } from '../components/Common';
import { ScrollReveal } from '../components/Animations';
import { SEOHead } from '../components/SEO';
import { MOCK_PRODUCTS } from '../lib/constants';
import type { ProductStatus } from '../lib/types';

const QUOTE_EMAIL = 'sales@bluecross.tech';
const SITE_URL = 'https://www.bluecross.tech';

const schemaAvailability: Record<ProductStatus, string> = {
  'in-stock': 'https://schema.org/InStock',
  'to-order': 'https://schema.org/BackOrder',
  'not-available': 'https://schema.org/OutOfStock',
};

const statusLabels: Record<ProductStatus, string> = {
  'in-stock': 'In Stock',
  'to-order': 'To Order',
  'not-available': 'Not Available',
};

const statusVariants: Record<ProductStatus, 'success' | 'warning' | 'danger'> = {
  'in-stock': 'success',
  'to-order': 'warning',
  'not-available': 'danger',
};

const prePurchaseChecks = [
  'Confirm the exact model, configuration and included accessories in writing.',
  'Request current conformity documents for the supplied model and destination market.',
  'Check service life, warranty, maintenance, calibration and inspection requirements.',
  'Plan replacement batteries, electrodes, sensors or other consumables as applicable.',
  'Confirm delivery terms, technical support and the process for reporting a device issue.',
];

/** Breaks the legacy paragraph into shorter readable statements. */
function formatDescription(text: string) {
  return text
    .split('. ')
    .map((sentence) => sentence.trim())
    .filter(Boolean)
    .map((sentence) => sentence.endsWith('.') ? sentence : `${sentence}.`);
}

function ProductDetail() {
  const { slug } = useParams<{ slug: string }>();
  const product = MOCK_PRODUCTS.find((candidate) => candidate.slug === slug);
  const [failedImageUrl, setFailedImageUrl] = useState<string | null>(null);

  if (!product) {
    const missingPath = `/products/${encodeURIComponent(slug || 'not-found')}`;

    return (
      <main className="pb-16 pt-20">
        <SEOHead
          title="Product Not Found"
          description="This equipment page could not be found. Browse the current BlueCross Medical equipment catalog."
          url={missingPath}
          noindex
        />
        <Container size="md">
          <div className="py-12 text-center">
            <h1 className="mb-4 text-h1 font-bold text-brand-slate">Product Not Found</h1>
            <p className="mb-6 text-brand-gray">The equipment page you requested does not exist.</p>
            <Link to="/products" className="inline-flex min-h-[44px] items-center justify-center rounded-lg px-4 font-semibold text-brand-ocean hover:bg-brand-ocean/10">
              <ArrowLeft size={18} className="mr-2" aria-hidden="true" />
              Back to equipment
            </Link>
          </div>
        </Container>
      </main>
    );
  }

  const canonicalPath = `/products/${product.slug}`;
  const canonicalUrl = `${SITE_URL}${canonicalPath}`;
  const productImageUrl = new URL(product.image_url || '/og-image.png', `${SITE_URL}/`).toString();
  const displayPrice = typeof product.price === 'number' ? product.price : null;
  const hasWorkingImage = Boolean(product.image_url && failedImageUrl !== product.image_url);
  const productSchema = {
    '@context': 'https://schema.org',
    '@type': 'Product',
    '@id': `${canonicalUrl}#product`,
    name: product.name,
    image: productImageUrl,
    description: product.description,
    url: canonicalUrl,
    category: 'Maritime medical equipment',
    ...(displayPrice !== null ? {
      offers: {
        '@type': 'Offer',
        url: canonicalUrl,
        price: displayPrice,
        priceCurrency: 'EUR',
        availability: schemaAvailability[product.status],
        itemCondition: 'https://schema.org/NewCondition',
        seller: { '@id': `${SITE_URL}/#organization` },
      },
    } : {}),
  };

  return (
    <main className="flex-1 overflow-x-clip">
      <SEOHead
        title={`${product.name} for Maritime Use`}
        description={`${product.description} Review onboard use, stated product documentation, availability and quote information.`}
        url={canonicalPath}
        type="product"
        image="/og-image.png"
        imageAlt={`${product.name} maritime equipment information from BlueCross Medical`}
        keywords={[product.name, 'maritime medical equipment', 'ship medical equipment', 'yacht medical equipment']}
        jsonLd={productSchema}
      />

      <section className="bg-brand-navy pb-12 pt-24 text-white md:pb-16 md:pt-28">
        <Container>
          <motion.div initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }}>
            <Link to="/products" className="mb-5 inline-flex min-h-[44px] items-center text-brand-sky hover:text-white">
              <ArrowLeft size={17} className="mr-2" aria-hidden="true" />
              Back to equipment
            </Link>

            <div className="grid items-center gap-8 lg:grid-cols-2 lg:gap-12">
              <div className="min-w-0">
                <div className="mb-4 flex flex-wrap items-center gap-3">
                  <Badge variant={statusVariants[product.status]}>{statusLabels[product.status]}</Badge>
                </div>
                <h1 className="mb-4 break-words text-3xl font-bold leading-tight md:text-4xl lg:text-display">
                  {product.name}
                </h1>
                <p className="mb-7 text-base leading-relaxed text-brand-sky-light/90 sm:text-lg">
                  {product.description}
                </p>

                <div className="flex flex-col items-stretch gap-3 sm:flex-row sm:items-center">
                  <span className="text-xl font-bold text-white sm:text-2xl">
                    {displayPrice !== null ? `€${displayPrice.toLocaleString()}` : 'Contact for pricing'}
                  </span>
                  <a
                    href={`mailto:${QUOTE_EMAIL}?subject=Quote Request: ${encodeURIComponent(product.name)}`}
                    className="inline-flex min-h-[44px] w-full items-center justify-center gap-2 rounded-lg bg-white px-5 py-3 font-semibold text-brand-navy transition-colors hover:bg-gray-100 sm:w-auto"
                  >
                    Request quote
                    <Mail size={19} aria-hidden="true" />
                  </a>
                </div>
              </div>

              <div className="overflow-hidden rounded-2xl bg-white p-3 shadow-xl sm:p-6">
                {hasWorkingImage ? (
                  <img
                    src={product.image_url}
                    alt={`${product.name} — branded illustrative product view`}
                    width={800}
                    height={450}
                    loading="eager"
                    {...{ fetchpriority: 'high' }}
                    decoding="async"
                    onError={() => setFailedImageUrl(product.image_url || null)}
                    className="aspect-video h-auto w-full object-contain"
                  />
                ) : (
                  <div className="flex aspect-video flex-col items-center justify-center gap-3 rounded-xl bg-gradient-to-br from-brand-navy via-brand-blue to-brand-ocean text-white">
                    <span className="flex h-20 w-20 items-center justify-center rounded-2xl bg-white/15 ring-1 ring-white/25">
                      <Package size={42} aria-hidden="true" />
                    </span>
                    <span className="text-sm font-medium text-brand-sky-light">Product illustration unavailable</span>
                  </div>
                )}
              </div>
            </div>
          </motion.div>
        </Container>
      </section>

      <section className="py-12 md:py-16" aria-labelledby="features-heading">
        <Container>
          <ScrollReveal>
            <h2 id="features-heading" className="mb-7 text-h1 font-bold text-brand-slate">Key features</h2>
            <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3 md:gap-6">
              {product.features.map((feature) => (
                <div key={feature} className="flex items-start gap-3 rounded-lg bg-surface-secondary p-4">
                  <CheckCircle className="mt-0.5 h-6 w-6 shrink-0 text-brand-green" aria-hidden="true" />
                  <span className="font-medium text-brand-slate">{feature}</span>
                </div>
              ))}
            </div>
          </ScrollReveal>
        </Container>
      </section>

      <section className="bg-surface-secondary py-12 md:py-16" aria-labelledby="details-heading">
        <Container>
          <ScrollReveal>
            <h2 id="details-heading" className="mb-7 text-h1 font-bold text-brand-slate">Product details</h2>
            <div className="grid gap-6 md:grid-cols-2 md:gap-8">
              <article className="rounded-xl bg-white p-5 shadow-sm sm:p-6">
                <h3 className="mb-4 text-lg font-semibold text-brand-navy">Overview</h3>
                <div className="space-y-3">
                  {formatDescription(product.long_description || '').map((sentence) => (
                    <p key={sentence} className="flex items-start gap-2 leading-relaxed text-brand-gray">
                      <span className="mt-2 h-1.5 w-1.5 shrink-0 rounded-full bg-brand-ocean" aria-hidden="true" />
                      <span>{sentence}</span>
                    </p>
                  ))}
                </div>
              </article>

              <article className="rounded-xl bg-white p-5 shadow-sm sm:p-6">
                <h3 className="mb-2 text-lg font-semibold text-brand-navy">Pre-purchase checks</h3>
                <p className="mb-4 text-sm leading-relaxed text-brand-gray">
                  Use the product details as a starting point, then verify the supplied item and evidence.
                </p>
                <div className="space-y-3">
                  {prePurchaseChecks.map((check) => (
                    <div key={check} className="flex items-start gap-3 border-b border-gray-100 py-2 last:border-0">
                      <CheckCircle className="h-5 w-5 shrink-0 text-brand-green" aria-hidden="true" />
                      <span className="text-brand-slate">{check}</span>
                    </div>
                  ))}
                </div>
              </article>
            </div>
          </ScrollReveal>
        </Container>
      </section>

      <section className="border-y border-amber-200 bg-amber-50 py-12" aria-labelledby="before-onboard-heading">
        <Container>
          <ScrollReveal>
            <div className="flex flex-col items-start gap-5 md:flex-row md:gap-6">
              <span className="flex h-14 w-14 shrink-0 items-center justify-center rounded-full bg-amber-100">
                <AlertTriangle className="h-7 w-7 text-amber-700" aria-hidden="true" />
              </span>
              <div className="min-w-0 flex-1">
                <h2 id="before-onboard-heading" className="mb-3 text-xl font-bold text-amber-900">Before placing this equipment onboard</h2>
                <p className="mb-4 leading-relaxed text-amber-800">
                  Descriptions and conformity statements on this page are based on the manufacturer or supplier information available for the named product. The image is a branded illustration, not product photography. Confirm the exact supplied model, current declaration or certificate, intended use, consumables, service support and delivery terms before purchase.
                </p>
                <p className="mb-5 leading-relaxed text-amber-800">
                  Medical-chest and equipment requirements vary by <Link to="/flags" className="font-semibold underline underline-offset-2 hover:text-amber-950">flag state</Link>, vessel type and size, voyage or operating area, and people onboard. Equipment also requires competent responders; review the available <Link to="/training" className="font-semibold underline underline-offset-2 hover:text-amber-950">maritime medical training</Link> options.
                </p>

                <div className="flex items-start gap-3 rounded-lg bg-amber-100/70 p-4">
                  <Phone className="mt-0.5 h-5 w-5 shrink-0 text-amber-800" aria-hidden="true" />
                  <div>
                    <h3 className="font-semibold text-amber-900">Plan access to appropriate medical support</h3>
                    <p className="mt-1 text-sm leading-relaxed text-amber-800">
                      Medical equipment does not replace clinical judgment. Establish a suitable telemedical pathway and follow your emergency procedures and device instructions.
                    </p>
                    <a
                      href="https://www.msos.org.uk/telemedical-support"
                      target="_blank"
                      rel="noopener noreferrer"
                      className="mt-2 inline-flex min-h-[44px] items-center gap-1 py-2 text-sm font-semibold text-amber-900 hover:underline"
                    >
                      Learn about MSOS telemedical support <ExternalLink size={14} aria-hidden="true" />
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </ScrollReveal>
        </Container>
      </section>

      <section className="bg-brand-navy py-12 text-white md:py-16" aria-labelledby="quote-heading">
        <Container>
          <ScrollReveal>
            <div className="mx-auto max-w-3xl text-center">
              <h2 id="quote-heading" className="mb-4 text-h1 font-bold">Request current information for {product.name}</h2>
              <p className="mx-auto mb-7 max-w-2xl text-brand-sky-light">
                Ask about current availability, delivery, the exact supplied configuration and supporting technical documents.
              </p>
              <div className="flex flex-col items-stretch justify-center gap-3 sm:flex-row sm:items-center">
                <span className="text-xl font-bold sm:text-2xl">
                  {displayPrice !== null ? `€${displayPrice.toLocaleString()}` : 'Contact for pricing'}
                </span>
                <a
                  href={`mailto:${QUOTE_EMAIL}?subject=Quote Request: ${encodeURIComponent(product.name)}`}
                  className="inline-flex min-h-[44px] items-center justify-center gap-2 rounded-lg bg-brand-ocean px-5 py-3 font-semibold text-white hover:bg-brand-ocean-light"
                >
                  Request quote <Mail size={19} aria-hidden="true" />
                </a>
                <Link to="/contact" className="inline-flex min-h-[44px] items-center justify-center rounded-lg border-2 border-white px-5 py-3 font-semibold text-white hover:bg-white hover:text-brand-navy">
                  Contact us
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
