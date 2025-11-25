import { type ClassValue, clsx } from 'clsx';

// Simple class name merger (lightweight alternative to clsx + tailwind-merge)
export function cn(...inputs: ClassValue[]): string {
  return clsx(inputs);
}

// Format date for display
export function formatDate(dateString: string): string {
  const date = new Date(dateString);
  return date.toLocaleDateString('en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  });
}

// Format relative time
export function formatRelativeTime(dateString: string): string {
  const date = new Date(dateString);
  const now = new Date();
  const diffInSeconds = Math.floor((now.getTime() - date.getTime()) / 1000);

  if (diffInSeconds < 60) return 'Just now';
  if (diffInSeconds < 3600) return `${Math.floor(diffInSeconds / 60)}m ago`;
  if (diffInSeconds < 86400) return `${Math.floor(diffInSeconds / 3600)}h ago`;
  if (diffInSeconds < 604800) return `${Math.floor(diffInSeconds / 86400)}d ago`;
  
  return formatDate(dateString);
}

// Calculate reading time
export function calculateReadingTime(content: string): number {
  const wordsPerMinute = 200;
  const wordCount = content.split(/\s+/).length;
  return Math.ceil(wordCount / wordsPerMinute);
}

// Truncate text with ellipsis
export function truncateText(text: string, maxLength: number): string {
  if (text.length <= maxLength) return text;
  return text.slice(0, maxLength).trim() + '...';
}

// Validate email format
export function isValidEmail(email: string): boolean {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

// Generate slug from text
export function slugify(text: string): string {
  return text
    .toLowerCase()
    .replace(/[^\w\s-]/g, '')
    .replace(/\s+/g, '-')
    .replace(/--+/g, '-')
    .trim();
}

// Debounce function
export function debounce<T extends (...args: string[]) => void>(
  func: T,
  wait: number
): (...args: Parameters<T>) => void {
  let timeout: ReturnType<typeof setTimeout> | null = null;

  return (...args: Parameters<T>) => {
    if (timeout) clearTimeout(timeout);
    timeout = setTimeout(() => func(...args), wait);
  };
}

// Get status indicator color class
export function getStatusColor(status: 'operational' | 'degraded' | 'maintenance'): string {
  const colors = {
    operational: 'bg-brand-green',
    degraded: 'bg-brand-yellow',
    maintenance: 'bg-brand-red',
  };
  return colors[status];
}

// Get product status badge classes
export function getProductStatusClasses(status: 'active' | 'beta' | 'deprecated'): string {
  const classes = {
    active: 'bg-brand-green/10 text-brand-green border-brand-green/20',
    beta: 'bg-brand-yellow/10 text-brand-yellow border-brand-yellow/20',
    deprecated: 'bg-brand-gray/10 text-brand-gray border-brand-gray/20',
  };
  return classes[status];
}

// Simple error handler
export function handleError(error: unknown): string {
  if (error instanceof Error) {
    return error.message;
  }
  return 'An unexpected error occurred';
}

// Safe JSON parse
export function safeJsonParse<T>(json: string, fallback: T): T {
  try {
    return JSON.parse(json) as T;
  } catch {
    return fallback;
  }
}
