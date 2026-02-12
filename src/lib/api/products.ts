import { supabase, isSupabaseConfigured } from '../supabase';
import { MOCK_PRODUCTS } from '../constants';
import type { Product, ProductStatus } from '../types';

/**
 * Fetches all products, optionally filtered by status.
 * Falls back to mock data if Supabase is not configured.
 * @param status - Optional product status filter (active, beta, deprecated)
 * @returns Array of products ordered by display index
 */
export async function getProducts(status?: ProductStatus): Promise<Product[]> {
  if (!isSupabaseConfigured()) {
    if (status) {
      return MOCK_PRODUCTS.filter(p => p.status === status);
    }
    return MOCK_PRODUCTS;
  }

  let query = supabase!
    .from('products')
    .select('*')
    .order('order_index', { ascending: true });

  if (status) {
    query = query.eq('status', status);
  }

  const { data, error } = await query;

  if (error) {
    console.error('Error fetching products:', error);
    return MOCK_PRODUCTS;
  }

  return data || MOCK_PRODUCTS;
}

/**
 * Fetches a single product by its URL slug.
 * Falls back to mock data if Supabase is not configured.
 * @param slug - URL-friendly identifier for the product
 * @returns The matching product or null if not found
 */
export async function getProductBySlug(slug: string): Promise<Product | null> {
  if (!isSupabaseConfigured()) {
    return MOCK_PRODUCTS.find(p => p.slug === slug) || null;
  }

  const { data, error } = await supabase!
    .from('products')
    .select('*')
    .eq('slug', slug)
    .single();

  if (error) {
    console.error('Error fetching product:', error);
    return null;
  }

  return data;
}
