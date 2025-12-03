import type { VercelRequest, VercelResponse } from '@vercel/node';
import { neon } from '@neondatabase/serverless';

/**
 * BabyLoveGrowth Webhook Handler
 * 
 * Receives POST requests from BabyLoveGrowth when you click "Publish Now"
 * and automatically creates blog posts in your Neon database.
 * 
 * Webhook Payload Format:
 * {
 *   "id": 10,
 *   "title": "Article Title",
 *   "metaDescription": "Description...",
 *   "content_html": "<h1>...</h1>",
 *   "content_markdown": "# ...",
 *   "languageCode": "en",
 *   "publicUrl": "https://example.com/article-slug",
 *   "createdAt": "2025-03-20T03:41:18.570Z"
 * }
 */

interface BabyLoveGrowthPayload {
  id: number;
  title: string;
  metaDescription?: string;
  content_html?: string;
  content_markdown?: string;
  languageCode?: string;
  publicUrl?: string;
  createdAt?: string;
  hero_image_url?: string;
  keywords?: string[];
}

// Generate slug from title
function generateSlug(title: string): string {
  return title
    .toLowerCase()
    .replace(/[^a-z0-9\s-]/g, '')
    .replace(/\s+/g, '-')
    .replace(/-+/g, '-')
    .trim();
}

// Estimate reading time (200 words per minute)
function estimateReadingTime(content: string): number {
  const text = content.replace(/<[^>]*>/g, ''); // Strip HTML
  const wordCount = text.split(/\s+/).filter(Boolean).length;
  return Math.max(1, Math.ceil(wordCount / 200));
}

// Extract excerpt from content
function extractExcerpt(content: string, metaDescription?: string): string {
  if (metaDescription) return metaDescription;
  
  const text = content.replace(/<[^>]*>/g, ''); // Strip HTML
  return text.substring(0, 160).trim() + (text.length > 160 ? '...' : '');
}

export default async function handler(req: VercelRequest, res: VercelResponse) {
  // Set CORS headers
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Methods', 'POST, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type, Authorization');

  // Handle preflight request
  if (req.method === 'OPTIONS') {
    return res.status(200).end();
  }

  // Only allow POST requests
  if (req.method !== 'POST') {
    return res.status(405).json({ error: 'Method not allowed' });
  }

  // Verify webhook secret
  const authHeader = req.headers.authorization;
  const webhookSecret = process.env.BABYLOVEGROWTH_WEBHOOK_SECRET;

  console.log('Webhook received:', {
    hasAuthHeader: !!authHeader,
    hasWebhookSecret: !!webhookSecret,
    method: req.method,
    body: req.body ? 'present' : 'missing'
  });

  if (!webhookSecret) {
    console.error('BABYLOVEGROWTH_WEBHOOK_SECRET not configured');
    return res.status(500).json({ error: 'Webhook not configured - missing BABYLOVEGROWTH_WEBHOOK_SECRET env var' });
  }

  if (!authHeader || authHeader !== `Bearer ${webhookSecret}`) {
    console.error('Invalid authorization header:', authHeader?.substring(0, 20) + '...');
    return res.status(401).json({ error: 'Unauthorized - invalid Bearer token' });
  }

  // Validate database connection
  const databaseUrl = process.env.NEON_DATABASE_URL || process.env.VITE_NEON_DATABASE_URL;
  if (!databaseUrl) {
    console.error('Database URL not configured');
    return res.status(500).json({ error: 'Database not configured' });
  }

  try {
    const payload: BabyLoveGrowthPayload = req.body;

    // Validate required fields
    if (!payload.title) {
      return res.status(400).json({ error: 'Missing required field: title' });
    }

    const content = payload.content_html || payload.content_markdown || '';
    const slug = generateSlug(payload.title);
    const excerpt = extractExcerpt(content, payload.metaDescription);
    const readingTime = estimateReadingTime(content);
    const now = new Date().toISOString();

    // Connect to Neon database
    const sql = neon(databaseUrl);

    // Check if article with this slug already exists
    const existing = await sql`
      SELECT id FROM blog_posts WHERE slug = ${slug}
    `;

    if (existing.length > 0) {
      // Update existing article
      await sql`
        UPDATE blog_posts SET
          title = ${payload.title},
          content = ${content},
          excerpt = ${excerpt},
          featured_image_url = ${payload.hero_image_url || null},
          reading_time_minutes = ${readingTime},
          updated_at = ${now},
          published = true,
          published_at = ${now}
        WHERE slug = ${slug}
      `;

      console.log(`Updated article: ${payload.title}`);
      return res.status(200).json({ 
        status: 'received',
        action: 'updated',
        slug,
        title: payload.title
      });
    } else {
      // Insert new article
      await sql`
        INSERT INTO blog_posts (
          title, slug, content, excerpt, featured_image_url,
          author_name, published, published_at, tags,
          reading_time_minutes, created_at, updated_at
        ) VALUES (
          ${payload.title},
          ${slug},
          ${content},
          ${excerpt},
          ${payload.hero_image_url || null},
          'BlueCross Medical',
          true,
          ${now},
          ${payload.keywords || []},
          ${readingTime},
          ${now},
          ${now}
        )
      `;

      console.log(`Created article: ${payload.title}`);
      return res.status(200).json({ 
        status: 'received',
        action: 'created',
        slug,
        title: payload.title
      });
    }
  } catch (error) {
    console.error('Webhook processing error:', error);
    return res.status(500).json({ 
      error: 'Failed to process webhook',
      details: error instanceof Error ? error.message : 'Unknown error'
    });
  }
}
