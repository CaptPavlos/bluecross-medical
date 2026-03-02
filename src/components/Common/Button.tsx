import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

/**
 * Props for the Button component.
 */
interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary' | 'outline' | 'ghost' | 'danger';
  size?: 'sm' | 'md' | 'lg';
  isLoading?: boolean;
  leftIcon?: React.ReactNode;
  rightIcon?: React.ReactNode;
}

/**
 * Reusable button component with multiple variants, sizes, and loading state.
 * Supports icons on left/right sides and forwards refs for DOM access.
 * @param variant - Visual style: primary, secondary, outline, ghost, or danger
 * @param size - Button size: sm, md, or lg
 * @param isLoading - Shows spinner and disables button when true
 * @param leftIcon - Optional icon to display before button text
 * @param rightIcon - Optional icon to display after button text
 */
const Button = forwardRef<HTMLButtonElement, ButtonProps>(
  (
    {
      className,
      variant = 'primary',
      size = 'md',
      isLoading = false,
      leftIcon,
      rightIcon,
      children,
      disabled,
      ...props
    },
    ref
  ) => {
    const baseStyles =
      'inline-flex items-center justify-center font-medium rounded-md transition-all duration-150 focus:outline-none focus:ring-2 focus:ring-offset-2 disabled:opacity-50 disabled:cursor-not-allowed active:scale-[0.98]';

    const variants = {
      primary:
        'bg-brand-ocean text-white hover:bg-brand-ocean-light focus:ring-brand-ocean shadow-md',
      secondary:
        'bg-brand-navy text-white hover:bg-brand-blue focus:ring-brand-navy',
      outline:
        'border-2 border-brand-ocean text-brand-ocean hover:bg-brand-ocean hover:text-white focus:ring-brand-ocean',
      ghost:
        'text-brand-navy hover:bg-surface-secondary focus:ring-brand-navy',
      danger:
        'bg-brand-red text-white hover:bg-red-700 focus:ring-brand-red',
    };

    const sizes = {
      sm: 'px-3 py-1.5 text-small min-h-[32px]',
      md: 'px-4 py-2 text-body min-h-[40px]',
      lg: 'px-6 py-3 text-body-lg min-h-[48px]',
    };

    return (
      <button
        ref={ref}
        className={cn(baseStyles, variants[variant], sizes[size], className)}
        disabled={disabled || isLoading}
        {...props}
      >
        {isLoading ? (
          <svg
            className="animate-spin -ml-1 mr-2 h-4 w-4"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
          >
            <circle
              className="opacity-25"
              cx="12"
              cy="12"
              r="10"
              stroke="currentColor"
              strokeWidth="4"
            />
            <path
              className="opacity-75"
              fill="currentColor"
              d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4z"
            />
          </svg>
        ) : leftIcon ? (
          <span className="mr-2">{leftIcon}</span>
        ) : null}
        {children}
        {rightIcon && <span className="ml-2">{rightIcon}</span>}
      </button>
    );
  }
);

Button.displayName = 'Button';

export default Button;
