/**
 * @fileoverview Admin article editor page.
 */
import { useState, useMemo } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { ArrowLeft, Save, Image, FileText, Eye, Check } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { useAuth } from '../context/AuthContext';
import { useArticles } from '../context/ArticleContext';

/**
 * Article editor page for admins to edit blog post content.
 * Includes markdown preview and image management.
 */
function AdminEditArticle() {
  const { slug } = useParams<{ slug: string }>();
  const { isAdmin } = useAuth();
  const { updateArticle, getArticle } = useArticles();
  const navigate = useNavigate();
  
  const article = useMemo(() => getArticle(slug || ''), [getArticle, slug]);
  
  // Initialize state with article data
  const [title, setTitle] = useState(article?.title || '');
  const [excerpt, setExcerpt] = useState(article?.excerpt || '');
  const [content, setContent] = useState(article?.content || '');
  const [imageUrl, setImageUrl] = useState(article?.featured_image_url || '');
  const [isSaving, setIsSaving] = useState(false);
  const [saveSuccess, setSaveSuccess] = useState(false);

  // Redirect if not admin
  if (!isAdmin) {
    navigate('/admin/login');
    return null;
  }

  if (!article) {
    return (
      <main className="flex-1">
        <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
          <Container>
            <div className="text-center">
              <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
                Article Not Found
              </h1>
              <Link to="/admin">
                <Button variant="outline" className="border-white text-white hover:bg-white hover:text-brand-navy">
                  <ArrowLeft size={16} className="mr-2" />
                  Back to Admin
                </Button>
              </Link>
            </div>
          </Container>
        </section>
      </main>
    );
  }

  const handleSave = async () => {
    setIsSaving(true);
    setSaveSuccess(false);

    // Simulate save delay
    await new Promise(resolve => setTimeout(resolve, 500));

    updateArticle(article.id, {
      title,
      excerpt,
      content,
      featured_image_url: imageUrl,
    });

    setIsSaving(false);
    setSaveSuccess(true);

    // Hide success message after 3 seconds
    setTimeout(() => setSaveSuccess(false), 3000);
  };

  // Common image URLs for quick selection
  const suggestedImages = [
    { label: 'CPR Training', url: 'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=800&q=80' },
    { label: 'Medical Equipment', url: 'https://images.unsplash.com/photo-1584820927498-cfe5211fd8bf?w=800&q=80' },
    { label: 'Heart Monitor', url: 'https://images.unsplash.com/photo-1628348068343-c6a848d2b6dd?w=800&q=80' },
    { label: 'Oxygen Mask', url: 'https://images.unsplash.com/photo-1530497610245-94d3c16cda28?w=800&q=80' },
    { label: 'Emergency Response', url: 'https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=800&q=80' },
    { label: 'Ship/Maritime', url: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=800&q=80' },
  ];

  return (
    <main className="flex-1">
      <section className="pt-24 pb-6 md:pt-28 md:pb-8 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div 
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
          >
            <Link to="/admin" className="inline-flex items-center text-brand-sky-light hover:text-white mb-4 transition-colors">
              <ArrowLeft size={16} className="mr-2" />
              Back to Admin Panel
            </Link>
            <h1 className="text-2xl md:text-3xl font-bold text-white">
              Edit Article
            </h1>
          </motion.div>
        </Container>
      </section>

      <section className="py-8 md:py-12 bg-gray-50">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.2 }}
            className="grid lg:grid-cols-3 gap-8"
          >
            {/* Main Content */}
            <div className="lg:col-span-2 space-y-6">
              {/* Title */}
              <div className="bg-white rounded-xl shadow-sm p-6">
                <label className="block text-sm font-semibold text-gray-700 mb-2">
                  <FileText className="w-4 h-4 inline mr-2" />
                  Article Title
                </label>
                <input
                  type="text"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                  className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-ocean focus:border-transparent transition-all text-lg"
                  placeholder="Enter article title"
                />
              </div>

              {/* Excerpt */}
              <div className="bg-white rounded-xl shadow-sm p-6">
                <label className="block text-sm font-semibold text-gray-700 mb-2">
                  Excerpt / Summary
                </label>
                <textarea
                  value={excerpt}
                  onChange={(e) => setExcerpt(e.target.value)}
                  rows={3}
                  className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-ocean focus:border-transparent transition-all"
                  placeholder="Brief summary of the article"
                />
              </div>

              {/* Content */}
              <div className="bg-white rounded-xl shadow-sm p-6">
                <label className="block text-sm font-semibold text-gray-700 mb-2">
                  Article Content
                </label>
                <textarea
                  value={content}
                  onChange={(e) => setContent(e.target.value)}
                  rows={20}
                  className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-ocean focus:border-transparent transition-all font-mono text-sm"
                  placeholder="Full article content..."
                />
                <p className="mt-2 text-xs text-gray-500">
                  Use [ ] for checklist items, numbers (1. 2. 3.) for steps, and ALL CAPS for section headers.
                </p>
              </div>
            </div>

            {/* Sidebar */}
            <div className="space-y-6">
              {/* Save Button */}
              <div className="bg-white rounded-xl shadow-sm p-6">
                <Button
                  onClick={handleSave}
                  disabled={isSaving}
                  className="w-full"
                  size="lg"
                  leftIcon={isSaving ? undefined : (saveSuccess ? <Check size={18} /> : <Save size={18} />)}
                >
                  {isSaving ? 'Saving...' : (saveSuccess ? 'Saved!' : 'Save Changes')}
                </Button>
                {saveSuccess && (
                  <motion.p 
                    initial={{ opacity: 0 }}
                    animate={{ opacity: 1 }}
                    className="text-green-600 text-sm text-center mt-2"
                  >
                    Article updated successfully
                  </motion.p>
                )}
                <Link to={`/knowledge/${article.slug}`} className="block mt-3">
                  <Button variant="outline" className="w-full" leftIcon={<Eye size={16} />}>
                    View Article
                  </Button>
                </Link>
              </div>

              {/* Featured Image */}
              <div className="bg-white rounded-xl shadow-sm p-6">
                <label className="block text-sm font-semibold text-gray-700 mb-2">
                  <Image className="w-4 h-4 inline mr-2" />
                  Featured Image
                </label>
                
                {/* Current Image Preview */}
                <div className="mb-4 rounded-lg overflow-hidden bg-gray-100 aspect-video">
                  <img 
                    src={imageUrl} 
                    alt="Preview" 
                    className="w-full h-full object-cover"
                    onError={(e) => {
                      (e.target as HTMLImageElement).src = 'https://images.unsplash.com/photo-1584820927498-cfe5211fd8bf?w=800&q=80';
                    }}
                  />
                </div>

                {/* URL Input */}
                <input
                  type="url"
                  value={imageUrl}
                  onChange={(e) => setImageUrl(e.target.value)}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-ocean focus:border-transparent transition-all text-sm"
                  placeholder="Enter image URL"
                />

                {/* Quick Image Selection */}
                <div className="mt-4">
                  <p className="text-xs font-medium text-gray-500 mb-2">Quick Select:</p>
                  <div className="grid grid-cols-2 gap-2">
                    {suggestedImages.map((img, idx) => (
                      <button
                        key={idx}
                        onClick={() => setImageUrl(img.url)}
                        className={`p-2 text-xs rounded border transition-all ${
                          imageUrl === img.url 
                            ? 'border-brand-ocean bg-brand-ocean/10 text-brand-ocean' 
                            : 'border-gray-200 hover:border-brand-ocean hover:bg-gray-50'
                        }`}
                      >
                        {img.label}
                      </button>
                    ))}
                  </div>
                </div>
              </div>

              {/* Article Info */}
              <div className="bg-gray-100 rounded-xl p-4 text-sm text-gray-600">
                <p><strong>ID:</strong> {article.id}</p>
                <p><strong>Slug:</strong> {article.slug}</p>
                <p><strong>Reading Time:</strong> {article.reading_time_minutes} min</p>
                <p><strong>Last Updated:</strong> {new Date(article.updated_at).toLocaleString()}</p>
              </div>
            </div>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default AdminEditArticle;
