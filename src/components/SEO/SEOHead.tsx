import { Helmet } from 'react-helmet-async';

interface SEOHeadProps {
  title?: string;
  description?: string;
  keywords?: string[];
  image?: string;
  url?: string;
  type?: 'website' | 'article' | 'product';
  publishedTime?: string;
  modifiedTime?: string;
  author?: string;
  section?: string;
  noindex?: boolean;
  jsonLd?: object;
}

const SITE_NAME = 'BlueCross Medical';
const DEFAULT_TITLE = 'Maritime Emergency Medicine';
const DEFAULT_DESCRIPTION = 'Your complete resource for emergency medicine at sea. Flag state regulations, advanced training courses, knowledge articles, and tested equipment.';
const DEFAULT_IMAGE = 'https://www.bluecross.tech/og-image.jpg';
const SITE_URL = 'https://www.bluecross.tech';

export default function SEOHead({
  title,
  description = DEFAULT_DESCRIPTION,
  keywords = [],
  image = DEFAULT_IMAGE,
  url,
  type = 'website',
  publishedTime,
  modifiedTime,
  author,
  section,
  noindex = false,
  jsonLd,
}: SEOHeadProps) {
  const fullTitle = title ? `${title} | ${SITE_NAME}` : `${SITE_NAME} | ${DEFAULT_TITLE}`;
  const canonicalUrl = url ? `${SITE_URL}${url}` : SITE_URL;
  const safeImage = image || DEFAULT_IMAGE;
  const fullImageUrl = safeImage.startsWith('http') ? safeImage : `${SITE_URL}${safeImage}`;

  // Default organization schema
  const organizationSchema = {
    '@context': 'https://schema.org',
    '@type': 'Organization',
    name: 'BlueCross Medical',
    url: SITE_URL,
    logo: `${SITE_URL}/favicon.svg`,
    description: DEFAULT_DESCRIPTION,
    sameAs: [
      // Add social media URLs when available
    ],
    contactPoint: {
      '@type': 'ContactPoint',
      email: 'bluecross@marsoft.ai',
      contactType: 'sales',
    },
  };

  // Medical business schema
  const medicalBusinessSchema = {
    '@context': 'https://schema.org',
    '@type': 'MedicalBusiness',
    name: 'BlueCross Medical',
    url: SITE_URL,
    description: 'Maritime emergency medicine training, equipment, and consulting services.',
    priceRange: '$$',
    areaServed: {
      '@type': 'Place',
      name: 'Worldwide',
    },
    hasOfferCatalog: {
      '@type': 'OfferCatalog',
      name: 'Maritime Medical Services',
      itemListElement: [
        {
          '@type': 'Offer',
          itemOffered: {
            '@type': 'Service',
            name: 'Maritime Medical Training',
          },
        },
        {
          '@type': 'Offer',
          itemOffered: {
            '@type': 'Product',
            name: 'Maritime Medical Equipment',
          },
        },
      ],
    },
  };

  // Article schema for blog posts
  const articleSchema = type === 'article' ? {
    '@context': 'https://schema.org',
    '@type': 'Article',
    headline: title,
    description: description,
    image: fullImageUrl,
    author: {
      '@type': 'Person',
      name: author || 'BlueCross Medical',
    },
    publisher: {
      '@type': 'Organization',
      name: 'BlueCross Medical',
      logo: {
        '@type': 'ImageObject',
        url: `${SITE_URL}/favicon.svg`,
      },
    },
    datePublished: publishedTime,
    dateModified: modifiedTime || publishedTime,
    mainEntityOfPage: {
      '@type': 'WebPage',
      '@id': canonicalUrl,
    },
    articleSection: section,
  } : null;

  // Breadcrumb schema
  const breadcrumbSchema = url && url !== '/' ? {
    '@context': 'https://schema.org',
    '@type': 'BreadcrumbList',
    itemListElement: [
      {
        '@type': 'ListItem',
        position: 1,
        name: 'Home',
        item: SITE_URL,
      },
      {
        '@type': 'ListItem',
        position: 2,
        name: title || 'Page',
        item: canonicalUrl,
      },
    ],
  } : null;

  const defaultKeywords = [
    'maritime medicine',
    'emergency medicine at sea',
    'yacht medical',
    'superyacht medical',
    'flag state regulations',
    'maritime medical training',
    'ship medical equipment',
    'MLC medical',
    'STCW medical',
  ];

  const allKeywords = [...new Set([...keywords, ...defaultKeywords])];

  return (
    <Helmet>
      {/* Basic Meta Tags */}
      <title>{fullTitle}</title>
      <meta name="description" content={description} />
      <meta name="keywords" content={allKeywords.join(', ')} />
      {noindex && <meta name="robots" content="noindex, nofollow" />}
      
      {/* Canonical URL */}
      <link rel="canonical" href={canonicalUrl} />
      
      {/* Language */}
      <html lang="en" />
      <meta httpEquiv="content-language" content="en" />
      
      {/* Open Graph / Facebook */}
      <meta property="og:type" content={type} />
      <meta property="og:url" content={canonicalUrl} />
      <meta property="og:title" content={fullTitle} />
      <meta property="og:description" content={description} />
      <meta property="og:image" content={fullImageUrl} />
      <meta property="og:image:width" content="1200" />
      <meta property="og:image:height" content="630" />
      <meta property="og:site_name" content={SITE_NAME} />
      <meta property="og:locale" content="en_US" />
      
      {/* Article specific OG tags */}
      {type === 'article' && publishedTime && (
        <meta property="article:published_time" content={publishedTime} />
      )}
      {type === 'article' && modifiedTime && (
        <meta property="article:modified_time" content={modifiedTime} />
      )}
      {type === 'article' && author && (
        <meta property="article:author" content={author} />
      )}
      {type === 'article' && section && (
        <meta property="article:section" content={section} />
      )}
      
      {/* Twitter Card */}
      <meta name="twitter:card" content="summary_large_image" />
      <meta name="twitter:url" content={canonicalUrl} />
      <meta name="twitter:title" content={fullTitle} />
      <meta name="twitter:description" content={description} />
      <meta name="twitter:image" content={fullImageUrl} />
      
      {/* Additional SEO Tags */}
      <meta name="author" content={author || 'BlueCross Medical'} />
      <meta name="publisher" content="BlueCross Medical" />
      <meta name="copyright" content="BlueCross Medical" />
      
      {/* GEO Tags for local SEO */}
      <meta name="geo.region" content="GR" />
      <meta name="geo.placename" content="Athens" />
      
      {/* Mobile & PWA */}
      <meta name="theme-color" content="#1e3a5f" />
      <meta name="apple-mobile-web-app-capable" content="yes" />
      <meta name="apple-mobile-web-app-status-bar-style" content="default" />
      <meta name="apple-mobile-web-app-title" content={SITE_NAME} />
      
      {/* JSON-LD Structured Data */}
      <script type="application/ld+json">
        {JSON.stringify(organizationSchema)}
      </script>
      <script type="application/ld+json">
        {JSON.stringify(medicalBusinessSchema)}
      </script>
      {articleSchema && (
        <script type="application/ld+json">
          {JSON.stringify(articleSchema)}
        </script>
      )}
      {breadcrumbSchema && (
        <script type="application/ld+json">
          {JSON.stringify(breadcrumbSchema)}
        </script>
      )}
      {jsonLd && (
        <script type="application/ld+json">
          {JSON.stringify(jsonLd)}
        </script>
      )}
    </Helmet>
  );
}
