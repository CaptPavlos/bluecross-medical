import { Link, useLocation } from 'react-router-dom';
import { Flag, GraduationCap, BookOpen, Package, Mail } from 'lucide-react';
import { cn } from '../../lib/utils';

/** Navigation items for mobile bottom bar with icons and labels */
const navItems = [
  { label: 'Flags', accessibleLabel: 'Flag regulations', path: '/flags', icon: Flag },
  { label: 'Training', accessibleLabel: 'Medical training', path: '/training', icon: GraduationCap },
  { label: 'Knowledge', accessibleLabel: 'Medical knowledge', path: '/knowledge', icon: BookOpen },
  { label: 'Equipment', accessibleLabel: 'Medical equipment', path: '/products', icon: Package },
  { label: 'Contact', accessibleLabel: 'Contact BlueCross Medical', path: '/contact', icon: Mail },
];

/**
 * Fixed bottom navigation bar for mobile devices.
 * Shows icon tabs with active state highlighting based on current route.
 * Hidden on desktop viewports (md breakpoint and up).
 */
function MobileNav() {
  const location = useLocation();

  return (
    <nav
      className="fixed inset-x-0 bottom-0 z-40 border-t border-gray-200 bg-white/95 shadow-[0_-4px_16px_rgba(15,23,42,0.08)] backdrop-blur-sm lg:hidden"
      aria-label="Primary mobile navigation"
      style={{ paddingBottom: 'env(safe-area-inset-bottom)' }}
    >
      <div className="flex h-16 items-stretch justify-around px-1">
        {navItems.map((item) => {
          const isActive = location.pathname === item.path || 
            (item.path !== '/' && location.pathname.startsWith(item.path));
          const Icon = item.icon;

          return (
            <Link
              key={item.path}
              to={item.path}
              aria-label={item.accessibleLabel}
              aria-current={isActive ? 'page' : undefined}
              className={cn(
                'flex min-h-[44px] min-w-0 flex-1 flex-col items-center justify-center px-0.5 py-2 transition-colors',
                isActive ? 'text-brand-ocean' : 'text-gray-500'
              )}
            >
              <Icon className="mb-1 h-5 w-5" aria-hidden="true" />
              <span className="max-w-full whitespace-nowrap text-[10px] font-medium leading-none">{item.label}</span>
            </Link>
          );
        })}
      </div>
    </nav>
  );
}

export default MobileNav;
