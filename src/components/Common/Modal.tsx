import { useEffect, useCallback } from 'react';
import { X } from 'lucide-react';
import { cn } from '../../lib/utils';

/**
 * Props for the Modal component.
 */
interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  title?: string;
  children: React.ReactNode;
  size?: 'sm' | 'md' | 'lg' | 'xl' | 'full';
  showCloseButton?: boolean;
  closeOnOverlayClick?: boolean;
  closeOnEscape?: boolean;
  className?: string;
}

/**
 * Accessible modal dialog component with overlay backdrop.
 * Supports keyboard navigation (Escape to close), body scroll lock, and animations.
 * @param isOpen - Controls modal visibility
 * @param onClose - Callback when modal should close
 * @param title - Optional header title
 * @param size - Modal width: sm, md, lg, xl, or full
 * @param showCloseButton - Shows X button in header when true
 * @param closeOnOverlayClick - Closes when clicking backdrop when true
 * @param closeOnEscape - Closes on Escape key when true
 */
function Modal({
  isOpen,
  onClose,
  title,
  children,
  size = 'md',
  showCloseButton = true,
  closeOnOverlayClick = true,
  closeOnEscape = true,
  className,
}: ModalProps) {
  // Handle escape key
  const handleEscape = useCallback(
    (event: KeyboardEvent) => {
      if (event.key === 'Escape' && closeOnEscape) {
        onClose();
      }
    },
    [onClose, closeOnEscape]
  );

  useEffect(() => {
    if (isOpen) {
      document.addEventListener('keydown', handleEscape);
      document.body.style.overflow = 'hidden';
    }

    return () => {
      document.removeEventListener('keydown', handleEscape);
      document.body.style.overflow = 'unset';
    };
  }, [isOpen, handleEscape]);

  const sizes = {
    sm: 'max-w-sm',
    md: 'max-w-md',
    lg: 'max-w-lg',
    xl: 'max-w-xl',
    full: 'max-w-[calc(100vw-2rem)] h-[calc(100vh-2rem)]',
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 animate-fade-in">
      {/* Overlay */}
      <div
        className="absolute inset-0 bg-black/50"
        onClick={closeOnOverlayClick ? onClose : undefined}
      />

      {/* Modal content */}
      <div
        className={cn(
          'relative z-10 w-full bg-white rounded-lg shadow-lg animate-slide-up',
          sizes[size],
          size === 'full' ? 'overflow-auto' : '',
          className
        )}
      >
        {/* Header */}
        {(title || showCloseButton) && (
          <div className="flex items-center justify-between p-4 border-b border-gray-100">
            {title && (
              <h2 className="text-h3 font-semibold text-brand-slate">
                {title}
              </h2>
            )}
            {showCloseButton && (
              <button
                onClick={onClose}
                className="p-2 text-brand-gray hover:text-brand-slate hover:bg-gray-100 rounded-md transition-colors"
                aria-label="Close modal"
              >
                <X size={20} />
              </button>
            )}
          </div>
        )}

        {/* Body */}
        <div className={cn('p-4', !title && !showCloseButton && 'pt-0')}>
          {children}
        </div>
      </div>
    </div>
  );
}

export default Modal;
