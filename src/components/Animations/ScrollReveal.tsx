import { useRef, useState, useEffect } from 'react';
import { motion, Variants } from 'framer-motion';

/**
 * Props for the ScrollReveal animation component.
 */
interface ScrollRevealProps {
  children: React.ReactNode;
  direction?: 'up' | 'left' | 'right' | 'scale';
  delay?: number;
  className?: string;
  once?: boolean;
}

/** Fade in from bottom animation variants */
const fadeInUp: Variants = {
  hidden: { opacity: 0, y: 20 },
  visible: { opacity: 1, y: 0, transition: { duration: 0.6, ease: 'easeOut' } },
};

/** Fade in from left animation variants */
const fadeInLeft: Variants = {
  hidden: { opacity: 0, x: -20 },
  visible: { opacity: 1, x: 0, transition: { duration: 0.6, ease: 'easeOut' } },
};

/** Fade in from right animation variants */
const fadeInRight: Variants = {
  hidden: { opacity: 0, x: 20 },
  visible: { opacity: 1, x: 0, transition: { duration: 0.6, ease: 'easeOut' } },
};

/** Scale up with fade animation variants */
const scaleFade: Variants = {
  hidden: { opacity: 0, scale: 0.95 },
  visible: { opacity: 1, scale: 1, transition: { duration: 0.4, ease: 'easeOut' } },
};

/**
 * Wrapper component that animates children when they scroll into view.
 * Uses IntersectionObserver for performant scroll detection.
 * @param direction - Animation direction: up, left, right, or scale
 * @param delay - Animation delay in seconds
 * @param once - If true, animation only plays once
 */
function ScrollReveal({
  children,
  direction = 'up',
  delay = 0,
  className,
  once = true,
}: ScrollRevealProps) {
  const ref = useRef<HTMLDivElement>(null);
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const element = ref.current;
    if (!element) return;

    const observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting) {
          setIsVisible(true);
          if (once) {
            observer.unobserve(element);
          }
        } else if (!once) {
          setIsVisible(false);
        }
      },
      { threshold: 0.1 }
    );

    observer.observe(element);

    return () => {
      observer.unobserve(element);
    };
  }, [once]);

  const variants = {
    up: fadeInUp,
    left: fadeInLeft,
    right: fadeInRight,
    scale: scaleFade,
  };

  return (
    <motion.div
      ref={ref}
      className={className}
      initial="hidden"
      animate={isVisible ? 'visible' : 'hidden'}
      variants={variants[direction]}
      transition={{ delay }}
    >
      {children}
    </motion.div>
  );
}

export default ScrollReveal;
