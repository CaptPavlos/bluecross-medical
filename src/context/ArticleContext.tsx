/* eslint-disable react-refresh/only-export-components */
import { createContext, useContext, useState, ReactNode } from 'react';
import { MOCK_BLOG_POSTS } from '../lib/constants';
import { BlogPost } from '../lib/types';

interface ArticleContextType {
  articles: BlogPost[];
  updateArticle: (id: string, updates: Partial<BlogPost>) => void;
  getArticle: (slug: string) => BlogPost | undefined;
}

const ArticleContext = createContext<ArticleContextType | undefined>(undefined);

// Helper function to load articles from localStorage
const loadArticlesFromStorage = (): BlogPost[] => {
  try {
    const savedArticles = localStorage.getItem('bluecross_articles');
    if (savedArticles) {
      return JSON.parse(savedArticles);
    }
  } catch {
    // If parsing fails, return default articles
  }
  return MOCK_BLOG_POSTS;
};

export function ArticleProvider({ children }: { children: ReactNode }) {
  // Initialize state from localStorage with lazy initialization
  const [articles, setArticles] = useState<BlogPost[]>(loadArticlesFromStorage);

  const updateArticle = (id: string, updates: Partial<BlogPost>) => {
    setArticles(prev => {
      const updated = prev.map(article => 
        article.id === id ? { ...article, ...updates, updated_at: new Date().toISOString() } : article
      );
      localStorage.setItem('bluecross_articles', JSON.stringify(updated));
      return updated;
    });
  };

  const getArticle = (slug: string) => {
    return articles.find(a => a.slug === slug);
  };

  return (
    <ArticleContext.Provider value={{ articles, updateArticle, getArticle }}>
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
