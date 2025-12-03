import { useNavigate, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { LogOut, FileText, Edit, Image, Clock, Shield, RefreshCw } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { useAuth } from '../context/AuthContext';
import { useArticles } from '../context/ArticleContext';

function AdminPanel() {
  const { isAdmin, logout } = useAuth();
  const { articles } = useArticles();
  const navigate = useNavigate();

  // Redirect if not admin
  if (!isAdmin) {
    navigate('/admin/login');
    return null;
  }

  const handleLogout = () => {
    logout();
    navigate('/');
  };

  return (
    <main className="flex-1">
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div 
            className="flex flex-col md:flex-row md:items-center md:justify-between gap-4"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
          >
            <div>
              <div className="flex items-center gap-3 mb-2">
                <Shield className="w-8 h-8 text-brand-ocean" />
                <h1 className="text-3xl md:text-4xl font-bold text-white">
                  Admin Panel
                </h1>
              </div>
              <p className="text-brand-sky-light">
                Manage knowledge articles and content
              </p>
            </div>
            <Button
              variant="outline"
              className="border-white text-white hover:bg-white hover:text-brand-navy"
              onClick={handleLogout}
              leftIcon={<LogOut size={18} />}
            >
              Logout
            </Button>
          </motion.div>
        </Container>
      </section>

      <section className="py-12 md:py-16 bg-gray-50">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.2 }}
          >
            <div className="flex items-center justify-between mb-6">
              <h2 className="text-xl font-bold text-brand-navy flex items-center gap-2">
                <FileText className="w-5 h-5" />
                Knowledge Articles ({articles.length})
              </h2>
              <Link to="/admin/babylovegrowth">
                <Button
                  variant="outline"
                  leftIcon={<RefreshCw size={16} />}
                >
                  BabyLoveGrowth Sync
                </Button>
              </Link>
            </div>

            <div className="bg-white rounded-xl shadow-sm overflow-hidden">
              <div className="overflow-x-auto">
                <table className="w-full">
                  <thead className="bg-gray-50 border-b border-gray-200">
                    <tr>
                      <th className="px-6 py-4 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                        Article
                      </th>
                      <th className="px-6 py-4 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider hidden md:table-cell">
                        <Image className="w-4 h-4 inline mr-1" />
                        Image
                      </th>
                      <th className="px-6 py-4 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider hidden lg:table-cell">
                        <Clock className="w-4 h-4 inline mr-1" />
                        Updated
                      </th>
                      <th className="px-6 py-4 text-right text-xs font-semibold text-gray-600 uppercase tracking-wider">
                        Actions
                      </th>
                    </tr>
                  </thead>
                  <tbody className="divide-y divide-gray-200">
                    {articles.map((article, index) => (
                      <motion.tr
                        key={article.id}
                        initial={{ opacity: 0, y: 10 }}
                        animate={{ opacity: 1, y: 0 }}
                        transition={{ delay: index * 0.05 }}
                        className="hover:bg-gray-50 transition-colors"
                      >
                        <td className="px-6 py-4">
                          <div>
                            <p className="font-medium text-brand-navy line-clamp-1">
                              {article.title}
                            </p>
                            <p className="text-sm text-gray-500 line-clamp-1">
                              {article.excerpt}
                            </p>
                          </div>
                        </td>
                        <td className="px-6 py-4 hidden md:table-cell">
                          <div className="w-16 h-12 rounded overflow-hidden bg-gray-100">
                            <img 
                              src={article.featured_image_url} 
                              alt="" 
                              className="w-full h-full object-cover"
                            />
                          </div>
                        </td>
                        <td className="px-6 py-4 hidden lg:table-cell">
                          <span className="text-sm text-gray-500">
                            {new Date(article.updated_at).toLocaleDateString()}
                          </span>
                        </td>
                        <td className="px-6 py-4 text-right">
                          <Link to={`/admin/edit/${article.slug}`}>
                            <Button
                              size="sm"
                              variant="outline"
                              leftIcon={<Edit size={14} />}
                            >
                              Edit
                            </Button>
                          </Link>
                        </td>
                      </motion.tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default AdminPanel;
