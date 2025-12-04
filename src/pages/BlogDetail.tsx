import { useParams, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { useState } from 'react';
import { ArrowLeft, Clock, Calendar, Tag, User, Printer, ChevronDown, ChevronUp, ExternalLink, Edit } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { useArticles } from '../context/ArticleContext';
import { useAuth } from '../context/AuthContext';
import { SEOHead } from '../components/SEO';

function BlogDetail() {
  const { slug } = useParams<{ slug: string }>();
  const { getArticle, articles } = useArticles();
  const { isAdmin } = useAuth();
  const post = getArticle(slug || '');
  
  // State for collapsible sections - must be before any conditional returns
  const [expandedSections, setExpandedSections] = useState<Record<string, boolean>>({});

  const toggleSection = (key: string) => {
    setExpandedSections(prev => ({ ...prev, [key]: !prev[key] }));
  };

  // Generate printer-friendly PDF
  const handlePrint = () => {
    const printWindow = window.open('', '_blank');
    if (printWindow && post) {
      // Process content for proper formatting
      const lines = post.content.split('\n');
      let formattedContent = '';
      let inList = false;
      
      lines.forEach(line => {
        const trimmedLine = line.trim();
        
        // Skip empty lines but add spacing
        if (!trimmedLine) {
          if (inList) {
            formattedContent += '</ul>';
            inList = false;
          }
          formattedContent += '<br>';
          return;
        }
        
        // ALL CAPS headers (section titles)
        if (/^[A-Z][A-Z\s:]+$/.test(trimmedLine) && trimmedLine.length > 3) {
          if (inList) {
            formattedContent += '</ul>';
            inList = false;
          }
          formattedContent += `<h2>${trimmedLine}</h2>`;
          return;
        }
        
        // Checklist items [ ]
        if (trimmedLine.startsWith('[ ]') || trimmedLine.startsWith('[x]')) {
          if (!inList) {
            formattedContent += '<ul class="checklist">';
            inList = true;
          }
          const checkbox = trimmedLine.startsWith('[x]') ? '☑' : '☐';
          const text = trimmedLine.replace(/^\[.\]\s*/, '');
          formattedContent += `<li>${checkbox} ${text}</li>`;
          return;
        }
        
        // Numbered items (1. 2. 3. etc)
        if (/^\d+\./.test(trimmedLine)) {
          if (!inList) {
            formattedContent += '<ol>';
            inList = true;
          }
          const text = trimmedLine.replace(/^\d+\.\s*/, '');
          // Bold the action word if there's a dash
          const parts = text.split(' - ');
          if (parts.length > 1) {
            formattedContent += `<li><strong>${parts[0]}</strong> - ${parts.slice(1).join(' - ')}</li>`;
          } else {
            formattedContent += `<li>${text}</li>`;
          }
          return;
        }
        
        // Bullet points
        if (trimmedLine.startsWith('- ')) {
          if (!inList) {
            formattedContent += '<ul>';
            inList = true;
          }
          formattedContent += `<li>${trimmedLine.substring(2)}</li>`;
          return;
        }
        
        // Close any open list and add paragraph
        if (inList) {
          formattedContent += inList ? '</ul>' : '</ol>';
          inList = false;
        }
        formattedContent += `<p>${trimmedLine}</p>`;
      });
      
      // Close any remaining open list
      if (inList) {
        formattedContent += '</ul>';
      }
      
      printWindow.document.write(`
        <!DOCTYPE html>
        <html>
        <head>
          <title>${post.title} - BlueCross Medical</title>
          <style>
            body { font-family: Arial, sans-serif; max-width: 800px; margin: 40px auto; padding: 20px; line-height: 1.8; }
            h1 { color: #1e3a5f; border-bottom: 2px solid #0077B6; padding-bottom: 10px; font-size: 24px; }
            h2 { color: #0077B6; margin-top: 24px; font-size: 16px; background: #f0f7ff; padding: 8px 12px; border-radius: 4px; }
            p { margin: 8px 0; }
            .meta { color: #666; font-size: 14px; margin-bottom: 20px; }
            ul, ol { margin: 10px 0; padding-left: 20px; }
            li { margin: 6px 0; padding: 4px 0; }
            ul.checklist { list-style: none; padding-left: 10px; background: #f9f9f9; padding: 15px; border-radius: 8px; }
            ul.checklist li { padding: 6px 0; border-bottom: 1px solid #eee; }
            ul.checklist li:last-child { border-bottom: none; }
            ol li { padding-left: 8px; }
            strong { color: #1e3a5f; }
            @media print { 
              body { margin: 20px; font-size: 11pt; }
              h2 { page-break-after: avoid; }
              ul, ol { page-break-inside: avoid; }
            }
          </style>
        </head>
        <body>
          <h1>${post.title}</h1>
          <div class="meta">
            <strong>BlueCross Medical</strong> | ${new Date(post.published_at ?? post.created_at).toLocaleDateString('en-US', { year: 'numeric', month: 'long', day: 'numeric' })} | ${post.reading_time_minutes} min read
          </div>
          <p><em>${post.excerpt}</em></p>
          <hr>
          ${formattedContent}
          <hr>
          <p style="font-size: 12px; color: #666;">
            © BlueCross Medical - www.bluecross.tech<br>
            This document is for educational purposes. Always consult TMAS for medical emergencies at sea.
          </p>
        </body>
        </html>
      `);
      printWindow.document.close();
      printWindow.print();
    }
  };

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

  // Check if content is HTML (contains HTML tags)
  const isHtmlContent = (content: string) => {
    return /<[a-z][\s\S]*>/i.test(content);
  };

  // Format content with checklist styling for first aiders
  const formatContent = (content: string) => {
    // If content is HTML, render it directly with dangerouslySetInnerHTML
    if (isHtmlContent(content)) {
      // Remove any script tags for security but keep the rest
      const sanitizedContent = content
        .replace(/<script[^>]*>[\s\S]*?<\/script>/gi, '')
        .replace(/tabindex="-1"/g, ''); // Clean up accessibility attributes
      
      return (
        <div 
          className="prose prose-lg max-w-none prose-headings:text-brand-navy prose-a:text-brand-ocean prose-img:rounded-xl prose-img:shadow-lg prose-table:border-collapse prose-th:bg-gray-100 prose-td:border prose-td:p-3 prose-th:border prose-th:p-3"
          dangerouslySetInnerHTML={{ __html: sanitizedContent }}
        />
      );
    }

    // Plain text/markdown processing
    return content
      .split('\n\n')
      .map((paragraph, index) => {
        // Handle links in format [text](url)
        if (paragraph.includes('[') && paragraph.includes('](/')) {
          const linkMatch = paragraph.match(/\[([^\]]+)\]\(([^)]+)\)/);
          if (linkMatch) {
            const [fullMatch, linkText, linkUrl] = linkMatch;
            const beforeLink = paragraph.substring(0, paragraph.indexOf(fullMatch));
            const afterLink = paragraph.substring(paragraph.indexOf(fullMatch) + fullMatch.length);
            return (
              <p key={index} className="text-gray-700 mb-4 leading-relaxed">
                {beforeLink}
                <Link to={linkUrl} className="inline-flex items-center gap-1 text-brand-ocean font-medium hover:underline">
                  {linkText}
                  <ExternalLink size={14} />
                </Link>
                {afterLink}
              </p>
            );
          }
        }
        // Handle CATEGORY headers (collapsible)
        if (/^CATEGORY \d+:/.test(paragraph.trim())) {
          const sectionKey = `section-${index}`;
          const isExpanded = expandedSections[sectionKey] !== false; // Default to expanded
          return (
            <div key={index} className="mb-2">
              <button
                onClick={() => toggleSection(sectionKey)}
                className="w-full flex items-center justify-between p-3 bg-brand-ocean/10 rounded-lg hover:bg-brand-ocean/20 transition-colors"
              >
                <span className="font-bold text-brand-navy">{paragraph}</span>
                {isExpanded ? <ChevronUp size={20} className="text-brand-ocean" /> : <ChevronDown size={20} className="text-brand-ocean" />}
              </button>
            </div>
          );
        }
        // Handle ALL CAPS headers with colon (CHECKLIST: TITLE)
        if (/^[A-Z][A-Z\s:]+$/.test(paragraph.trim()) || /^CHECKLIST:/.test(paragraph.trim())) {
          return (
            <h3 key={index} className="text-lg font-bold text-brand-navy mt-8 mb-4 bg-brand-ocean/5 p-3 rounded-lg border-l-4 border-brand-ocean">
              {paragraph}
            </h3>
          );
        }
        // Handle section headers (ALL CAPS without colon)
        if (/^[A-Z][A-Z\s]+$/.test(paragraph.trim()) && paragraph.length < 60) {
          return (
            <h3 key={index} className="text-lg font-bold text-brand-navy mt-6 mb-3 border-b border-gray-200 pb-2">
              {paragraph}
            </h3>
          );
        }
        // Handle headers with **
        if (paragraph.startsWith('**') && paragraph.endsWith('**')) {
          return (
            <h3 key={index} className="text-lg font-bold text-brand-navy mt-6 mb-3">
              {paragraph.replace(/\*\*/g, '')}
            </h3>
          );
        }
        // Handle checkbox items [ ]
        if (paragraph.includes('[ ]')) {
          const lines = paragraph.split('\n').filter(line => line.trim());
          return (
            <div key={index} className="mb-4 bg-gray-50 p-4 rounded-lg">
              {lines.map((line, i) => {
                if (line.includes('[ ]')) {
                  const text = line.replace('[ ]', '').trim();
                  return (
                    <div key={i} className="flex items-start gap-3 mb-2">
                      <div className="w-5 h-5 border-2 border-gray-400 rounded mt-0.5 flex-shrink-0"></div>
                      <span className="text-gray-700">{text}</span>
                    </div>
                  );
                }
                return <p key={i} className="text-gray-700 mb-2 font-medium">{line}</p>;
              })}
            </div>
          );
        }
        // Handle numbered lists (1. 2. 3. etc)
        if (/^\d+\./.test(paragraph.trim())) {
          const lines = paragraph.split('\n').filter(line => line.trim());
          return (
            <div key={index} className="mb-4 bg-blue-50 p-4 rounded-lg">
              {lines.map((line, i) => {
                const match = line.match(/^(\d+)\.\s*(.+)/);
                if (match) {
                  const [, num, text] = match;
                  const parts = text.split(' - ');
                  return (
                    <div key={i} className="flex gap-3 mb-3">
                      <span className="font-bold text-brand-ocean text-lg min-w-[28px] bg-white rounded-full w-7 h-7 flex items-center justify-center shadow-sm">{num}</span>
                      <p className="text-gray-700 pt-0.5">
                        {parts.length > 1 ? (
                          <>
                            <span className="font-semibold text-brand-navy">{parts[0]}</span> - {parts.slice(1).join(' - ')}
                          </>
                        ) : <span className="font-semibold text-brand-navy">{text}</span>}
                      </p>
                    </div>
                  );
                }
                // Handle sub-items with dash
                if (line.trim().startsWith('-')) {
                  return (
                    <div key={i} className="flex gap-2 mb-1 ml-10">
                      <span className="text-brand-ocean">•</span>
                      <span className="text-gray-700">{line.trim().substring(1).trim()}</span>
                    </div>
                  );
                }
                return <p key={i} className="text-gray-700 ml-10 mb-2">{line}</p>;
              })}
            </div>
          );
        }
        // Handle list items starting with -
        if (paragraph.startsWith('- ') || paragraph.includes('\n- ')) {
          const lines = paragraph.split('\n').filter(line => line.trim());
          return (
            <div key={index} className="mb-4">
              {lines.map((line, i) => {
                if (line.trim().startsWith('-')) {
                  return (
                    <div key={i} className="flex gap-2 mb-2">
                      <span className="text-brand-ocean font-bold">•</span>
                      <span className="text-gray-700">{line.trim().substring(1).trim()}</span>
                    </div>
                  );
                }
                return <p key={i} className="text-gray-700 mb-2 font-medium">{line}</p>;
              })}
            </div>
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
      <SEOHead 
        title={post.title}
        description={post.excerpt}
        url={`/knowledge/${post.slug}`}
        type="article"
        image={post.featured_image_url}
        publishedTime={post.published_at}
        modifiedTime={post.updated_at}
        author={post.author_name}
        section="Maritime Medicine"
        keywords={post.tags}
      />
      
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
              {/* Action Buttons */}
              <div className="flex justify-end gap-2 mb-4">
                {isAdmin && (
                  <Link
                    to={`/admin/edit/${post.slug}`}
                    className="flex items-center gap-2 px-4 py-2 bg-amber-100 text-amber-700 rounded-lg hover:bg-amber-500 hover:text-white transition-colors text-sm font-medium"
                  >
                    <Edit size={16} />
                    Edit Article
                  </Link>
                )}
                <button
                  onClick={handlePrint}
                  className="flex items-center gap-2 px-4 py-2 bg-brand-ocean/10 text-brand-ocean rounded-lg hover:bg-brand-ocean hover:text-white transition-colors text-sm font-medium"
                >
                  <Printer size={16} />
                  Print / Download PDF
                </button>
              </div>
              
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
                {articles
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
