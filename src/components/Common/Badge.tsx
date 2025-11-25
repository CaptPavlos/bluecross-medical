import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

interface BadgeProps extends React.HTMLAttributes<HTMLSpanElement> {
  variant?: 'default' | 'success' | 'warning' | 'danger' | 'info';
  size?: 'sm' | 'md';
}

const Badge = forwardRef<HTMLSpanElement, BadgeProps>(
  ({ className, variant = 'default', size = 'sm', children, ...props }, ref) => {
    const baseStyles =
      'inline-flex items-center font-medium rounded-full border';

    const variants = {
      default: 'bg-gray-100 text-brand-slate border-gray-200',
      success: 'bg-brand-green/10 text-brand-green border-brand-green/20',
      warning: 'bg-brand-yellow/10 text-brand-yellow border-brand-yellow/20',
      danger: 'bg-brand-red/10 text-brand-red border-brand-red/20',
      info: 'bg-brand-ocean/10 text-brand-ocean border-brand-ocean/20',
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
