import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';
import { BookOpen, FileText, Video, Download, ExternalLink, Search, ArrowRight, Flag, Stethoscope, Ship, AlertTriangle } from 'lucide-react';
import { useState } from 'react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { useArticles } from '../context/ArticleContext';
import { SEOHead } from '../components/SEO';

const categories = [
  { id: 'all', label: 'All', icon: BookOpen },
  { id: 'regulations', label: 'Regulations', icon: Flag },
  { id: 'medical', label: 'Medical Guides', icon: Stethoscope },
  { id: 'equipment', label: 'Equipment', icon: Ship },
  { id: 'emergency', label: 'Emergency', icon: AlertTriangle },
];

const officialDocs = [
  {
    title: 'WHO International Medical Guide for Ships',
    description: 'The definitive reference for medical care at sea. Third edition.',
    url: 'https://apps.who.int/iris/bitstream/handle/10665/43814/9789240682313_eng.pdf',
    type: 'PDF',
    icon: FileText,
  },
  {
    title: 'UK MSN 1905 - Medical Stores Requirements',
    description: 'MCA requirements for medical stores on UK-flagged vessels.',
    url: 'https://assets.publishing.service.gov.uk/media/6059f0c68fa8f545d879f0c6/MSN_1905__M+F_.pdf',
    type: 'PDF',
    icon: FileText,
  },
  {
    title: 'Paris MOU White List 2024',
    description: 'Official performance list for quality flag states.',
    url: 'https://parismou.org/system/files/2025-06/Paris%20MoU%20White%20List%202024.pdf',
    type: 'PDF',
    icon: FileText,
  },
  {
    title: 'MLC 2006 Medical Care Standards',
    description: 'Maritime Labour Convention requirements for health protection.',
    url: 'https://www.ilo.org/wcmsp5/groups/public/---ed_norm/---normes/documents/normativeinstrument/wcms_090250.pdf',
    type: 'PDF',
    icon: FileText,
  },
];

const videoGuides = [
  { title: 'AED Operation on Board', duration: '8:32', topic: 'Emergency' },
  { title: 'Medical Chest Inspection Guide', duration: '12:15', topic: 'Regulations' },
  { title: 'TMAS Communication Protocol', duration: '6:45', topic: 'Emergency' },
  { title: 'Vital Signs Monitoring at Sea', duration: '10:20', topic: 'Equipment' },
];

function Knowledge() {
  const [activeCategory, setActiveCategory] = useState('all');
  const [searchQuery, setSearchQuery] = useState('');
  const { articles } = useArticles();

  const filteredPosts = articles.filter(post => {
    const matchesSearch = post.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
                         post.excerpt.toLowerCase().includes(searchQuery.toLowerCase());
    const matchesCategory = activeCategory === 'all' || 
                           post.tags.some(tag => tag.toLowerCase().includes(activeCategory));
    return matchesSearch && matchesCategory;
  });

  return (
    <main className="flex-1">
      <SEOHead 
        title="Maritime Medical Knowledge Base"
        description="Comprehensive knowledge base for maritime medicine. Flag state regulations, medical guides, equipment requirements, and emergency protocols for yachts and commercial vessels."
        url="/knowledge"
        keywords={['maritime medical knowledge', 'ship medical regulations', 'yacht medical guide', 'MLC medical requirements', 'STCW medical']}
      />
      
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <div className="inline-flex items-center gap-2 bg-white/10 px-4 py-2 rounded-full mb-4">
              <BookOpen className="w-5 h-5 text-brand-sky" />
              <span className="text-sm text-brand-sky-light">Knowledge Base</span>
            </div>
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              Maritime Medical Knowledge
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Guides, articles, and official documents for maritime medical compliance.
              Everything you need to know in one place.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Official Documents */}
      <section className="py-12 bg-surface-secondary">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="mb-8"
          >
            <h2 className="text-xl font-bold text-brand-navy mb-2">
              📄 Official Documents
            </h2>
            <p className="text-sm text-gray-600">
              Essential regulatory documents and international standards.
            </p>
          </motion.div>

          <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-4">
            {officialDocs.map((doc, index) => (
              <motion.a
                key={index}
                href={doc.url}
                target="_blank"
                rel="noopener noreferrer"
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className="bg-white p-4 rounded-xl border border-gray-100 hover:shadow-lg hover:border-brand-ocean/30 transition-all group"
              >
                <div className="flex items-start gap-3">
                  <div className="w-10 h-10 bg-red-50 rounded-lg flex items-center justify-center flex-shrink-0">
                    <doc.icon className="w-5 h-5 text-red-500" />
                  </div>
                  <div className="flex-1 min-w-0">
                    <h3 className="font-medium text-brand-navy text-sm group-hover:text-brand-ocean transition-colors line-clamp-2">
                      {doc.title}
                    </h3>
                    <p className="text-xs text-gray-500 mt-1 line-clamp-2">{doc.description}</p>
                    <div className="flex items-center gap-2 mt-2 text-xs text-brand-ocean">
                      <Download size={12} />
                      <span>{doc.type}</span>
                      <ExternalLink size={12} />
                    </div>
                  </div>
                </div>
              </motion.a>
            ))}
          </div>
        </Container>
      </section>

      {/* Mariners Medical Guide - Primary Resource */}
      <section className="py-8 bg-gradient-to-r from-brand-ocean to-brand-blue">
        <Container>
          <motion.a
            href="https://app.medicoguide.no/"
            target="_blank"
            rel="noopener noreferrer"
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="flex flex-col md:flex-row items-center gap-6 bg-white/10 backdrop-blur-sm rounded-2xl p-6 md:p-8 hover:bg-white/20 transition-all group"
          >
            <div className="w-16 h-16 md:w-20 md:h-20 bg-white rounded-2xl flex items-center justify-center flex-shrink-0 shadow-lg">
              <Stethoscope className="w-8 h-8 md:w-10 md:h-10 text-brand-ocean" />
            </div>
            <div className="flex-1 text-center md:text-left">
              <div className="inline-flex items-center gap-2 bg-white/20 px-3 py-1 rounded-full mb-2">
                <span className="text-xs font-medium text-white">First Point of Reference</span>
              </div>
              <h2 className="text-xl md:text-2xl font-bold text-white mb-2">
                Mariners Medical Guide (MEDICO)
              </h2>
              <p className="text-brand-sky-light text-sm md:text-base">
                The essential interactive digital guide for medical emergencies at sea. 
                Start here for immediate guidance on symptoms, treatments, and procedures.
              </p>
            </div>
            <div className="flex items-center gap-2 bg-white text-brand-ocean px-6 py-3 rounded-lg font-medium group-hover:bg-brand-sky-light transition-colors">
              <span>Open Guide</span>
              <ExternalLink size={18} />
            </div>
          </motion.a>
        </Container>
      </section>

      {/* Search */}
      <section className="py-6 bg-white border-b border-gray-100 sticky top-16 md:top-20 z-30">
        <Container>
          <div className="flex flex-col md:flex-row gap-4">
            <div className="relative flex-1">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" size={20} />
              <input
                type="text"
                placeholder="Search articles and guides..."
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                className="w-full pl-10 pr-4 py-2 border border-gray-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean"
              />
            </div>
            <div className="flex gap-2 overflow-x-auto pb-2 md:pb-0">
              {categories.map(cat => (
                <button
                  key={cat.id}
                  onClick={() => setActiveCategory(cat.id)}
                  className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium whitespace-nowrap transition-colors ${
                    activeCategory === cat.id
                      ? 'bg-brand-ocean text-white'
                      : 'bg-gray-100 text-gray-600 hover:bg-gray-200'
                  }`}
                >
                  <cat.icon size={16} />
                  {cat.label}
                </button>
              ))}
            </div>
          </div>
        </Container>
      </section>

      {/* Articles */}
      <section className="py-12">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="mb-8"
          >
            <h2 className="text-xl font-bold text-brand-navy mb-2">
              📚 Articles & Guides
            </h2>
            <p className="text-sm text-gray-600">
              In-depth articles on maritime medical topics.
            </p>
          </motion.div>

          {filteredPosts.length > 0 ? (
            <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
              {filteredPosts.map((post, index) => (
                <motion.div
                  key={post.id}
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                  transition={{ delay: index * 0.05 }}
                >
                  <Link to={`/blog/${post.slug}`}>
                    <div className="bg-white rounded-xl border border-gray-100 overflow-hidden hover:shadow-lg transition-shadow group h-full">
                      {post.featured_image_url && (
                        <div className="aspect-video overflow-hidden">
                          <img
                            src={post.featured_image_url}
                            alt={post.title}
                            className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-300"
                          />
                        </div>
                      )}
                      <div className="p-4">
                        <div className="flex flex-wrap gap-2 mb-2">
                          {post.tags.slice(0, 2).map(tag => (
                            <span key={tag} className="text-xs bg-brand-ocean/10 text-brand-ocean px-2 py-1 rounded">
                              {tag}
                            </span>
                          ))}
                        </div>
                        <h3 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors line-clamp-2">
                          {post.title}
                        </h3>
                        <p className="text-sm text-gray-600 mt-2 line-clamp-2">{post.excerpt}</p>
                        <div className="flex items-center gap-2 mt-3 text-xs text-gray-500">
                          <span>{post.reading_time_minutes} min read</span>
                        </div>
                      </div>
                    </div>
                  </Link>
                </motion.div>
              ))}
            </div>
          ) : (
            <div className="text-center py-12 text-gray-500">
              No articles found matching your search.
            </div>
          )}
        </Container>
      </section>

      {/* Video Guides (Coming Soon) */}
      <section className="py-12 bg-surface-secondary">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="mb-8"
          >
            <h2 className="text-xl font-bold text-brand-navy mb-2">
              🎥 Video Guides
              <span className="ml-2 text-xs font-normal bg-brand-ocean/10 text-brand-ocean px-2 py-1 rounded">Coming Soon</span>
            </h2>
            <p className="text-sm text-gray-600">
              Step-by-step video tutorials for maritime medical procedures.
            </p>
          </motion.div>

          <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-4">
            {videoGuides.map((video, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className="bg-white/60 p-4 rounded-xl border border-gray-200 opacity-75"
              >
                <div className="aspect-video bg-gray-100 rounded-lg flex items-center justify-center mb-3">
                  <Video className="w-8 h-8 text-gray-400" />
                </div>
                <h3 className="font-medium text-gray-600 text-sm">{video.title}</h3>
                <div className="flex items-center justify-between mt-2 text-xs text-gray-400">
                  <span>{video.duration}</span>
                  <span>{video.topic}</span>
                </div>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* CTA */}
      <section className="py-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="text-center"
          >
            <h2 className="text-2xl font-bold text-white mb-4">
              Can't Find What You're Looking For?
            </h2>
            <p className="text-brand-sky-light max-w-xl mx-auto mb-6">
              Our database is constantly growing. Contact us if you need specific information 
              about flag state requirements or maritime medical regulations.
            </p>
            <Link to="/contact">
              <Button size="lg" rightIcon={<ArrowRight size={20} />}>
                Ask a Question
              </Button>
            </Link>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default Knowledge;
