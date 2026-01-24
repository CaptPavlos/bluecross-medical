#!/usr/bin/env node
/**
 * Script to publish scheduled articles from BabyLoveGrowth
 * 
 * Usage: node scripts/publish-articles.mjs
 * 
 * Requires: NEON_DATABASE_URL and VITE_BABYLOVEGROWTH_API_KEY in .env
 */

import { readFileSync } from 'fs';
import { fileURLToPath } from 'url';
import { dirname, join } from 'path';

// Load environment variables from .env file
const __dirname = dirname(fileURLToPath(import.meta.url));
const envPath = join(__dirname, '..', '.env');
const envContent = readFileSync(envPath, 'utf-8');
envContent.split('\n').forEach(line => {
  const [key, ...valueParts] = line.split('=');
  if (key && !key.startsWith('#')) {
    process.env[key.trim()] = valueParts.join('=').trim();
  }
});

// Dynamic import of neon after env is loaded
const { neon } = await import('@neondatabase/serverless');

const BABYLOVEGROWTH_API_KEY = process.env.VITE_BABYLOVEGROWTH_API_KEY;
const BABYLOVEGROWTH_API_URL = 'https://api.babylovegrowth.ai/api/integrations/v1';
const DATABASE_URL = process.env.NEON_DATABASE_URL || process.env.VITE_NEON_DATABASE_URL;

// Article titles to publish (partial match)
const ARTICLES_TO_PUBLISH = [
  'types of emergency medical equipment',
  'crew emergency response tips',
  'why train crews in emergency medicine'
];

// Default hero image if none provided
const DEFAULT_HERO_IMAGE = 'https://images.unsplash.com/photo-1584820927498-cfe5211fd8bf?w=1200&q=80';

function generateSlug(title) {
  return title
    .toLowerCase()
    .replace(/[^a-z0-9\s-]/g, '')
    .replace(/\s+/g, '-')
    .replace(/-+/g, '-')
    .trim();
}

function extractExcerpt(content, metaDescription) {
  if (metaDescription) return metaDescription;
  return content
    .replace(/<[^>]*>/g, '')
    .substring(0, 160)
    .trim() + '...';
}

function estimateReadingTime(content) {
  const wordCount = content.replace(/<[^>]*>/g, '').split(/\s+/).length;
  return Math.max(1, Math.ceil(wordCount / 200));
}

function extractFirstImage(content) {
  const imgMatch = content.match(/<img[^>]+src=["']([^"']+)["']/i);
  return imgMatch ? imgMatch[1] : null;
}

function cleanContentForDisplay(content) {
  // Remove first h1 tag
  let cleaned = content.replace(/<h1[^>]*>.*?<\/h1>/i, '');
  // Remove first image
  cleaned = cleaned.replace(/<img[^>]*>/i, '');
  return cleaned.trim();
}

async function fetchAllArticles() {
  const response = await fetch(`${BABYLOVEGROWTH_API_URL}/articles`, {
    method: 'GET',
    headers: {
      'X-API-Key': BABYLOVEGROWTH_API_KEY,
      'Content-Type': 'application/json',
    },
  });

  if (!response.ok) {
    throw new Error(`BabyLoveGrowth API error: ${response.status} ${response.statusText}`);
  }

  return response.json();
}

async function fetchArticleById(id) {
  const response = await fetch(`${BABYLOVEGROWTH_API_URL}/articles/${id}`, {
    method: 'GET',
    headers: {
      'X-API-Key': BABYLOVEGROWTH_API_KEY,
      'Content-Type': 'application/json',
    },
  });

  if (!response.ok) {
    throw new Error(`BabyLoveGrowth API error: ${response.status} ${response.statusText}`);
  }

  return response.json();
}

async function publishArticle(sql, article) {
  const rawContent = article.content_html || article.content_markdown || '';
  const slug = generateSlug(article.title);
  const excerpt = extractExcerpt(rawContent, article.meta_description);
  const readingTime = estimateReadingTime(rawContent);
  const tags = article.keywords || [];
  const contentImage = extractFirstImage(rawContent);
  const featuredImage = article.hero_image_url || contentImage || DEFAULT_HERO_IMAGE;
  const content = cleanContentForDisplay(rawContent);
  const now = new Date().toISOString();

  // Check if article exists
  const existing = await sql`
    SELECT id FROM blog_posts WHERE slug = ${slug}
  `;

  if (existing.length > 0) {
    // Update existing
    await sql`
      UPDATE blog_posts SET
        title = ${article.title},
        content = ${content},
        excerpt = ${excerpt},
        featured_image_url = ${featuredImage},
        tags = ${tags},
        reading_time_minutes = ${readingTime},
        updated_at = ${now},
        published = true,
        published_at = ${now}
      WHERE slug = ${slug}
    `;
    return { action: 'updated', slug, title: article.title };
  } else {
    // Insert new
    await sql`
      INSERT INTO blog_posts (
        title, slug, content, excerpt, featured_image_url,
        author_name, published, published_at, tags,
        reading_time_minutes, created_at, updated_at
      ) VALUES (
        ${article.title},
        ${slug},
        ${content},
        ${excerpt},
        ${featuredImage},
        'BlueCross Medical',
        true,
        ${now},
        ${tags},
        ${readingTime},
        ${now},
        ${now}
      )
    `;
    return { action: 'created', slug, title: article.title };
  }
}

async function main() {
  console.log('🚀 Publishing scheduled articles...\n');

  if (!BABYLOVEGROWTH_API_KEY) {
    console.error('❌ VITE_BABYLOVEGROWTH_API_KEY not set in .env');
    process.exit(1);
  }

  if (!DATABASE_URL) {
    console.error('❌ NEON_DATABASE_URL not set in .env');
    process.exit(1);
  }

  const sql = neon(DATABASE_URL);

  try {
    // Fetch all articles from BabyLoveGrowth
    console.log('📥 Fetching articles from BabyLoveGrowth...');
    const allArticles = await fetchAllArticles();
    console.log(`   Found ${allArticles.length} total articles\n`);

    // Find matching articles
    const matchingArticles = allArticles.filter(article => 
      ARTICLES_TO_PUBLISH.some(searchTerm => 
        article.title.toLowerCase().includes(searchTerm)
      )
    );

    if (matchingArticles.length === 0) {
      console.log('⚠️  No matching articles found. Available articles:');
      allArticles.forEach(a => console.log(`   - ${a.title}`));
      process.exit(0);
    }

    console.log(`📝 Found ${matchingArticles.length} articles to publish:\n`);
    matchingArticles.forEach(a => console.log(`   - ${a.title}`));
    console.log('');

    // Publish each article
    for (const articleItem of matchingArticles) {
      try {
        console.log(`📄 Processing: ${articleItem.title}`);
        const fullArticle = await fetchArticleById(articleItem.id);
        const result = await publishArticle(sql, fullArticle);
        console.log(`   ✅ ${result.action}: ${result.title}`);
        console.log(`      Slug: ${result.slug}\n`);
      } catch (error) {
        console.error(`   ❌ Failed: ${error.message}\n`);
      }
    }

    console.log('🎉 Done!');
  } catch (error) {
    console.error('❌ Error:', error.message);
    process.exit(1);
  }
}

main();
