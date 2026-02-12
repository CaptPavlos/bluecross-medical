import { type ClassValue, clsx } from 'clsx';

/**
 * Merges class names using clsx for conditional class handling.
 * Lightweight alternative to clsx + tailwind-merge.
 * @param inputs - Class values to merge (strings, objects, arrays)
 * @returns Merged class name string
 */
export function cn(...inputs: ClassValue[]): string {
  return clsx(inputs);
}

/**
 * Formats a date string for display in a human-readable format.
 * @param dateString - ISO date string to format
 * @returns Formatted date string (e.g., "January 15, 2026")
 */
export function formatDate(dateString: string): string {
  const date = new Date(dateString);
  return date.toLocaleDateString('en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  });
}

/**
 * Formats a date string as relative time (e.g., "5m ago", "2h ago").
 * Falls back to absolute date for older dates.
 * @param dateString - ISO date string to format
 * @returns Relative time string or formatted date for older dates
 */
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

/**
 * Calculates estimated reading time for a piece of content.
 * Assumes average reading speed of 200 words per minute.
 * @param content - Text content to analyze
 * @returns Estimated reading time in minutes (rounded up)
 */
export function calculateReadingTime(content: string): number {
  const wordsPerMinute = 200;
  const wordCount = content.split(/\s+/).length;
  return Math.ceil(wordCount / wordsPerMinute);
}

/**
 * Truncates text to a maximum length and adds ellipsis if truncated.
 * @param text - Text to truncate
 * @param maxLength - Maximum character length before truncation
 * @returns Original text or truncated text with "..." appended
 */
export function truncateText(text: string, maxLength: number): string {
  if (text.length <= maxLength) return text;
  return text.slice(0, maxLength).trim() + '...';
}

/**
 * Validates whether a string is a properly formatted email address.
 * @param email - Email address to validate
 * @returns True if email format is valid, false otherwise
 */
export function isValidEmail(email: string): boolean {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

/**
 * Generates a URL-friendly slug from text.
 * Converts to lowercase, removes special characters, replaces spaces with hyphens.
 * @param text - Text to convert to slug
 * @returns URL-safe slug string
 */
export function slugify(text: string): string {
  return text
    .toLowerCase()
    .replace(/[^\w\s-]/g, '')
    .replace(/\s+/g, '-')
    .replace(/--+/g, '-')
    .trim();
}

/**
 * Creates a debounced version of a function that delays execution.
 * Useful for rate-limiting expensive operations like API calls or search.
 * @param func - Function to debounce
 * @param wait - Milliseconds to wait before executing
 * @returns Debounced function that resets timer on each call
 */
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

/**
 * Returns the appropriate Tailwind CSS color class for a system status.
 * @param status - System operational status
 * @returns Tailwind CSS background color class
 */
export function getStatusColor(status: 'operational' | 'degraded' | 'maintenance'): string {
  const colors = {
    operational: 'bg-brand-green',
    degraded: 'bg-brand-yellow',
    maintenance: 'bg-brand-red',
  };
  return colors[status];
}

/**
 * Returns Tailwind CSS classes for styling a product status badge.
 * @param status - Product lifecycle status
 * @returns Combined Tailwind CSS classes for badge styling
 */
export function getProductStatusClasses(status: 'active' | 'beta' | 'deprecated'): string {
  const classes = {
    active: 'bg-brand-green/10 text-brand-green border-brand-green/20',
    beta: 'bg-brand-yellow/10 text-brand-yellow border-brand-yellow/20',
    deprecated: 'bg-brand-gray/10 text-brand-gray border-brand-gray/20',
  };
  return classes[status];
}

/**
 * Extracts a human-readable error message from an unknown error type.
 * Safely handles Error objects and unknown error types.
 * @param error - Error of any type to process
 * @returns Human-readable error message string
 */
export function handleError(error: unknown): string {
  if (error instanceof Error) {
    return error.message;
  }
  return 'An unexpected error occurred';
}

/**
 * Safely parses a JSON string with a fallback value on failure.
 * @param json - JSON string to parse
 * @param fallback - Default value to return if parsing fails
 * @returns Parsed JSON object or fallback value
 */
export function safeJsonParse<T>(json: string, fallback: T): T {
  try {
    return JSON.parse(json) as T;
  } catch {
    return fallback;
  }
}
