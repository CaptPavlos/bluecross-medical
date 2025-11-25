import { useState, useCallback } from 'react';
import { motion } from 'framer-motion';
import { BlogGrid, BlogSearch } from '../components/Blog';
import { ScrollReveal } from '../components/Animations';
import Container from '../components/Common/Container';

function Blog() {
  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = useCallback((query: string) => {
    setSearchQuery(query);
    // In a real app, this would trigger a new fetch with the search query
    console.log('Searching for:', query);
  }, []);

  return (
    <main className="flex-1">
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <h1 className="text-display md:text-5xl font-bold text-white mb-4">
              🌍 Flag State Database
            </h1>
            <p className="text-lg md:text-xl text-brand-sky-light max-w-2xl mx-auto">
              Medical requirements by flag state, equipment guides, and maritime health resources.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Search */}
      <section className="py-8 border-b border-gray-100">
        <Container size="md">
          <BlogSearch onSearch={handleSearch} />
        </Container>
      </section>

      {/* Blog Grid */}
      <section className="py-12 md:py-16">
        <Container>
          <ScrollReveal>
            {searchQuery ? (
              <div className="mb-6">
                <p className="text-brand-gray">
                  Showing results for: <span className="font-medium text-brand-slate">"{searchQuery}"</span>
                </p>
              </div>
            ) : null}
            <BlogGrid showFeatured />
          </ScrollReveal>
        </Container>
      </section>

      {/* Newsletter */}
      <section className="py-12 md:py-16 bg-surface-secondary">
        <Container size="md">
          <ScrollReveal>
            <div className="text-center">
              <h2 className="text-h1 font-bold text-brand-slate mb-4">
                Subscribe to Our Newsletter
              </h2>
              <p className="text-brand-gray mb-6">
                Get the latest healthcare insights delivered directly to your inbox.
              </p>
              <form className="flex flex-col sm:flex-row gap-3 max-w-md mx-auto">
                <input
                  type="email"
                  placeholder="Enter your email"
                  className="flex-1 px-4 py-3 border border-gray-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean"
                />
                <button
                  type="submit"
                  className="px-6 py-3 bg-brand-ocean text-white font-medium rounded-lg hover:bg-brand-ocean-light transition-colors"
                >
                  Subscribe
                </button>
              </form>
            </div>
          </ScrollReveal>
        </Container>
      </section>
    </main>
  );
}

export default Blog;
