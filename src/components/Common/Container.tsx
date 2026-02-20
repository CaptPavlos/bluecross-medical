import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

/**
 * Props for the Container component.
 */
interface ContainerProps extends React.HTMLAttributes<HTMLDivElement> {
  size?: 'sm' | 'md' | 'lg' | 'xl' | 'full';
}

/**
 * Responsive container component that centers content with max-width constraints.
 * Includes responsive horizontal padding for consistent page layouts.
 * @param size - Maximum width: sm (2xl), md (4xl), lg (6xl), xl (7xl), or full
 */
const Container = forwardRef<HTMLDivElement, ContainerProps>(
  ({ className, size = 'lg', children, ...props }, ref) => {
    const sizes = {
      sm: 'max-w-2xl',
      md: 'max-w-4xl',
      lg: 'max-w-6xl',
      xl: 'max-w-7xl',
      full: 'max-w-full',
    };

    return (
      <div
        ref={ref}
        className={cn(
          'mx-auto w-full px-4 sm:px-6 lg:px-8',
          sizes[size],
          className
        )}
        {...props}
      >
        {children}
      </div>
    );
  }
);

Container.displayName = 'Container';

export default Container;
