import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { Calendar, Clock, User } from 'lucide-react';
import Card from '../Common/Card';
import Badge from '../Common/Badge';
import type { BlogPost } from '../../lib/types';
import { formatDate } from '../../lib/utils';

interface BlogCardProps {
  post: BlogPost;
  index?: number;
  featured?: boolean;
}

function BlogCard({ post, index = 0, featured = false }: BlogCardProps) {
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: index * 0.1 }}
      className={featured ? 'md:col-span-2' : ''}
    >
      <Link to={`/blog/${post.slug}`}>
        <Card hoverable padding="none" className="overflow-hidden h-full">
          {/* Image */}
          {post.featured_image_url && (
            <div className={`overflow-hidden ${featured ? 'h-64' : 'h-48'}`}>
              <img
                src={post.featured_image_url}
                alt={post.title}
                className="w-full h-full object-cover transition-transform duration-slow hover:scale-105"
              />
            </div>
          )}

          <div className="p-4 md:p-6">
            {/* Tags */}
            {post.tags.length > 0 && (
              <div className="flex flex-wrap gap-2 mb-3">
                {post.tags.slice(0, 2).map((tag) => (
                  <Badge key={tag} variant="info" size="sm">
                    {tag}
                  </Badge>
                ))}
              </div>
            )}

            {/* Title */}
            <h3 className={`font-semibold text-brand-slate mb-2 line-clamp-2 ${featured ? 'text-h2' : 'text-h3'}`}>
              {post.title}
            </h3>

            {/* Excerpt */}
            <p className="text-brand-gray mb-4 line-clamp-2">
              {post.excerpt}
            </p>

            {/* Meta */}
            <div className="flex flex-wrap items-center gap-4 text-sm text-brand-gray">
              <span className="flex items-center gap-1">
                <User size={14} />
                {post.author_name}
              </span>
              {post.published_at && (
                <span className="flex items-center gap-1">
                  <Calendar size={14} />
                  {formatDate(post.published_at)}
                </span>
              )}
              {post.reading_time_minutes && (
                <span className="flex items-center gap-1">
                  <Clock size={14} />
                  {post.reading_time_minutes} min read
                </span>
              )}
            </div>
          </div>
        </Card>
      </Link>
    </motion.div>
  );
}

export default BlogCard;
