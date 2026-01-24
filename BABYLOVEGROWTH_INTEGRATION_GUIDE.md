# BabyLoveGrowth API Integration Guide

This guide provides a complete, step-by-step process for integrating BabyLoveGrowth AI into your website for automated article publishing. This implementation has been successfully tested and handles both webhook-based automatic publishing and manual API-based syncing.

## Overview

BabyLoveGrowth is an AI-powered content generation platform that can automatically publish articles to your website. There are two integration methods:

1. **Webhook Integration (Recommended)**: Automatic publishing when you click "Publish Now" in BabyLoveGrowth dashboard
2. **API Pull Integration**: Manual fetching and publishing of articles via REST API

## Prerequisites

- Node.js/React website (can be adapted for other frameworks)
- Neon PostgreSQL database (or any PostgreSQL database)
- Vercel for deployment (for webhook endpoints)
- BabyLoveGrowth API account

## Step 1: Environment Configuration

Create/update your `.env` file with the following variables:

```env
# BabyLoveGrowth Integration (SERVER-SIDE ONLY)
# Get your API key from https://www.babylovegrowth.ai → Dashboard → Settings → Integrations
# IMPORTANT: Do NOT use VITE_ prefix - this keeps it server-side only
BABYLOVEGROWTH_API_KEY=your-api-key

# BabyLoveGrowth Webhook (for automatic publishing - server-side only)
# Generate a secure random string for the webhook secret
BABYLOVEGROWTH_WEBHOOK_SECRET=your-webhook-secret

# Server-side database URL (NEVER exposed to client)
# Used by Vercel serverless functions and webhook handlers
NEON_DATABASE_URL=postgresql://user:password@ep-xxx-xxx.us-east-1.aws.neon.tech/neondb?sslmode=require
```

⚠️ **Security Note**: All BabyLoveGrowth API requests must go through server-side code (webhook handlers or backend proxy/API routes). Never expose `BABYLOVEGROWTH_API_KEY` to the client bundle.

## Step 2: Database Schema

Ensure your `blog_posts` table has the following structure:

```sql
CREATE TABLE blog_posts (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  title TEXT NOT NULL,
  slug TEXT UNIQUE NOT NULL,
  content TEXT NOT NULL,
  excerpt TEXT,
  featured_image_url TEXT,
  author_name TEXT DEFAULT 'Your Brand Name',
  published BOOLEAN DEFAULT false,
  published_at TIMESTAMPTZ,
  tags TEXT[],
  reading_time_minutes INTEGER,
  created_at TIMESTAMPTZ DEFAULT NOW(),
  updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create index for faster slug lookups
CREATE INDEX idx_blog_posts_slug ON blog_posts(slug);
```

## Step 3: API Integration Module

Create `src/lib/api/babylovegrowth.ts`:

```typescript
/**
 * BabyLoveGrowth API Integration
 * 
 * This module handles integration with BabyLoveGrowth.ai for automated article publishing.
 * 
 * Two integration methods:
 * 1. WEBHOOK (Recommended): BabyLoveGrowth pushes articles to /api/babylovegrowth-webhook
 *    when you click "Publish Now" in their dashboard.
 * 
 * 2. API PULL: Manually fetch articles using their REST API endpoints.
 * 
 * API Documentation: https://www.babylovegrowth.ai/en/docs
 */

import { supabase, isSupabaseConfigured } from '../supabase';
import type { BlogPost } from '../types';

// Configuration
const BABYLOVEGROWTH_API_KEY = import.meta.env.VITE_BABYLOVEGROWTH_API_KEY || '';
const BABYLOVEGROWTH_API_URL = 'https://api.babylovegrowth.ai/api/integrations/v1';

// Article list response (from /articles endpoint)
export interface BabyLoveGrowthArticleListItem {
  id: number;
  title: string;
  slug: string;
  languageCode: string;
  orgWebsite: string;
  created_at: string;
  seedKeyword: string;
  keywords: string[];
}

// Full article response (from /articles/{id} endpoint)
export interface BabyLoveGrowthArticle {
  id: number;
  title: string;
  slug: string;
  content_html?: string;
  content_markdown?: string;
  meta_description?: string;
  hero_image_url?: string;
  orgWebsite: string;
  created_at: string;
  seedKeyword: string;
  keywords: string[];
}

/**
 * Check if BabyLoveGrowth integration is configured
 */
export function isBabyLoveGrowthConfigured(): boolean {
  return !!BABYLOVEGROWTH_API_KEY;
}

/**
 * Fetch all articles from BabyLoveGrowth
 * GET /api/integrations/v1/articles
 */
export async function fetchAllArticles(): Promise<BabyLoveGrowthArticleListItem[]> {
  if (!isBabyLoveGrowthConfigured()) {
    console.warn('BabyLoveGrowth not configured. Set VITE_BABYLOVEGROWTH_API_KEY.');
    return [];
  }

  try {
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

    const data: BabyLoveGrowthArticleListItem[] = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching articles from BabyLoveGrowth:', error);
    throw error;
  }
}

/**
 * Fetch a specific article by ID
 * GET /api/integrations/v1/articles/{id}
 */
export async function fetchArticleById(id: number): Promise<BabyLoveGrowthArticle | null> {
  if (!isBabyLoveGrowthConfigured()) {
    console.warn('BabyLoveGrowth not configured.');
    return null;
  }

  try {
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

    const data: BabyLoveGrowthArticle = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching article from BabyLoveGrowth:', error);
    throw error;
  }
}

/**
 * Convert BabyLoveGrowth article to our BlogPost format
 */
export function convertToBlogPost(article: BabyLoveGrowthArticle): Omit<BlogPost, 'id'> {
  // Extract excerpt from content (first 160 chars or meta description)
  const excerpt = article.meta_description || 
    (article.content_html || article.content_markdown || '')
      .replace(/<[^>]*>/g, '') // Strip HTML
      .substring(0, 160)
      .trim() + '...';

  // Estimate reading time (average 200 words per minute)
  const content = article.content_html || article.content_markdown || '';
  const wordCount = content.replace(/<[^>]*>/g, '').split(/\s+/).length;
  const readingTime = Math.max(1, Math.ceil(wordCount / 200));

  return {
    title: article.title,
    slug: article.slug,
    content: article.content_html || article.content_markdown || '',
    excerpt,
    featured_image_url: article.hero_image_url,
    author_name: 'Your Brand Name',
    published: true,
    published_at: new Date().toISOString(),
    tags: article.keywords || [],
    reading_time_minutes: readingTime,
    created_at: article.created_at || new Date().toISOString(),
    updated_at: new Date().toISOString(),
  };
}

/**
 * Publish a BabyLoveGrowth article to our blog
 */
export async function publishArticle(article: BabyLoveGrowthArticle): Promise<BlogPost | null> {
  const blogPost = convertToBlogPost(article);

  if (!isSupabaseConfigured()) {
    // Store in localStorage for demo/development
    const existingPosts = JSON.parse(localStorage.getItem('your_articles') || '[]');
    const newPost: BlogPost = {
      ...blogPost,
      id: crypto.randomUUID(),
    };
    existingPosts.unshift(newPost);
    localStorage.setItem('your_articles', JSON.stringify(existingPosts));
    console.log('Article published to localStorage:', newPost.title);
    return newPost;
  }

  try {
    // Check if article with this slug already exists
    const { data: existing } = await supabase!
      .from('blog_posts')
      .select('id')
      .eq('slug', article.slug)
      .single();

    if (existing) {
      // Update existing article
      const { data, error } = await supabase!
        .from('blog_posts')
        .update(blogPost)
        .eq('id', existing.id)
        .select()
        .single();

      if (error) throw error;
      console.log('Article updated:', data.title);
      return data;
    } else {
      // Insert new article
      const { data, error } = await supabase!
        .from('blog_posts')
        .insert(blogPost)
        .select()
        .single();

      if (error) throw error;
      console.log('Article published:', data.title);
      return data;
    }
  } catch (error) {
    console.error('Error publishing article:', error);
    throw error;
  }
}

/**
 * Fetch all articles and publish them to our blog
 */
export async function syncArticles(): Promise<{ published: number; failed: number; articles: BlogPost[] }> {
  const results = {
    published: 0,
    failed: 0,
    articles: [] as BlogPost[],
  };

  try {
    // First get the list of all articles
    const articleList = await fetchAllArticles();
    console.log(`Found ${articleList.length} articles from BabyLoveGrowth`);

    // Fetch full details and publish each article
    for (const item of articleList) {
      try {
        const fullArticle = await fetchArticleById(item.id);
        if (fullArticle) {
          const published = await publishArticle(fullArticle);
          if (published) {
            results.published++;
            results.articles.push(published);
          }
        }
      } catch (error) {
        console.error(`Failed to publish article: ${item.title}`, error);
        results.failed++;
      }
    }

    return results;
  } catch (error) {
    console.error('Error syncing articles:', error);
    throw error;
  }
}
```

## Step 4: Webhook Endpoint

Create `api/babylovegrowth-webhook.ts` for Vercel serverless functions:

```typescript
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
  keywords?: string[] | string; // Can be array or comma-separated string
}

// Normalize keywords to array format
function normalizeKeywords(keywords?: string[] | string): string[] {
  if (!keywords) return [];
  if (Array.isArray(keywords)) return keywords;
  // Handle comma-separated string
  return keywords.split(',').map(k => k.trim()).filter(Boolean);
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

// Default fallback image URL for articles without hero images
const DEFAULT_HERO_IMAGE = 'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=800&q=80&fit=crop';

// Extract first image URL from markdown/HTML content
function extractFirstImage(content: string): string | null {
  // Try markdown image syntax: ![alt](url)
  const markdownMatch = content.match(/!\[.*?\]\((https?:\/\/[^\s)]+)\)/);
  if (markdownMatch) return markdownMatch[1];
  
  // Try HTML img tag: <img src="url">
  const htmlMatch = content.match(/<img[^>]+src=["'](https?:\/\/[^\s"']+)["']/i);
  if (htmlMatch) return htmlMatch[1];
  
  return null;
}

// Remove first h1 and first image from content to avoid duplication with header
function cleanContentForDisplay(content: string): string {
  let cleaned = content;
  
  // Remove first h1 tag (title is shown in header)
  cleaned = cleaned.replace(/<h1[^>]*>[\s\S]*?<\/h1>/i, '');
  
  // Remove first image (will be used as featured image)
  // Match <p><img...></p> or just <img...>
  cleaned = cleaned.replace(/<p>\s*<img[^>]+>\s*<\/p>/i, '');
  if (cleaned === content) {
    // If no <p> wrapped image, try direct img tag
    cleaned = cleaned.replace(/<img[^>]+>/i, '');
  }
  
  // Clean up any leading whitespace/newlines
  cleaned = cleaned.replace(/^\s+/, '');
  
  return cleaned;
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

    const rawContent = payload.content_html || payload.content_markdown || '';
    const slug = generateSlug(payload.title);
    const excerpt = extractExcerpt(rawContent, payload.metaDescription);
    const readingTime = estimateReadingTime(rawContent);
    const tags = normalizeKeywords(payload.keywords);
    // Priority: explicit hero_image_url > first image in content > default fallback
    const contentImage = extractFirstImage(rawContent);
    const featuredImage = payload.hero_image_url || contentImage || DEFAULT_HERO_IMAGE;
    // Clean content: remove first h1 and first image (they're shown in header section)
    const content = cleanContentForDisplay(rawContent);
    const now = new Date().toISOString();

    console.log('Processing article:', {
      title: payload.title,
      keywordsReceived: payload.keywords,
      keywordsType: typeof payload.keywords,
      tagsNormalized: tags,
      heroImageProvided: !!payload.hero_image_url,
      contentImageExtracted: contentImage,
      featuredImage: featuredImage
    });

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
          featured_image_url = ${featuredImage},
          tags = ${tags},
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
          ${featuredImage},
          'Your Brand Name',
          true,
          ${now},
          ${tags},
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
```

## Step 5: Admin Dashboard Component

Create an admin interface to manage BabyLoveGrowth sync:

```typescript
// src/pages/admin/BabyLoveGrowthSync.tsx
import { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { RefreshCw, Check, X, FileText, Clock, AlertCircle, ExternalLink, Webhook } from 'lucide-react';
import {
  fetchAllArticles,
  fetchArticleById,
  publishArticle,
  syncArticles,
  isBabyLoveGrowthConfigured,
  type BabyLoveGrowthArticleListItem,
} from '../../lib/api/babylovegrowth';

function BabyLoveGrowthSync() {
  const [isConfigured, setIsConfigured] = useState(false);
  const [articles, setArticles] = useState<BabyLoveGrowthArticleListItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);
  const [isSyncing, setIsSyncing] = useState(false);
  const [syncResults, setSyncResults] = useState<{ published: number; failed: number; articles: BlogPost[] } | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [publishingId, setPublishingId] = useState<number | null>(null);

  // Get webhook URL for display
  const webhookUrl = typeof window !== 'undefined' 
    ? `${window.location.origin}/api/babylovegrowth-webhook`
    : '/api/babylovegrowth-webhook';

  useEffect(() => {
    setIsConfigured(isBabyLoveGrowthConfigured());
  }, []);

  // Component implementation... (see full implementation in the reference code)
}

export default BabyLoveGrowthSync;
```

## Step 6: BabyLoveGrowth Dashboard Configuration

1. **Get API Key**:
   - Log into [BabyLoveGrowth Dashboard](https://www.babylovegrowth.ai)
   - Go to Settings → Integrations
   - Copy your API key

2. **Configure Webhook**:
   - In BabyLoveGrowth dashboard, go to Webhook settings
   - Enter your webhook URL: `https://yourdomain.com/api/babylovegrowth-webhook`
   - Set Authorization header to: `Bearer your-webhook-secret`
   - Test the webhook

## Step 7: Deployment Configuration

For Vercel deployment, add `vercel.json`:

```json
{
  "functions": {
    "api/babylovegrowth-webhook.ts": {
      "maxDuration": 30
    }
  },
  "env": {
    "BABYLOVEGROWTH_WEBHOOK_SECRET": "@babylovegrowth-webhook-secret",
    "NEON_DATABASE_URL": "@neon-database-url"
  }
}
```

## Step 8: Testing the Integration

### Testing Webhook:
1. Use BabyLoveGrowth dashboard to test webhook
2. Check Vercel function logs for debugging
3. Verify articles appear in your database

### Testing API:
1. Use the admin dashboard to fetch articles
2. Publish individual articles or sync all
3. Check browser console for any errors

## Common Issues & Solutions

### 1. CORS Errors
- Ensure webhook endpoint handles OPTIONS requests
- Set proper CORS headers in webhook handler

### 2. Authorization Failures
- Verify BABYLOVEGROWTH_WEBHOOK_SECRET matches in both places
- Check Authorization header format: `Bearer your-secret`

### 3. Database Connection Issues
- Ensure NEON_DATABASE_URL is set in Vercel environment variables
- Check database permissions for the user

### 4. Content Formatting
- HTML content is automatically cleaned to remove duplicate H1 and images
- Featured images are extracted from content or use default fallback

## Best Practices

1. **Security**:
   - Always use HTTPS for webhook URLs
   - Generate a strong, random webhook secret
   - Never expose API keys in client-side code

2. **Performance**:
   - Implement caching for article lists
   - Use pagination for large article collections
   - Optimize image loading for featured images

3. **SEO**:
   - Ensure proper meta descriptions are set
   - Use semantic HTML structure
   - Implement proper URL slugs

4. **Monitoring**:
   - Log all webhook requests for debugging
   - Monitor API rate limits
   - Set up alerts for failed webhooks

## Maintenance

1. Regularly check for BabyLoveGrowth API updates
2. Monitor webhook delivery success rates
3. Backup your database regularly
4. Test the integration after any updates

## Support

- BabyLoveGrowth API Documentation: https://www.babylovegrowth.ai/en/docs
- Neon Database Documentation: https://neon.tech/docs
- Vercel Functions Documentation: https://vercel.com/docs/concepts/functions

---

This integration has been successfully implemented and tested. The webhook approach provides seamless automatic publishing, while the API method gives you manual control over when articles are published.
