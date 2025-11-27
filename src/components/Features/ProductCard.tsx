import { Link } from 'react-router-dom';
import { Package, Heart, Activity, Shield, Stethoscope, Users, Monitor, Zap, Wind, ArrowRight, type LucideIcon } from 'lucide-react';
import Card from '../Common/Card';
import Badge from '../Common/Badge';
import type { Product } from '../../lib/types';

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

interface ProductCardProps {
  product: Product;
}

function ProductCard({ product }: ProductCardProps) {
  const IconComponent = iconMap[product.icon_name || 'Package'] || Package;

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
    <Link to={`/products/${product.slug}`}>
      <Card hoverable className="h-full overflow-hidden group">
        {/* Product Image */}
        {product.image_url && (
          <div className="relative -mx-6 -mt-6 mb-4 aspect-video overflow-hidden bg-gray-100">
            <img
              src={product.image_url}
              alt={product.name}
              className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-300"
            />
            <div className="absolute top-3 right-3">
              <Badge variant={statusVariant[product.status]}>
                {statusLabel[product.status]}
              </Badge>
            </div>
          </div>
        )}

        {!product.image_url && (
          <div className="flex items-start justify-between mb-4">
            <div className="p-3 bg-brand-ocean/10 rounded-lg">
              <IconComponent size={24} className="text-brand-ocean" />
            </div>
            <Badge variant={statusVariant[product.status]}>
              {statusLabel[product.status]}
            </Badge>
          </div>
        )}

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
