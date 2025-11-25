import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

interface CardProps extends React.HTMLAttributes<HTMLDivElement> {
  variant?: 'default' | 'elevated' | 'outlined';
  padding?: 'none' | 'sm' | 'md' | 'lg';
  hoverable?: boolean;
}

const Card = forwardRef<HTMLDivElement, CardProps>(
  (
    {
      className,
      variant = 'default',
      padding = 'md',
      hoverable = false,
      children,
      ...props
    },
    ref
  ) => {
    const baseStyles = 'rounded-lg overflow-hidden';

    const variants = {
      default: 'bg-white shadow-sm',
      elevated: 'bg-white shadow-md',
      outlined: 'bg-white border border-gray-200',
    };

    const paddings = {
      none: '',
      sm: 'p-3',
      md: 'p-4 md:p-6',
      lg: 'p-6 md:p-8',
    };

    const hoverStyles = hoverable
      ? 'transition-all duration-200 hover:shadow-lg hover:-translate-y-1 cursor-pointer'
      : '';

    return (
      <div
        ref={ref}
        className={cn(
          baseStyles,
          variants[variant],
          paddings[padding],
          hoverStyles,
          className
        )}
        {...props}
      >
        {children}
      </div>
    );
  }
);

Card.displayName = 'Card';

// Card subcomponents
type CardHeaderProps = React.HTMLAttributes<HTMLDivElement>

export const CardHeader = forwardRef<HTMLDivElement, CardHeaderProps>(
  ({ className, ...props }, ref) => (
    <div
      ref={ref}
      className={cn('pb-4 border-b border-gray-100', className)}
      {...props}
    />
  )
);

CardHeader.displayName = 'CardHeader';

type CardContentProps = React.HTMLAttributes<HTMLDivElement>

export const CardContent = forwardRef<HTMLDivElement, CardContentProps>(
  ({ className, ...props }, ref) => (
    <div ref={ref} className={cn('py-4', className)} {...props} />
  )
);

CardContent.displayName = 'CardContent';

type CardFooterProps = React.HTMLAttributes<HTMLDivElement>

export const CardFooter = forwardRef<HTMLDivElement, CardFooterProps>(
  ({ className, ...props }, ref) => (
    <div
      ref={ref}
      className={cn('pt-4 border-t border-gray-100', className)}
      {...props}
    />
  )
);

CardFooter.displayName = 'CardFooter';

export default Card;
