import { supabase, isSupabaseConfigured } from '../supabase';
import { MOCK_PRODUCTS } from '../constants';
import type { Product, ProductStatus } from '../types';

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
