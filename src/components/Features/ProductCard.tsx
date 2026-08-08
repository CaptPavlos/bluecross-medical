import { useState } from 'react';
import { Link } from 'react-router-dom';
import { Package, Heart, Activity, Shield, Stethoscope, Users, Monitor, Zap, Wind, ArrowRight, type LucideIcon } from 'lucide-react';
import Card from '../Common/Card';
import Badge from '../Common/Badge';
import type { Product } from '../../lib/types';

/** Mapping of icon names to Lucide icon components */
const iconMap: Record<string, LucideIcon> = {
  Package,
  Heart,
  Activity,
  Shield,
  Stethoscope,
  Users,
  Monitor,
  Zap,
  Wind,
};

/**
 * Props for the ProductCard component.
 */
interface ProductCardProps {
  product: Product;
}

/**
 * Product preview card with image, status badge, features, and hover effects.
 * Displays product details and links to the full product detail page.
 * @param product - Product data to display
 */
function ProductCard({ product }: ProductCardProps) {
  const IconComponent = iconMap[product.icon_name || 'Package'] || Package;
  const [failedImageUrl, setFailedImageUrl] = useState<string | null>(null);
  const hasWorkingImage = Boolean(product.image_url && failedImageUrl !== product.image_url);

  const statusVariant = {
    'in-stock': 'success' as const,
    'to-order': 'warning' as const,
    'not-available': 'danger' as const,
  };

  const statusLabel = {
    'in-stock': 'In Stock',
    'to-order': 'To Order',
    'not-available': 'Not Available',
  };

  return (
    <Link
      to={`/products/${product.slug}`}
      className="block h-full rounded-lg"
      aria-label={`View details for ${product.name}`}
    >
      <Card hoverable className="h-full overflow-hidden group">
        {/* Product Image */}
        <div className="relative -mx-4 -mt-4 mb-4 aspect-video overflow-hidden bg-gradient-to-br from-brand-navy via-brand-blue to-brand-ocean md:-mx-6 md:-mt-6">
          {hasWorkingImage ? (
            <img
              src={product.image_url}
              alt={`${product.name} — branded illustrative product view`}
              width={800}
              height={450}
              loading="lazy"
              decoding="async"
              onError={() => setFailedImageUrl(product.image_url || null)}
              className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-300"
            />
          ) : (
            <div className="flex h-full flex-col items-center justify-center gap-2 text-white">
              <span className="flex h-16 w-16 items-center justify-center rounded-2xl bg-white/15 ring-1 ring-white/25">
                <IconComponent size={34} aria-hidden="true" />
              </span>
              <span className="text-xs font-medium text-brand-sky-light">Product illustration unavailable</span>
            </div>
          )}
          <div className="absolute top-3 right-3">
            <Badge variant={statusVariant[product.status]}>
              {statusLabel[product.status]}
            </Badge>
          </div>
        </div>

        <h3 className="text-lg font-semibold text-brand-slate mb-2 group-hover:text-brand-ocean transition-colors">
          {product.name}
        </h3>

        <p className="text-brand-gray text-sm mb-4 line-clamp-3">
          {product.description}
        </p>

        {product.features.length > 0 && (
          <div className="flex flex-wrap gap-1.5 mb-4">
            {product.features.slice(0, 4).map((feature, i) => (
              <span
                key={i}
                className="px-2 py-1 bg-brand-ocean/5 text-brand-ocean text-xs rounded-full border border-brand-ocean/20"
              >
                {feature}
              </span>
            ))}
            {product.features.length > 4 && (
              <span className="px-2 py-1 text-brand-gray text-xs">
                +{product.features.length - 4} more
              </span>
            )}
          </div>
        )}

        <div className="flex items-center text-brand-ocean text-sm font-medium group-hover:gap-2 transition-all">
          <span>View Details</span>
          <ArrowRight size={16} className="ml-1 group-hover:translate-x-1 transition-transform" />
        </div>
      </Card>
    </Link>
  );
}

export default ProductCard;
