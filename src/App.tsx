import { lazy, Suspense } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Navigation, Footer } from './components/Layout';
import { Analytics } from '@vercel/analytics/react';
import { SpeedInsights } from '@vercel/speed-insights/react';
import { AuthProvider } from './context/AuthContext';
import { ArticleProvider } from './context/ArticleContext';
import './styles/globals.css';

// Lazy load pages for code splitting
const Home = lazy(() => import('./pages/Home'));
const Products = lazy(() => import('./pages/Products'));
const ProductDetail = lazy(() => import('./pages/ProductDetail'));
const Tech = lazy(() => import('./pages/Tech'));
const Team = lazy(() => import('./pages/Team'));
const About = lazy(() => import('./pages/About'));
const Training = lazy(() => import('./pages/Training'));
const Knowledge = lazy(() => import('./pages/Knowledge'));
const BlogDetail = lazy(() => import('./pages/BlogDetail'));
const FlagDatabase = lazy(() => import('./pages/FlagDatabase'));
const FlagDetail = lazy(() => import('./pages/FlagDetail'));
const Contact = lazy(() => import('./pages/Contact'));
const NotFound = lazy(() => import('./pages/NotFound'));
const PrivacyPolicy = lazy(() => import('./pages/PrivacyPolicy'));
const TermsOfService = lazy(() => import('./pages/TermsOfService'));
const HipaaCompliance = lazy(() => import('./pages/HipaaCompliance'));
const AdminLogin = lazy(() => import('./pages/AdminLogin'));
const AdminPanel = lazy(() => import('./pages/AdminPanel'));
const AdminEditArticle = lazy(() => import('./pages/AdminEditArticle'));

// Loading fallback
function PageLoader() {
  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-brand-ocean"></div>
    </div>
  );
}

function App() {
  return (
    <Router>
      <AuthProvider>
        <ArticleProvider>
          <div className="flex flex-col min-h-screen bg-white">
            <Navigation />
            
            <main className="flex-1 mb-0">
              <Suspense fallback={<PageLoader />}>
                <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/products" element={<Products />} />
                <Route path="/products/:slug" element={<ProductDetail />} />
                <Route path="/tech" element={<Tech />} />
                <Route path="/team" element={<Team />} />
                <Route path="/about" element={<About />} />
                <Route path="/training" element={<Training />} />
                <Route path="/knowledge" element={<Knowledge />} />
                <Route path="/knowledge/:slug" element={<BlogDetail />} />
                <Route path="/blog" element={<Knowledge />} />
                <Route path="/blog/:slug" element={<BlogDetail />} />
                <Route path="/flags" element={<FlagDatabase />} />
                <Route path="/flags/:slug" element={<FlagDetail />} />
                <Route path="/contact" element={<Contact />} />
                <Route path="/privacy" element={<PrivacyPolicy />} />
                <Route path="/terms" element={<TermsOfService />} />
                <Route path="/hipaa" element={<HipaaCompliance />} />
                <Route path="/admin/login" element={<AdminLogin />} />
                <Route path="/admin" element={<AdminPanel />} />
                <Route path="/admin/edit/:slug" element={<AdminEditArticle />} />
                <Route path="*" element={<NotFound />} />
                </Routes>
              </Suspense>
            </main>

            <Footer />
            <Analytics />
            <SpeedInsights />
          </div>
        </ArticleProvider>
      </AuthProvider>
    </Router>
  );
}

export default App;
