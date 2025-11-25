import { Link, useLocation } from 'react-router-dom';
import { Home, Package, AlertCircle, FileText, Menu } from 'lucide-react';
import { cn } from '../../lib/utils';

const navItems = [
  { label: 'Home', path: '/', icon: Home },
  { label: 'Products', path: '/products', icon: Package },
  { label: 'SOS', path: '#sos', icon: AlertCircle, isEmergency: true },
  { label: 'Blog', path: '/blog', icon: FileText },
  { label: 'More', path: '/contact', icon: Menu },
];

interface MobileNavProps {
  onSOSClick?: () => void;
}

function MobileNav({ onSOSClick }: MobileNavProps) {
  const location = useLocation();

  return (
    <nav className="md:hidden fixed bottom-0 left-0 right-0 z-40 bg-white border-t border-gray-200 pb-safe-bottom">
      <div className="flex items-center justify-around h-16">
        {navItems.map((item) => {
          const isActive = location.pathname === item.path;
          const Icon = item.icon;

          if (item.isEmergency) {
            return (
              <button
                key={item.path}
                onClick={onSOSClick}
                className="flex flex-col items-center justify-center w-14 h-14 -mt-6 bg-brand-red rounded-full shadow-lg"
                aria-label="Emergency SOS"
              >
                <Icon className="w-6 h-6 text-white" />
              </button>
            );
          }

          return (
            <Link
              key={item.path}
              to={item.path}
              className={cn(
                'flex flex-col items-center justify-center flex-1 py-2 transition-colors min-w-[64px]',
                isActive ? 'text-brand-ocean' : 'text-brand-gray'
              )}
            >
              <Icon className="w-5 h-5 mb-1" />
              <span className="text-xs font-medium">{item.label}</span>
            </Link>
          );
        })}
      </div>
    </nav>
  );
}

export default MobileNav;
