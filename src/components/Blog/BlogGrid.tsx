import { useState, useEffect } from 'react';
import { getBlogPosts } from '../../lib/api/blog';
import type { BlogPost } from '../../lib/types';
import BlogCard from './BlogCard';
import { SkeletonBlogCard } from '../Common/Skeleton';

/**
 * Props for the BlogGrid component.
 */
interface BlogGridProps {
  limit?: number;
  showFeatured?: boolean;
}

/**
 * Responsive grid layout for displaying blog post cards.
 * Handles data fetching, loading states, and empty states.
 * @param limit - Maximum number of posts to display
 * @param showFeatured - Shows first post as featured (larger) when true
 */
function BlogGrid({ limit, showFeatured = false }: BlogGridProps) {
  const [posts, setPosts] = useState<BlogPost[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchPosts = async () => {
      setIsLoading(true);
      try {
        const data = await getBlogPosts(limit);
        setPosts(data);
      } catch (error) {
        console.error('Error fetching blog posts:', error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchPosts();
  }, [limit]);

  if (isLoading) {
    return (
      <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
        {Array.from({ length: limit || 6 }).map((_, i) => (
          <SkeletonBlogCard key={i} />
        ))}
      </div>
    );
  }

  if (posts.length === 0) {
    return (
      <div className="text-center py-12 text-brand-gray">
        No blog posts found.
      </div>
    );
  }

  const [featured, ...rest] = posts;

  return (
    <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
      {showFeatured && featured && (
        <BlogCard post={featured} index={0} featured />
      )}
      {(showFeatured ? rest : posts).map((post, index) => (
        <BlogCard
          key={post.id}
          post={post}
          index={showFeatured ? index + 1 : index}
        />
      ))}
    </div>
  );
}

export default BlogGrid;
