import { useState, useEffect } from 'react';
import { getProducts } from '../../lib/api/products';
import type { Product, ProductStatus } from '../../lib/types';
import ProductCard from './ProductCard';
import { SkeletonCard } from '../Common/Skeleton';
import Button from '../Common/Button';

interface ProductGridProps {
  limit?: number;
  showFilters?: boolean;
}

function ProductGrid({ limit, showFilters = false }: ProductGridProps) {
  const [products, setProducts] = useState<Product[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [filter, setFilter] = useState<ProductStatus | 'all'>('all');

  useEffect(() => {
    const fetchProducts = async () => {
      setIsLoading(true);
      try {
        const data = await getProducts(filter === 'all' ? undefined : filter);
        setProducts(limit ? data.slice(0, limit) : data);
      } catch (error) {
        console.error('Error fetching products:', error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchProducts();
  }, [filter, limit]);

  const filters: { value: ProductStatus | 'all'; label: string }[] = [
    { value: 'all', label: 'All' },
    { value: 'in-stock', label: 'In Stock' },
    { value: 'to-order', label: 'To Order' },
    { value: 'not-available', label: 'Not Available' },
  ];

  return (
    <div>
      {showFilters && (
        <div className="flex flex-wrap gap-2 mb-6">
          {filters.map((f) => (
            <Button
              key={f.value}
              variant={filter === f.value ? 'primary' : 'ghost'}
              size="sm"
              onClick={() => setFilter(f.value)}
            >
              {f.label}
            </Button>
          ))}
        </div>
      )}

      {isLoading ? (
        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
          {Array.from({ length: limit || 6 }).map((_, i) => (
            <SkeletonCard key={i} />
          ))}
        </div>
      ) : products.length > 0 ? (
        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
          {products.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>
      ) : (
        <div className="text-center py-12 text-brand-gray">
          No products found.
        </div>
      )}
    </div>
  );
}

export default ProductGrid;
