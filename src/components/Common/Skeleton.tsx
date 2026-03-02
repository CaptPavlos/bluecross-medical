import { cn } from '../../lib/utils';

/**
 * Props for the Skeleton component.
 */
interface SkeletonProps extends React.HTMLAttributes<HTMLDivElement> {
  variant?: 'text' | 'circular' | 'rectangular';
  width?: string | number;
  height?: string | number;
}

/**
 * Loading placeholder component with pulse animation.
 * Use to indicate content is loading while maintaining layout.
 * @param variant - Shape type: text (rounded), circular, or rectangular
 * @param width - Custom width (CSS value or number for pixels)
 * @param height - Custom height (CSS value or number for pixels)
 */
function Skeleton({
  className,
  variant = 'text',
  width,
  height,
  ...props
}: SkeletonProps) {
  const baseStyles = 'animate-pulse bg-gray-200';

  const variants = {
    text: 'rounded',
    circular: 'rounded-full',
    rectangular: 'rounded-md',
  };

  const style: React.CSSProperties = {
    width: width,
    height: height || (variant === 'text' ? '1em' : undefined),
  };

  return (
    <div
      className={cn(baseStyles, variants[variant], className)}
      style={style}
      {...props}
    />
  );
}

/**
 * Pre-configured skeleton for generic card content.
 * Includes image placeholder, title, and description lines.
 */
export function SkeletonCard() {
  return (
    <div className="p-4 bg-white rounded-lg shadow-sm">
      <Skeleton variant="rectangular" height={160} className="mb-4" />
      <Skeleton width="70%" className="mb-2 h-5" />
      <Skeleton width="90%" className="mb-2 h-4" />
      <Skeleton width="60%" className="h-4" />
    </div>
  );
}

/**
 * Pre-configured skeleton for team member cards.
 * Includes circular avatar, name, role, and bio placeholders.
 */
export function SkeletonTeamCard() {
  return (
    <div className="p-4 bg-white rounded-lg shadow-sm text-center">
      <Skeleton variant="circular" width={96} height={96} className="mx-auto mb-4" />
      <Skeleton width="60%" className="mx-auto mb-2 h-5" />
      <Skeleton width="40%" className="mx-auto mb-2 h-4" />
      <Skeleton width="80%" className="mx-auto h-4" />
    </div>
  );
}

/**
 * Pre-configured skeleton for blog post cards.
 * Includes featured image, date, title, and excerpt placeholders.
 */
export function SkeletonBlogCard() {
  return (
    <div className="bg-white rounded-lg shadow-sm overflow-hidden">
      <Skeleton variant="rectangular" height={200} />
      <div className="p-4">
        <Skeleton width="30%" className="mb-2 h-4" />
        <Skeleton width="90%" className="mb-2 h-6" />
        <Skeleton width="100%" className="mb-1 h-4" />
        <Skeleton width="70%" className="h-4" />
      </div>
    </div>
  );
}

export default Skeleton;
