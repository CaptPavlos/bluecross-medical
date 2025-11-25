import { useParams, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { ArrowLeft, Clock, Calendar, Tag, User } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { MOCK_BLOG_POSTS } from '../lib/constants';

function BlogDetail() {
  const { slug } = useParams<{ slug: string }>();
  const post = MOCK_BLOG_POSTS.find(p => p.slug === slug);

  if (!post) {
    return (
      <main className="flex-1">
        <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
          <Container>
            <div className="text-center">
              <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
                Article Not Found
              </h1>
              <p className="text-brand-sky-light mb-8">
                The article you're looking for doesn't exist.
              </p>
              <Link to="/knowledge">
                <Button variant="outline" className="border-white text-white hover:bg-white hover:text-brand-navy">
                  <ArrowLeft size={16} className="mr-2" />
                  Back to Knowledge Base
                </Button>
              </Link>
            </div>
          </Container>
        </section>
      </main>
    );
  }

  // Format content with markdown-like styling
  const formatContent = (content: string) => {
    return content
      .split('\n\n')
      .map((paragraph, index) => {
        // Handle headers
        if (paragraph.startsWith('**') && paragraph.endsWith('**')) {
          return (
            <h3 key={index} className="text-lg font-bold text-brand-navy mt-6 mb-3">
              {paragraph.replace(/\*\*/g, '')}
            </h3>
          );
        }
        // Handle list items
        if (paragraph.startsWith('- ')) {
          const items = paragraph.split('\n').filter(line => line.startsWith('- '));
          return (
            <ul key={index} className="list-disc list-inside space-y-1 mb-4 text-gray-700">
              {items.map((item, i) => (
                <li key={i}>{item.replace('- ', '')}</li>
              ))}
            </ul>
          );
        }
        // Regular paragraph
        return (
          <p key={index} className="text-gray-700 mb-4 leading-relaxed">
            {paragraph}
          </p>
        );
      });
  };

  return (
    <main className="flex-1">
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
          >
            <Link 
              to="/knowledge" 
              className="inline-flex items-center gap-2 text-brand-sky-light hover:text-white transition-colors mb-6"
            >
              <ArrowLeft size={16} />
              Back to Knowledge Base
            </Link>
            
            <div className="flex flex-wrap gap-2 mb-4">
              {post.tags.map(tag => (
                <span 
                  key={tag} 
                  className="inline-flex items-center gap-1 text-xs bg-white/10 text-brand-sky-light px-3 py-1 rounded-full"
                >
                  <Tag size={10} />
                  {tag}
                </span>
              ))}
            </div>
            
            <h1 className="text-2xl md:text-4xl font-bold text-white mb-4">
              {post.title}
            </h1>
            
            <div className="flex flex-wrap items-center gap-4 text-sm text-brand-sky-light">
              <span className="flex items-center gap-1">
                <User size={14} />
                {post.author_name}
              </span>
              <span className="flex items-center gap-1">
                <Calendar size={14} />
                {new Date(post.published_at ?? post.created_at).toLocaleDateString('en-US', {
                  year: 'numeric',
                  month: 'long',
                  day: 'numeric'
                })}
              </span>
              <span className="flex items-center gap-1">
                <Clock size={14} />
                {post.reading_time_minutes} min read
              </span>
            </div>
          </motion.div>
        </Container>
      </section>

      {/* Featured Image */}
      {post.featured_image_url && (
        <section className="relative -mt-8 mb-8">
          <Container>
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: 0.2 }}
              className="rounded-xl overflow-hidden shadow-xl"
            >
              <img
                src={post.featured_image_url}
                alt={post.title}
                className="w-full h-64 md:h-96 object-cover"
              />
            </motion.div>
          </Container>
        </section>
      )}

      {/* Content */}
      <section className="py-8 md:py-12">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ delay: 0.3 }}
            className="max-w-3xl mx-auto"
          >
            <div className="bg-white rounded-xl p-6 md:p-8 shadow-sm border border-gray-100">
              {/* Excerpt */}
              <p className="text-lg text-brand-ocean font-medium mb-6 pb-6 border-b border-gray-100">
                {post.excerpt}
              </p>
              
              {/* Main Content */}
              <div className="prose prose-lg max-w-none">
                {formatContent(post.content)}
              </div>
            </div>

            {/* Related Articles */}
            <div className="mt-12">
              <h2 className="text-xl font-bold text-brand-navy mb-6">Related Articles</h2>
              <div className="grid md:grid-cols-2 gap-4">
                {MOCK_BLOG_POSTS
                  .filter(p => p.id !== post.id && p.tags.some(t => post.tags.includes(t)))
                  .slice(0, 2)
                  .map(relatedPost => (
                    <Link 
                      key={relatedPost.id} 
                      to={`/blog/${relatedPost.slug}`}
                      className="bg-white rounded-xl p-4 border border-gray-100 hover:shadow-lg hover:border-brand-ocean/30 transition-all group"
                    >
                      <h3 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors mb-2">
                        {relatedPost.title}
                      </h3>
                      <p className="text-sm text-gray-600 line-clamp-2">{relatedPost.excerpt}</p>
                    </Link>
                  ))}
              </div>
            </div>

            {/* CTA */}
            <div className="mt-12 text-center">
              <Link to="/knowledge">
                <Button variant="outline">
                  <ArrowLeft size={16} className="mr-2" />
                  Back to Knowledge Base
                </Button>
              </Link>
            </div>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default BlogDetail;
