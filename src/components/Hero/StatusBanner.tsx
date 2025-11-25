import { useEffect, useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { CheckCircle, AlertTriangle, WrenchIcon, X } from 'lucide-react';
import { getSystemStatus } from '../../lib/api/status';
import type { SystemStatus } from '../../lib/types';
import { cn } from '../../lib/utils';

function StatusBanner() {
  const [status, setStatus] = useState<SystemStatus | null>(null);
  const [isVisible, setIsVisible] = useState(true);

  useEffect(() => {
    const fetchStatus = async () => {
      const data = await getSystemStatus();
      setStatus(data);
    };
    fetchStatus();
  }, []);

  if (!status || !isVisible) return null;

  const statusConfig = {
    operational: {
      icon: CheckCircle,
      bg: 'bg-brand-green',
      text: 'All Systems Operational',
    },
    degraded: {
      icon: AlertTriangle,
      bg: 'bg-brand-yellow',
      text: 'Performance Issues',
    },
    maintenance: {
      icon: WrenchIcon,
      bg: 'bg-brand-red',
      text: 'Scheduled Maintenance',
    },
  };

  const config = statusConfig[status.status];
  const Icon = config.icon;

  return (
    <AnimatePresence>
      <motion.div
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        exit={{ opacity: 0, y: -20 }}
        className={cn('relative', config.bg)}
      >
        <div className="max-w-7xl mx-auto px-4 py-2 flex items-center justify-center text-white text-sm">
          <Icon size={16} className="mr-2" />
          <span className="font-medium">{config.text}</span>
          {status.message && (
            <span className="hidden sm:inline ml-2">— {status.message}</span>
          )}
          <button
            onClick={() => setIsVisible(false)}
            className="absolute right-4 p-1 hover:bg-white/20 rounded-full transition-colors"
            aria-label="Dismiss"
          >
            <X size={14} />
          </button>
        </div>
      </motion.div>
    </AnimatePresence>
  );
}

export default StatusBanner;
