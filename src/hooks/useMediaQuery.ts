import { useState, useEffect } from 'react';

/**
 * React hook that tracks whether a CSS media query matches.
 * Updates automatically when the viewport changes.
 * @param query - CSS media query string (e.g., "(max-width: 768px)")
 * @returns True if the media query matches, false otherwise
 */
export function useMediaQuery(query: string): boolean {
  const [matches, setMatches] = useState(false);

  useEffect(() => {
    const media = window.matchMedia(query);
    
    // Set initial value - needed to sync with SSR
    // eslint-disable-next-line react-hooks/set-state-in-effect
    setMatches(media.matches);

    // Create listener for changes
    const listener = (event: MediaQueryListEvent) => {
      setMatches(event.matches);
    };

    // Add listener
    media.addEventListener('change', listener);

    // Cleanup
    return () => media.removeEventListener('change', listener);
  }, [query]);

  return matches;
}

/**
 * Hook that returns true when viewport is mobile-sized (max-width: 767px).
 * @returns True on mobile viewports, false otherwise
 */
export function useIsMobile(): boolean {
  return useMediaQuery('(max-width: 767px)');
}

/**
 * Hook that returns true when viewport is tablet-sized (768px-1023px).
 * @returns True on tablet viewports, false otherwise
 */
export function useIsTablet(): boolean {
  return useMediaQuery('(min-width: 768px) and (max-width: 1023px)');
}

/**
 * Hook that returns true when viewport is desktop-sized (min-width: 1024px).
 * @returns True on desktop viewports, false otherwise
 */
export function useIsDesktop(): boolean {
  return useMediaQuery('(min-width: 1024px)');
}

/**
 * Hook that detects if user prefers dark color scheme.
 * @returns True if user prefers dark mode, false otherwise
 */
export function usePrefersDarkMode(): boolean {
  return useMediaQuery('(prefers-color-scheme: dark)');
}

/**
 * Hook that detects if user prefers reduced motion for accessibility.
 * @returns True if user prefers reduced motion, false otherwise
 */
export function usePrefersReducedMotion(): boolean {
  return useMediaQuery('(prefers-reduced-motion: reduce)');
}
