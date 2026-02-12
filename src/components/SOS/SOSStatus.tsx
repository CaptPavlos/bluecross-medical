import { AlertCircle, CheckCircle, Clock } from 'lucide-react';
import { cn } from '../../lib/utils';

/** Possible states for an SOS alert */
type SOSStatusType = 'pending' | 'escalated' | 'resolved';

/**
 * Props for the SOSStatus component.
 */
interface SOSStatusProps {
  status: SOSStatusType;
  timestamp?: string;
  className?: string;
}

/** Visual configuration for each status type */
const statusConfig = {
  pending: {
    icon: Clock,
    label: 'Pending Response',
    color: 'text-brand-yellow',
    bg: 'bg-brand-yellow/10',
  },
  escalated: {
    icon: AlertCircle,
    label: 'Escalated',
    color: 'text-brand-red',
    bg: 'bg-brand-red/10',
  },
  resolved: {
    icon: CheckCircle,
    label: 'Resolved',
    color: 'text-brand-green',
    bg: 'bg-brand-green/10',
  },
};

/**
 * Status indicator component for SOS alert tracking.
 * Displays icon and label based on current alert status.
 * @param status - Current SOS status: pending, escalated, or resolved
 * @param timestamp - Optional timestamp string to display
 * @param className - Additional CSS classes
 */
function SOSStatus({ status, timestamp, className }: SOSStatusProps) {
  const config = statusConfig[status];
  const Icon = config.icon;

  return (
    <div className={cn('flex items-center space-x-3', className)}>
      <div className={cn('p-2 rounded-full', config.bg)}>
        <Icon className={cn('w-5 h-5', config.color)} />
      </div>
      <div>
        <p className={cn('font-medium', config.color)}>{config.label}</p>
        {timestamp && (
          <p className="text-sm text-brand-gray">{timestamp}</p>
        )}
      </div>
    </div>
  );
}

export default SOSStatus;
