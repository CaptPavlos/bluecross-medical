'use client';

/**
 * Device Connection Status Component
 * 
 * Ported from Electron app DeviceStatus.tsx
 * Shows connection state, device name, disconnect button
 */

import React from 'react';
import { Bluetooth, BluetoothOff, Loader2 } from 'lucide-react';
import { ConnectionStatus } from '@/lib/types';

interface DeviceStatusProps {
  status: ConnectionStatus;
  deviceName?: string;
  onDisconnect: () => void;
}

const statusConfig: Record<ConnectionStatus, { label: string; dotColor: string }> = {
  disconnected: { label: 'Not Connected', dotColor: 'bg-accent-red' },
  scanning: { label: 'Scanning...', dotColor: 'bg-accent-yellow' },
  connecting: { label: 'Connecting...', dotColor: 'bg-accent-yellow' },
  connected: { label: 'Connected', dotColor: 'bg-accent-green' },
  reconnecting: { label: 'Reconnecting...', dotColor: 'bg-accent-yellow' },
  error: { label: 'Connection Error', dotColor: 'bg-accent-red' },
};

export const DeviceStatus: React.FC<DeviceStatusProps> = ({
  status,
  deviceName,
  onDisconnect,
}) => {
  const config = statusConfig[status];
  const isLoading = status === 'scanning' || status === 'connecting' || status === 'reconnecting';
  const isConnected = status === 'connected';

  return (
    <div className={`
      flex items-center gap-3 px-4 py-2 rounded-full
      ${isConnected ? 'bg-bg-card' : 'bg-bg-card/70'}
    `}>
      {/* Status icon */}
      {isLoading ? (
        <Loader2 size={16} className="animate-spin text-accent-yellow" />
      ) : isConnected ? (
        <Bluetooth size={16} className="text-accent-green" />
      ) : (
        <BluetoothOff size={16} className="text-accent-red" />
      )}

      {/* Status dot */}
      <div className={`w-2.5 h-2.5 rounded-full ${config.dotColor} ${isConnected ? 'animate-blink' : ''}`} />

      {/* Status text */}
      <span className="text-sm">
        {isConnected && deviceName ? `${deviceName}` : config.label}
      </span>

      {/* Disconnect button */}
      {isConnected && (
        <button
          onClick={onDisconnect}
          className="px-3 py-1 text-xs border border-accent-red text-accent-red rounded hover:bg-accent-red/20 transition-colors"
        >
          Disconnect
        </button>
      )}
    </div>
  );
};
