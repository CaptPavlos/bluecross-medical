import { Helmet } from 'react-helmet-async';

/** Props for route-level search and social metadata. */
interface SEOHeadProps {
  title?: string;
  description?: string;
  keywords?: string[];
  image?: string;
  imageAlt?: string;
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
const DEFAULT_DESCRIPTION = 'Flag-state guidance, maritime medical training, practical knowledge, and onboard medical equipment for ships and yachts.';
const DEFAULT_IMAGE = '/og-image.png';
const DEFAULT_IMAGE_ALT = 'BlueCross Medical — maritime medical clarity from flag to first response';
const SITE_URL = 'https://www.bluecross.tech';
const ORGANIZATION_ID = `${SITE_URL}/#organization`;
const WEBSITE_ID = `${SITE_URL}/#website`;

function canonicalizeUrl(url = '/') {
  const requestedUrl = new URL(url, `${SITE_URL}/`);
  return new URL(`${requestedUrl.pathname}${requestedUrl.search}`, `${SITE_URL}/`).toString();
}

/**
 * Owns metadata for the currently rendered route. Static HTML intentionally
 * contains no canonical, social tags, or JSON-LD so there is one live source.
 */
export default function SEOHead({
  title,
  description = DEFAULT_DESCRIPTION,
  keywords = [],
  image = DEFAULT_IMAGE,
  imageAlt = DEFAULT_IMAGE_ALT,
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
  const canonicalUrl = canonicalizeUrl(url);
  const fullImageUrl = new URL(image, `${SITE_URL}/`).toString();
  const webPageId = `${canonicalUrl}#webpage`;

  const baseSchema = {
    '@context': 'https://schema.org',
    '@graph': [
      {
        '@type': 'Organization',
        '@id': ORGANIZATION_ID,
        name: SITE_NAME,
        url: `${SITE_URL}/`,
        logo: {
          '@type': 'ImageObject',
          url: `${SITE_URL}/favicon.svg`,
        },
        description: DEFAULT_DESCRIPTION,
        contactPoint: {
          '@type': 'ContactPoint',
          email: 'bluecross@marsoft.ai',
          contactType: 'customer support',
        },
      },
      {
        '@type': 'WebSite',
        '@id': WEBSITE_ID,
        url: `${SITE_URL}/`,
        name: SITE_NAME,
        description: DEFAULT_DESCRIPTION,
        publisher: { '@id': ORGANIZATION_ID },
        inLanguage: 'en',
      },
      {
        '@type': type === 'product' ? 'ItemPage' : 'WebPage',
        '@id': webPageId,
        url: canonicalUrl,
        name: fullTitle,
        description,
        isPartOf: { '@id': WEBSITE_ID },
        about: { '@id': ORGANIZATION_ID },
        publisher: { '@id': ORGANIZATION_ID },
        primaryImageOfPage: {
          '@type': 'ImageObject',
          url: fullImageUrl,
          caption: imageAlt,
        },
        inLanguage: 'en',
      },
    ],
  };

  const articleSchema = type === 'article' ? {
    '@context': 'https://schema.org',
    '@type': 'Article',
    '@id': `${canonicalUrl}#article`,
    headline: title,
    description,
    image: fullImageUrl,
    author: author && author !== SITE_NAME
      ? { '@type': 'Person', name: author }
      : { '@id': ORGANIZATION_ID },
    publisher: { '@id': ORGANIZATION_ID },
    datePublished: publishedTime,
    dateModified: modifiedTime || publishedTime,
    mainEntityOfPage: { '@id': webPageId },
    articleSection: section,
  } : null;

  const breadcrumbSchema = url && url !== '/' ? {
    '@context': 'https://schema.org',
    '@type': 'BreadcrumbList',
    '@id': `${canonicalUrl}#breadcrumb`,
    itemListElement: [
      {
        '@type': 'ListItem',
        position: 1,
        name: 'Home',
        item: `${SITE_URL}/`,
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
    'flag state regulations',
    'maritime medical training',
    'ship medical equipment',
  ];
  const allKeywords = [...new Set([...keywords, ...defaultKeywords].filter(Boolean))];

  return (
    <Helmet>
      <title>{fullTitle}</title>
      <meta name="description" content={description} />
      <meta name="keywords" content={allKeywords.join(', ')} />
      <meta
        name="robots"
        content={noindex
          ? 'noindex, nofollow'
          : 'index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1'}
      />
      <link rel="canonical" href={canonicalUrl} />

      <html lang="en" />
      <meta httpEquiv="content-language" content="en" />

      <meta property="og:type" content={type} />
      <meta property="og:url" content={canonicalUrl} />
      <meta property="og:title" content={fullTitle} />
      <meta property="og:description" content={description} />
      <meta property="og:image" content={fullImageUrl} />
      <meta property="og:image:alt" content={imageAlt} />
      <meta property="og:image:width" content="1200" />
      <meta property="og:image:height" content="630" />
      <meta property="og:site_name" content={SITE_NAME} />
      <meta property="og:locale" content="en_US" />

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

      <meta name="twitter:card" content="summary_large_image" />
      <meta name="twitter:url" content={canonicalUrl} />
      <meta name="twitter:title" content={fullTitle} />
      <meta name="twitter:description" content={description} />
      <meta name="twitter:image" content={fullImageUrl} />
      <meta name="twitter:image:alt" content={imageAlt} />

      <meta name="author" content={author || SITE_NAME} />
      <meta name="publisher" content={SITE_NAME} />
      <meta name="copyright" content={SITE_NAME} />

      <script type="application/ld+json">{JSON.stringify(baseSchema)}</script>
      {articleSchema && (
        <script type="application/ld+json">{JSON.stringify(articleSchema)}</script>
      )}
      {breadcrumbSchema && (
        <script type="application/ld+json">{JSON.stringify(breadcrumbSchema)}</script>
      )}
      {jsonLd && (
        <script type="application/ld+json">{JSON.stringify(jsonLd)}</script>
      )}
    </Helmet>
  );
}
