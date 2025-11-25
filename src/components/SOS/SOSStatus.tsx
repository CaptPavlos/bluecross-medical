import { AlertCircle, CheckCircle, Clock } from 'lucide-react';
import { cn } from '../../lib/utils';

type SOSStatusType = 'pending' | 'escalated' | 'resolved';

interface SOSStatusProps {
  status: SOSStatusType;
  timestamp?: string;
  className?: string;
}

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
