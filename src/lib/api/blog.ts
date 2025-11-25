import { supabase, isSupabaseConfigured } from '../supabase';
import { MOCK_BLOG_POSTS } from '../constants';
import type { BlogPost } from '../types';

export async function getBlogPosts(limit?: number): Promise<BlogPost[]> {
  if (!isSupabaseConfigured()) {
    const posts = MOCK_BLOG_POSTS.filter(p => p.published);
    return limit ? posts.slice(0, limit) : posts;
  }

  let query = supabase!
    .from('blog_posts')
    .select('*')
    .eq('published', true)
    .order('published_at', { ascending: false });

  if (limit) {
    query = query.limit(limit);
  }

  const { data, error } = await query;

  if (error) {
    console.error('Error fetching blog posts:', error);
    return MOCK_BLOG_POSTS;
  }

  return data || MOCK_BLOG_POSTS;
}

export async function getBlogPostBySlug(slug: string): Promise<BlogPost | null> {
  if (!isSupabaseConfigured()) {
    return MOCK_BLOG_POSTS.find(p => p.slug === slug) || null;
  }

  const { data, error } = await supabase!
    .from('blog_posts')
    .select('*')
    .eq('slug', slug)
    .eq('published', true)
    .single();

  if (error) {
    console.error('Error fetching blog post:', error);
    return null;
  }

  return data;
}

export async function searchBlogPosts(query: string): Promise<BlogPost[]> {
  if (!isSupabaseConfigured()) {
    const lowerQuery = query.toLowerCase();
    return MOCK_BLOG_POSTS.filter(
      p => p.title.toLowerCase().includes(lowerQuery) ||
           p.excerpt.toLowerCase().includes(lowerQuery) ||
           p.tags.some(tag => tag.toLowerCase().includes(lowerQuery))
    );
  }

  const { data, error } = await supabase!
    .from('blog_posts')
    .select('*')
    .eq('published', true)
    .or(`title.ilike.%${query}%,excerpt.ilike.%${query}%`)
    .order('published_at', { ascending: false });

  if (error) {
    console.error('Error searching blog posts:', error);
    return [];
  }

  return data || [];
}

export async function getBlogPostsByTag(tag: string): Promise<BlogPost[]> {
  if (!isSupabaseConfigured()) {
    return MOCK_BLOG_POSTS.filter(p => p.tags.includes(tag));
  }

  const { data, error } = await supabase!
    .from('blog_posts')
    .select('*')
    .eq('published', true)
    .contains('tags', [tag])
    .order('published_at', { ascending: false });

  if (error) {
    console.error('Error fetching blog posts by tag:', error);
    return [];
  }

  return data || [];
}
