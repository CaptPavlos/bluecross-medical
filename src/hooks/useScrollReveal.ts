import { useEffect, useRef, useState } from 'react';

/**
 * Options for configuring the scroll reveal behavior.
 */
interface UseScrollRevealOptions {
  threshold?: number;
  rootMargin?: string;
  triggerOnce?: boolean;
}

/**
 * Hook that tracks when an element becomes visible in the viewport.
 * Uses IntersectionObserver for performant scroll-based animations.
 * @param options - Configuration options for intersection detection
 * @param options.threshold - Percentage of element visibility to trigger (0-1)
 * @param options.rootMargin - Margin around the viewport for early/late triggering
 * @param options.triggerOnce - If true, only triggers once and stops observing
 * @returns Object containing ref to attach to element and isVisible state
 */
export function useScrollReveal<T extends HTMLElement>(
  options: UseScrollRevealOptions = {}
): {
  ref: React.RefObject<T>;
  isVisible: boolean;
} {
  const { threshold = 0.1, rootMargin = '0px', triggerOnce = true } = options;
  const ref = useRef<T>(null);
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const element = ref.current;
    if (!element) return;

    const observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting) {
          setIsVisible(true);
          if (triggerOnce) {
            observer.unobserve(element);
          }
        } else if (!triggerOnce) {
          setIsVisible(false);
        }
      },
      { threshold, rootMargin }
    );

    observer.observe(element);

    return () => {
      observer.unobserve(element);
    };
  }, [threshold, rootMargin, triggerOnce]);

  return { ref: ref as React.RefObject<T>, isVisible };
}

/**
 * Hook that tracks the current vertical scroll position of the window.
 * Updates on scroll events with passive listener for performance.
 * @returns Current scrollY value in pixels
 */
export function useScrollPosition(): number {
  const [scrollY, setScrollY] = useState(0);

  useEffect(() => {
    const handleScroll = () => {
      setScrollY(window.scrollY);
    };

    window.addEventListener('scroll', handleScroll, { passive: true });
    return () => window.removeEventListener('scroll', handleScroll);
  }, []);

  return scrollY;
}

/**
 * Hook that returns true when page is scrolled past a threshold.
 * Useful for showing/hiding sticky headers or scroll-to-top buttons.
 * @param threshold - Scroll distance in pixels to trigger (default: 50)
 * @returns True if scrolled past threshold, false otherwise
 */
export function useIsScrolled(threshold: number = 50): boolean {
  const scrollY = useScrollPosition();
  return scrollY > threshold;
}
