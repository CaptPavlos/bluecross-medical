import { Link, useLocation } from 'react-router-dom';
import { ShoppingCart, AlertCircle } from 'lucide-react';
import { useState, useEffect } from 'react';
import { useIsScrolled, useIsMobile } from '../../hooks';
import { NAV_ITEMS } from '../../lib/constants';
import { cn } from '../../lib/utils';
import Container from '../Common/Container';

// Ecwid type declarations
declare global {
  interface Window {
    Ecwid?: {
      Cart?: {
        get: (callback: (cart: { productsQuantity?: number }) => void) => void;
      };
      OnCartChanged?: {
        add: (callback: (cart: { productsQuantity?: number }) => void) => void;
      };
      OnAPILoaded?: {
        add: (callback: () => void) => void;
      };
      openPage: (page: string) => void;
    };
  }
}

function Header() {
  const [cartCount, setCartCount] = useState(0);
  const isScrolled = useIsScrolled(50);
  const isMobile = useIsMobile();
  const location = useLocation();
  
  // Pages with dark hero sections (white text needed)
  const darkHeroPages = ['/', '/products', '/blog', '/flags', '/tech', '/team', '/about', '/training', '/knowledge', '/contact', '/privacy', '/terms', '/hipaa'];
  const hasDarkHero = darkHeroPages.includes(location.pathname) || location.pathname.startsWith('/products/') || location.pathname.startsWith('/flags/') || location.pathname.startsWith('/blog/');
  
  // Use dark text when scrolled OR when on a page without dark hero
  const useDarkText = isScrolled || !hasDarkHero;

  // Listen for Ecwid cart changes
  useEffect(() => {
    const updateCartCount = () => {
      if (typeof window !== 'undefined' && window.Ecwid?.Cart) {
        window.Ecwid.Cart.get((cart: { productsQuantity?: number }) => {
          setCartCount(cart?.productsQuantity || 0);
        });
      }
    };

    // Initial check
    updateCartCount();

    // Listen for cart changes
    if (typeof window !== 'undefined' && window.Ecwid?.OnCartChanged) {
      window.Ecwid.OnCartChanged.add((cart: { productsQuantity?: number }) => {
        setCartCount(cart?.productsQuantity || 0);
      });
    }

    // Also check when Ecwid API loads
    if (typeof window !== 'undefined' && window.Ecwid?.OnAPILoaded) {
      window.Ecwid.OnAPILoaded.add(updateCartCount);
    }
  }, []);

  const handleCartClick = () => {
    if (typeof window !== 'undefined' && window.Ecwid) {
      window.Ecwid.openPage('cart');
    }
  };

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

          {/* Right side buttons */}
          <div className="flex items-center space-x-3">
            {/* SOS Emergency Button */}
            <a
              href="https://www.globalsarhub.com/sea-sar.html"
              target="_blank"
              rel="noopener noreferrer"
              className="flex items-center space-x-1.5 px-3 py-1.5 bg-red-600 hover:bg-red-700 text-white font-bold text-sm rounded-lg transition-all duration-200 shadow-md hover:shadow-lg animate-pulse hover:animate-none"
              aria-label="SOS Emergency - Global SAR Hub"
            >
              <AlertCircle size={18} />
              <span>SOS</span>
            </a>

            {/* Shopping Cart - shows when cart has items */}
            {cartCount > 0 && (
              <button
                onClick={handleCartClick}
                className={cn(
                  "relative p-2 transition-colors",
                  useDarkText ? "text-brand-slate hover:text-brand-ocean" : "text-white hover:text-brand-sky"
                )}
                aria-label={`Shopping cart with ${cartCount} items`}
              >
                <ShoppingCart size={24} />
                <span className="absolute -top-1 -right-1 w-5 h-5 bg-brand-ocean text-white text-xs font-bold rounded-full flex items-center justify-center">
                  {cartCount > 9 ? '9+' : cartCount}
                </span>
              </button>
            )}
          </div>
        </div>
      </Container>
    </header>
  );
}

export default Header;
