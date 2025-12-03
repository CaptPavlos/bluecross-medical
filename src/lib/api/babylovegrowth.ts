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
    author_name: 'BlueCross Medical',
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
    const existingPosts = JSON.parse(localStorage.getItem('bluecross_articles') || '[]');
    const newPost: BlogPost = {
      ...blogPost,
      id: crypto.randomUUID(),
    };
    existingPosts.unshift(newPost);
    localStorage.setItem('bluecross_articles', JSON.stringify(existingPosts));
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
