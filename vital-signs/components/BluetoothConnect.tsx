'use client';

/**
 * Bluetooth Connection UI
 * 
 * Web Bluetooth scanning/pairing interface.
 * Shows browser compatibility message if not supported.
 * Handles user gesture requirement for requestDevice().
 */

import React, { useState, useCallback, useRef, useEffect } from 'react';
import { Bluetooth, AlertTriangle, Monitor, Loader2 } from 'lucide-react';
import { WebBluetoothManager, isWebBluetoothSupported } from '@/lib/bluetooth/web-bluetooth';
import { useVitalsStore } from '@/lib/stores/vitals-store';
import { BLECallbacks } from '@/lib/types';

interface BluetoothConnectProps {
  onDemoMode: () => void;
  bleManagerRef?: React.MutableRefObject<WebBluetoothManager | null>;
}

export const BluetoothConnect: React.FC<BluetoothConnectProps> = ({ onDemoMode, bleManagerRef }) => {
  const [errorMessage, setErrorMessage] = useState<string | null>(null);
  const [isSupported, setIsSupported] = useState<boolean | null>(null);
  const internalRef = useRef<WebBluetoothManager | null>(null);
  const managerRef = bleManagerRef || internalRef;

  useEffect(() => {
    setIsSupported(isWebBluetoothSupported());
  }, []);

  const {
    connectionStatus,
    setConnectionStatus,
    setDeviceInfo,
    setStoredRecords,
    addECGData,
    setSpO2,
    setBloodPressure,
    setTemperature,
  } = useVitalsStore();

  useEffect(() => {
    const callbacks: BLECallbacks = {
      onECGData: (samples) => addECGData(samples),
      onSpO2Data: (reading) => setSpO2(reading.spo2, reading.heartRate, reading.perfusionIndex),
      onBPData: (reading) => setBloodPressure(reading.systolic, reading.diastolic, reading.pulse),
      onTemperatureData: (reading) => setTemperature(reading.celsius),
      onConnectionChange: (status, deviceName) => setConnectionStatus(status, deviceName),
      onDeviceInfo: (info) => setDeviceInfo(info),
      onStoredData: (records) => setStoredRecords(records),
      onError: (message) => setErrorMessage(message),
    };

    managerRef.current = new WebBluetoothManager(callbacks);

    return () => {
      managerRef.current?.disconnect();
    };
  }, [addECGData, setSpO2, setBloodPressure, setTemperature, setConnectionStatus, setDeviceInfo, setStoredRecords, managerRef]);

  const handleConnect = useCallback(async () => {
    setErrorMessage(null);
    if (managerRef.current) {
      await managerRef.current.requestDevice();
    }
  }, [managerRef]);

  const handleDisconnect = useCallback(() => {
    managerRef.current?.disconnect();
  }, [managerRef]);

  if (isSupported === null) {
    return (
      <div className="flex flex-col items-center justify-center gap-6 p-8 md:p-16 bg-bg-secondary rounded-2xl max-w-lg mx-auto">
        <Loader2 size={64} className="text-accent-blue animate-spin" />
        <h2 className="text-xl font-semibold text-center">Checking browser support...</h2>
      </div>
    );
  }

  if (!isSupported) {
    return (
      <div className="flex flex-col items-center justify-center gap-6 p-8 md:p-16 bg-bg-secondary rounded-2xl max-w-lg mx-auto">
        <AlertTriangle size={64} className="text-accent-yellow" />
        <h2 className="text-xl font-semibold text-center">Browser Not Supported</h2>
        <p className="text-gray-400 text-center leading-relaxed">
          Web Bluetooth is required. Use <strong>Google Chrome</strong> or <strong>Microsoft Edge</strong> on desktop or Android.
        </p>
        <div className="flex gap-3 mt-4">
          <button onClick={onDemoMode} className="btn-primary flex items-center gap-2">
            <Monitor size={18} />
            Try Demo Mode
          </button>
        </div>
      </div>
    );
  }

  if (connectionStatus === 'connected') {
    return null;
  }

  return (
    <div className="flex flex-col items-center justify-center gap-6 p-8 md:p-16 bg-bg-secondary rounded-2xl max-w-lg mx-auto">
      <Bluetooth size={64} className="text-accent-blue" />
      <h2 className="text-xl font-semibold">Connect Your Device</h2>
      <p className="text-gray-400 text-center leading-relaxed">
        Pair your Viatom Checkme Pro or compatible device via Bluetooth.
      </p>

      {errorMessage && (
        <div className="w-full p-3 bg-accent-red/10 border border-accent-red/30 rounded-lg text-accent-red text-sm text-center">
          {errorMessage}
        </div>
      )}

      <div className="flex flex-col sm:flex-row gap-3 w-full sm:w-auto">
        <button
          onClick={handleConnect}
          disabled={connectionStatus === 'scanning' || connectionStatus === 'connecting'}
          className="btn-primary flex items-center justify-center gap-2 text-lg px-8 py-3"
        >
          <Bluetooth size={20} />
          {connectionStatus === 'scanning' ? 'Scanning...'
            : connectionStatus === 'connecting' ? 'Connecting...'
            : connectionStatus === 'reconnecting' ? 'Reconnecting...'
            : 'Scan for Devices'}
        </button>

        <button onClick={onDemoMode} className="btn-outline flex items-center justify-center gap-2">
          <Monitor size={18} />
          Demo Mode
        </button>
      </div>

      <div className="text-xs text-gray-500 text-center mt-2">
        Requires HTTPS • Chrome or Edge • User interaction to pair
      </div>
    </div>
  );
};
