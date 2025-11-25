import { AlertCircle } from 'lucide-react';
import { cn } from '../../lib/utils';

interface SOSButtonProps {
  onClick: () => void;
  size?: 'sm' | 'md' | 'lg';
  className?: string;
}

function SOSButton({ onClick, size = 'md', className }: SOSButtonProps) {
  const sizes = {
    sm: 'w-12 h-12',
    md: 'w-16 h-16',
    lg: 'w-20 h-20',
  };

  const iconSizes = {
    sm: 20,
    md: 28,
    lg: 36,
  };

  return (
    <button
      onClick={onClick}
      className={cn(
        'relative flex items-center justify-center rounded-full bg-brand-red text-white shadow-lg focus:outline-none focus:ring-4 focus:ring-brand-red/50 transition-transform hover:scale-105 active:scale-95',
        sizes[size],
        className
      )}
      aria-label="Emergency SOS"
    >
      {/* Pulsing ring animation */}
      <span className="absolute inset-0 rounded-full bg-brand-red animate-ping opacity-25" />
      <AlertCircle size={iconSizes[size]} />
    </button>
  );
}

export default SOSButton;
