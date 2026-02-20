import { Link, useLocation } from 'react-router-dom';
import { Flag, GraduationCap, BookOpen, Package, Mail } from 'lucide-react';
import { cn } from '../../lib/utils';

/** Navigation items for mobile bottom bar with icons and labels */
const navItems = [
  { label: 'Regs', path: '/flags', icon: Flag },
  { label: 'Train', path: '/training', icon: GraduationCap },
  { label: 'Read', path: '/knowledge', icon: BookOpen },
  { label: 'Kit', path: '/products', icon: Package },
  { label: 'Contact', path: '/contact', icon: Mail },
];

/**
 * Fixed bottom navigation bar for mobile devices.
 * Shows icon tabs with active state highlighting based on current route.
 * Hidden on desktop viewports (md breakpoint and up).
 */
function MobileNav() {
  const location = useLocation();

  return (
    <nav className="md:hidden fixed bottom-0 left-0 right-0 z-40 bg-white border-t border-gray-200 pb-safe-bottom">
      <div className="flex items-center justify-around h-14">
        {navItems.map((item) => {
          const isActive = location.pathname === item.path || 
            (item.path !== '/' && location.pathname.startsWith(item.path));
          const Icon = item.icon;

          return (
            <Link
              key={item.path}
              to={item.path}
              className={cn(
                'flex flex-col items-center justify-center flex-1 py-2 transition-colors',
                isActive ? 'text-brand-ocean' : 'text-gray-500'
              )}
            >
              <Icon className="w-5 h-5 mb-0.5" />
              <span className="text-[10px] font-medium">{item.label}</span>
            </Link>
          );
        })}
      </div>
    </nav>
  );
}

export default MobileNav;
