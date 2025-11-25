import { Link, useLocation } from 'react-router-dom';
import { Menu, X } from 'lucide-react';
import { useState, useEffect } from 'react';
import { useIsScrolled, useIsMobile } from '../../hooks';
import { NAV_ITEMS } from '../../lib/constants';
import { cn } from '../../lib/utils';
import Container from '../Common/Container';

function Header() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const isScrolled = useIsScrolled(50);
  const isMobile = useIsMobile();
  const location = useLocation();
  
  // Pages with dark hero sections (white text needed)
  const darkHeroPages = ['/', '/products', '/blog', '/flags', '/tech', '/team', '/about', '/training', '/knowledge', '/contact'];
  const hasDarkHero = darkHeroPages.includes(location.pathname) || location.pathname.startsWith('/products/') || location.pathname.startsWith('/flags/') || location.pathname.startsWith('/blog/');
  
  // Use dark text when scrolled OR when on a page without dark hero
  const useDarkText = isScrolled || !hasDarkHero;

  // Close mobile menu on route change
  useEffect(() => {
    // eslint-disable-next-line react-hooks/set-state-in-effect
    setIsMenuOpen(false);
  }, [location.pathname]);

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
          <Link to="/" className="flex items-center space-x-2">
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
          {!isMobile && (
            <nav className="hidden md:flex items-center space-x-8">
              {NAV_ITEMS.map((item) => (
                <Link
                  key={item.path}
                  to={item.path}
                  className={cn(
                    "relative font-medium transition-all duration-200 py-1",
                    "after:absolute after:bottom-0 after:left-0 after:w-0 after:h-0.5 after:bg-brand-ocean after:transition-all after:duration-300",
                    "hover:after:w-full",
                    useDarkText 
                      ? "text-brand-slate hover:text-brand-ocean" 
                      : "text-white/90 hover:text-white"
                  )}
                >
                  {item.label}
                </Link>
              ))}
            </nav>
          )}

          {/* Mobile Menu Button */}
          {isMobile && (
            <button
              onClick={() => setIsMenuOpen(!isMenuOpen)}
              className={cn(
                "p-2 transition-colors",
                useDarkText ? "text-brand-slate hover:text-brand-ocean" : "text-white hover:text-brand-sky"
              )}
              aria-label="Toggle menu"
            >
              {isMenuOpen ? <X size={24} /> : <Menu size={24} />}
            </button>
          )}
        </div>
      </Container>

      {/* Mobile Menu */}
      {isMenuOpen && (
        <div className="md:hidden bg-white border-t border-gray-100 shadow-lg">
          <nav className="py-4">
            {NAV_ITEMS.map((item) => (
              <Link
                key={item.path}
                to={item.path}
                onClick={() => setIsMenuOpen(false)}
                className="block px-4 py-3 text-brand-slate hover:bg-surface-secondary hover:text-brand-ocean transition-colors"
              >
                {item.label}
              </Link>
            ))}
          </nav>
        </div>
      )}
    </header>
  );
}

export default Header;
