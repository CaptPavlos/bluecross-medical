import { cn } from '../../lib/utils';

interface SkeletonProps extends React.HTMLAttributes<HTMLDivElement> {
  variant?: 'text' | 'circular' | 'rectangular';
  width?: string | number;
  height?: string | number;
}

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

// Preset skeleton components
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
