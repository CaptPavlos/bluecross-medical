import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

/**
 * Props for the Badge component.
 */
interface BadgeProps extends React.HTMLAttributes<HTMLSpanElement> {
  variant?: 'default' | 'success' | 'warning' | 'danger' | 'info';
  size?: 'sm' | 'md';
}

/**
 * Small label component for status indicators, tags, or categories.
 * Displays as a rounded pill with color variants for different states.
 * @param variant - Color scheme: default, success, warning, danger, or info
 * @param size - Badge size: sm or md
 */
const Badge = forwardRef<HTMLSpanElement, BadgeProps>(
  ({ className, variant = 'default', size = 'sm', children, ...props }, ref) => {
    const baseStyles =
      'inline-flex items-center font-medium rounded-full border';

    const variants = {
      default: 'bg-gray-100 text-brand-slate border-gray-200',
      success: 'border-green-200 bg-green-100 text-green-800',
      warning: 'border-amber-200 bg-amber-100 text-amber-900',
      danger: 'border-red-200 bg-red-100 text-red-800',
      info: 'border-sky-200 bg-sky-100 text-sky-900',
    };

    const sizes = {
      sm: 'px-2 py-0.5 text-xs',
      md: 'px-3 py-1 text-small',
    };

    return (
      <span
        ref={ref}
        className={cn(baseStyles, variants[variant], sizes[size], className)}
        {...props}
      >
        {children}
      </span>
    );
  }
);

Badge.displayName = 'Badge';

export default Badge;
