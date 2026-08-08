import { Link, useLocation } from 'react-router-dom';
import { AlertCircle } from 'lucide-react';
import { useIsScrolled } from '../../hooks';
import { NAV_ITEMS } from '../../lib/constants';
import { cn } from '../../lib/utils';
import Container from '../Common/Container';

/**
 * Fixed header component with navigation links and emergency access.
 * Adapts styling based on scroll position and current page.
 * Uses transparent background on dark hero pages, white when scrolled.
 */
function Header() {
  const isScrolled = useIsScrolled(50);
  const location = useLocation();
  
  // Pages with dark hero sections (white text needed)
  const darkHeroPages = ['/', '/products', '/blog', '/flags', '/tech', '/team', '/about', '/training', '/knowledge', '/contact', '/privacy', '/terms', '/hipaa'];
  const hasDarkHero = darkHeroPages.includes(location.pathname) || location.pathname.startsWith('/products/') || location.pathname.startsWith('/flags/') || location.pathname.startsWith('/blog/');
  
  // Use dark text when scrolled OR when on a page without dark hero
  const useDarkText = isScrolled || !hasDarkHero;

  return (
    <header
      className={cn(
        'fixed top-0 left-0 right-0 z-40 transition-all duration-200',
        isScrolled
          ? 'bg-white/95 backdrop-blur-sm shadow-sm'
          : 'bg-transparent'
      )}
    >
      <Container>
        <div className="flex items-center justify-between h-16 md:h-20">
          {/* Logo - B+ Medical */}
          <Link to="/" className="flex min-h-[44px] items-center space-x-2" aria-label="BlueCross Medical home">
            <div className="w-10 h-10 bg-brand-ocean rounded-lg flex items-center justify-center">
              <span className="text-white font-bold text-xl">B+</span>
            </div>
            <span className={cn(
              "font-bold text-lg md:text-xl transition-colors",
              useDarkText ? "text-brand-navy" : "text-white"
            )}>
              Medical
            </span>
          </Link>

          {/* Desktop Navigation */}
          <nav className="hidden items-center space-x-8 md:flex" aria-label="Primary navigation">
              {NAV_ITEMS.map((item) => {
                const isActive = location.pathname === item.path
                  || (item.path !== '/' && location.pathname.startsWith(`${item.path}/`));

                return (
                  <Link
                    key={item.path}
                    to={item.path}
                    aria-current={isActive ? 'page' : undefined}
                    className={cn(
                      'relative py-1 font-medium transition-all duration-200',
                      'after:absolute after:bottom-0 after:left-0 after:h-0.5 after:w-0 after:bg-brand-ocean after:transition-all after:duration-300',
                      'hover:after:w-full',
                      isActive && 'after:w-full',
                      useDarkText
                        ? 'text-brand-slate hover:text-brand-ocean'
                        : 'text-white/90 hover:text-white'
                    )}
                  >
                    {item.label}
                  </Link>
                );
              })}
          </nav>

          {/* Right side buttons */}
          <div className="flex items-center">
            {/* SOS Emergency Button */}
            <a
              href="https://www.globalsarhub.com/sea-sar.html"
              target="_blank"
              rel="noopener noreferrer"
              className="flex min-h-[44px] items-center space-x-1.5 rounded-lg bg-red-600 px-3 py-2 text-sm font-bold text-white shadow-md transition-all duration-200 hover:bg-red-700 hover:shadow-lg"
              aria-label="SOS Emergency - Global SAR Hub"
            >
              <AlertCircle size={18} />
              <span>SOS</span>
            </a>

          </div>
        </div>
      </Container>
    </header>
  );
}

export default Header;
