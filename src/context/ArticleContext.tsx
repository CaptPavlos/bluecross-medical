/* eslint-disable react-refresh/only-export-components */
import { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { MOCK_BLOG_POSTS } from '../lib/constants';
import { BlogPost } from '../lib/types';

interface ArticleContextType {
  articles: BlogPost[];
  loading: boolean;
  error: string | null;
  updateArticle: (id: string, updates: Partial<BlogPost>) => void;
  getArticle: (slug: string) => BlogPost | undefined;
  refetch: () => Promise<void>;
}

const ArticleContext = createContext<ArticleContextType | undefined>(undefined);

// API endpoint for fetching blog posts
const API_URL = '/api/blog-posts';

export function ArticleProvider({ children }: { children: ReactNode }) {
  const [articles, setArticles] = useState<BlogPost[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  // Fetch articles from database API
  const fetchArticles = async () => {
    setLoading(true);
    setError(null);
    
    try {
      const response = await fetch(API_URL);
      
      if (!response.ok) {
        throw new Error(`Failed to fetch articles: ${response.status}`);
      }
      
      const data = await response.json();
      setArticles(data);
    } catch (err) {
      console.error('Error fetching articles from API:', err);
      // Fallback to mock data if API fails
      console.log('Falling back to mock data');
      setArticles(MOCK_BLOG_POSTS);
      setError(err instanceof Error ? err.message : 'Failed to load articles');
    } finally {
      setLoading(false);
    }
  };

  // Fetch on mount
  useEffect(() => {
    fetchArticles();
  }, []);

  const updateArticle = (id: string, updates: Partial<BlogPost>) => {
    setArticles(prev => {
      const updated = prev.map(article => 
        article.id === id ? { ...article, ...updates, updated_at: new Date().toISOString() } : article
      );
      return updated;
    });
  };

  const getArticle = (slug: string) => {
    return articles.find(a => a.slug === slug);
  };

  return (
    <ArticleContext.Provider value={{ articles, loading, error, updateArticle, getArticle, refetch: fetchArticles }}>
      {children}
    </ArticleContext.Provider>
  );
}

export function useArticles() {
  const context = useContext(ArticleContext);
  if (context === undefined) {
    throw new Error('useArticles must be used within an ArticleProvider');
  }
  return context;
}
