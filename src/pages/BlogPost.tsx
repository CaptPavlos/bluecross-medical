/**
 * Blog Post Page
 *
 * Individual blog article view with full content, author info,
 * reading time, and social sharing buttons.
 * Fetches post data based on URL slug parameter.
 *
 * @module pages/BlogPost
 */
import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { ArrowLeft, Calendar, Clock, User, Share2, Twitter, Linkedin, Facebook } from 'lucide-react';
import { getBlogPostBySlug } from '../lib/api/blog';
import type { BlogPost as BlogPostType } from '../lib/types';
import { formatDate } from '../lib/utils';
import Container from '../components/Common/Container';
import Badge from '../components/Common/Badge';
import { Skeleton } from '../components/Common';

/**
 * Single blog post view with loading state and social sharing.
 */
function BlogPost() {
  const { slug } = useParams<{ slug: string }>();
  const [post, setPost] = useState<BlogPostType | null>(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchPost = async () => {
      if (!slug) return;
      setIsLoading(true);
      try {
        const data = await getBlogPostBySlug(slug);
        setPost(data);
      } catch (error) {
        console.error('Error fetching blog post:', error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchPost();
  }, [slug]);

  if (isLoading) {
    return (
      <main className="flex-1 pt-24">
        <Container size="md">
          <div className="py-12">
            <Skeleton width={100} className="mb-4 h-6" />
            <Skeleton width="80%" className="mb-4 h-10" />
            <Skeleton width="60%" className="mb-8 h-6" />
            <Skeleton variant="rectangular" height={400} className="mb-8" />
            <Skeleton width="100%" className="mb-2 h-4" />
            <Skeleton width="100%" className="mb-2 h-4" />
            <Skeleton width="80%" className="h-4" />
          </div>
        </Container>
      </main>
    );
  }

  if (!post) {
    return (
      <main className="flex-1 pt-24">
        <Container size="md">
          <div className="py-12 text-center">
            <h1 className="text-h1 font-bold text-brand-slate mb-4">Post Not Found</h1>
            <p className="text-brand-gray mb-6">The blog post you're looking for doesn't exist.</p>
            <Link to="/blog" className="text-brand-ocean hover:underline">
              ← Back to Blog
            </Link>
          </div>
        </Container>
      </main>
    );
  }

  return (
    <main className="flex-1">
      <article>
        {/* Header */}
        <header className="pt-24 pb-12 md:pt-28 bg-surface-secondary">
          <Container size="md">
            <motion.div initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }}>
              <Link to="/blog" className="inline-flex items-center text-brand-ocean hover:underline mb-6">
                <ArrowLeft size={16} className="mr-2" />
                Back to Blog
              </Link>

              {post.tags.length > 0 && (
                <div className="flex flex-wrap gap-2 mb-4">
                  {post.tags.map((tag) => (
                    <Badge key={tag} variant="info">{tag}</Badge>
                  ))}
                </div>
              )}

              <h1 className="text-display md:text-5xl font-bold text-brand-slate mb-4">
                {post.title}
              </h1>

              <div className="flex flex-wrap items-center gap-4 text-brand-gray">
                <span className="flex items-center gap-2">
                  <User size={16} />
                  {post.author_name}
                </span>
                {post.published_at && (
                  <span className="flex items-center gap-2">
                    <Calendar size={16} />
                    {formatDate(post.published_at)}
                  </span>
                )}
                {post.reading_time_minutes && (
                  <span className="flex items-center gap-2">
                    <Clock size={16} />
                    {post.reading_time_minutes} min read
                  </span>
                )}
              </div>
            </motion.div>
          </Container>
        </header>

        {/* Featured Image */}
        {post.featured_image_url && (
          <div className="relative h-64 md:h-96 -mt-4">
            <Container size="md">
              <img
                src={post.featured_image_url}
                alt={post.title}
                className="w-full h-full object-cover rounded-xl shadow-lg"
              />
            </Container>
          </div>
        )}

        {/* Content */}
        <Container size="md">
          <div className="py-12">
            <div className="prose prose-lg max-w-none text-brand-slate">
              {post.content.split('\n').map((paragraph, index) => (
                <p key={index} className="mb-4">{paragraph}</p>
              ))}
            </div>

            {/* Share */}
            <div className="mt-12 pt-8 border-t border-gray-200">
              <div className="flex items-center gap-4">
                <span className="flex items-center gap-2 text-brand-gray">
                  <Share2 size={18} />
                  Share this article:
                </span>
                <div className="flex gap-2">
                  <a href="#" className="p-2 text-brand-gray hover:text-brand-ocean hover:bg-brand-ocean/10 rounded-full transition-colors">
                    <Twitter size={18} />
                  </a>
                  <a href="#" className="p-2 text-brand-gray hover:text-brand-ocean hover:bg-brand-ocean/10 rounded-full transition-colors">
                    <Linkedin size={18} />
                  </a>
                  <a href="#" className="p-2 text-brand-gray hover:text-brand-ocean hover:bg-brand-ocean/10 rounded-full transition-colors">
                    <Facebook size={18} />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </Container>
      </article>
    </main>
  );
}

export default BlogPost;
