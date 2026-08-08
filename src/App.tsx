/**
 * @fileoverview Main application component with routing configuration.
 * Sets up React Router, context providers, and lazy-loaded page components.
 */
import { lazy, Suspense, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom';
import { Navigation, Footer } from './components/Layout';
import { Analytics } from '@vercel/analytics/react';
import { SpeedInsights } from '@vercel/speed-insights/react';
import { AuthProvider } from './context/AuthContext';
import { ArticleProvider } from './context/ArticleContext';
import './styles/globals.css';

/** Lazy-loaded page components for code splitting and better initial load performance */
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
const BabyLoveGrowthSync = lazy(() => import('./pages/admin/BabyLoveGrowthSync'));

/**
 * Loading spinner displayed while lazy-loaded pages are being fetched.
 */
function PageLoader() {
  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-brand-ocean"></div>
    </div>
  );
}

/** Resets scroll and moves keyboard focus to the new route heading after lazy content resolves. */
function RouteChangeFocus() {
  const { pathname } = useLocation();

  useEffect(() => {
    let observer: MutationObserver | undefined;
    let observerTimeout: number | undefined;
    let focusedHeading: HTMLElement | null = null;

    const focusRouteHeading = () => {
      const heading = document.querySelector<HTMLElement>('#main-content h1');
      if (!heading) return false;
      if (heading === focusedHeading && document.activeElement === heading) return true;

      heading.setAttribute('tabindex', '-1');
      heading.focus({ preventScroll: true });
      focusedHeading = heading;
      return true;
    };

    const animationFrame = window.requestAnimationFrame(() => {
      window.scrollTo({ top: 0, left: 0, behavior: 'auto' });
      const mainContent = document.getElementById('main-content');
      if (!mainContent) return;

      observer = new MutationObserver(focusRouteHeading);
      observer.observe(mainContent, { childList: true, subtree: true });
      focusRouteHeading();
      observerTimeout = window.setTimeout(() => observer?.disconnect(), 5000);
    });

    return () => {
      window.cancelAnimationFrame(animationFrame);
      observer?.disconnect();
      if (observerTimeout) window.clearTimeout(observerTimeout);
    };
  }, [pathname]);

  return null;
}

/**
 * Root application component that sets up routing, providers, and layout.
 * Includes Vercel Analytics and Speed Insights for performance monitoring.
 */
function App() {
  return (
    <Router>
      <AuthProvider>
        <ArticleProvider>
          <div className="flex min-h-screen flex-col bg-white pb-[calc(4rem+env(safe-area-inset-bottom))] md:pb-0">
            <a
              href="#main-content"
              className="sr-only z-50 rounded-lg bg-white px-4 py-3 font-semibold text-brand-navy shadow-lg focus:not-sr-only focus:fixed focus:left-4 focus:top-4"
            >
              Skip to main content
            </a>
            <RouteChangeFocus />
            <Navigation />
            
            <div id="main-content" className="mb-0 flex-1 scroll-mt-20" tabIndex={-1}>
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
                <Route path="/admin/babylovegrowth" element={<BabyLoveGrowthSync />} />
                <Route path="*" element={<NotFound />} />
                </Routes>
              </Suspense>
            </div>

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
