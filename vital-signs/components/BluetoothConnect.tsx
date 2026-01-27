'use client';

/**
 * Bluetooth Connection UI
 * 
 * Web Bluetooth scanning/pairing interface.
 * Shows browser compatibility message if not supported.
 * Handles user gesture requirement for requestDevice().
 */

import React, { useState, useCallback, useRef, useEffect } from 'react';
import { Bluetooth, AlertTriangle, Monitor } from 'lucide-react';
import { WebBluetoothManager, isWebBluetoothSupported } from '@/lib/bluetooth/web-bluetooth';
import { useVitalsStore } from '@/lib/stores/vitals-store';
import { BLECallbacks } from '@/lib/types';

interface BluetoothConnectProps {
  onDemoMode: () => void;
}

export const BluetoothConnect: React.FC<BluetoothConnectProps> = ({ onDemoMode }) => {
  const [errorMessage, setErrorMessage] = useState<string | null>(null);
  const [isSupported] = useState(() =>
    typeof window !== 'undefined' ? isWebBluetoothSupported() : false
  );
  const bleManagerRef = useRef<WebBluetoothManager | null>(null);

  const {
    connectionStatus,
    setConnectionStatus,
    addECGData,
    setSpO2,
    setBloodPressure,
    setTemperature,
  } = useVitalsStore();

  // Initialize BLE manager
  useEffect(() => {
    const callbacks: BLECallbacks = {
      onECGData: (samples) => addECGData(samples),
      onSpO2Data: (reading) => setSpO2(reading.spo2, reading.heartRate, reading.perfusionIndex),
      onBPData: (reading) => setBloodPressure(reading.systolic, reading.diastolic, reading.pulse),
      onTemperatureData: (reading) => setTemperature(reading.celsius),
      onConnectionChange: (status, deviceName) => setConnectionStatus(status, deviceName),
      onError: (message) => setErrorMessage(message),
    };

    bleManagerRef.current = new WebBluetoothManager(callbacks);

    return () => {
      bleManagerRef.current?.disconnect();
    };
  }, [addECGData, setSpO2, setBloodPressure, setTemperature, setConnectionStatus]);

  const handleConnect = useCallback(async () => {
    setErrorMessage(null);
    if (bleManagerRef.current) {
      await bleManagerRef.current.requestDevice();
    }
  }, []);

  const handleDisconnect = useCallback(() => {
    bleManagerRef.current?.disconnect();
  }, []);

  if (!isSupported) {
    return (
      <div className="flex flex-col items-center justify-center gap-6 p-8 md:p-16 bg-bg-secondary rounded-2xl max-w-lg mx-auto">
        <AlertTriangle size={64} className="text-accent-yellow" />
        <h2 className="text-xl font-semibold text-center">Browser Not Supported</h2>
        <p className="text-gray-400 text-center leading-relaxed">
          Web Bluetooth is required for device connectivity.
          Please use <strong>Google Chrome</strong> or <strong>Microsoft Edge</strong> on a desktop
          or Android device.
        </p>
        <div className="text-sm text-gray-500 text-center">
          iOS Safari does not support Web Bluetooth.
        </div>
        <div className="flex gap-3 mt-4">
          <button
            onClick={onDemoMode}
            className="btn-primary flex items-center gap-2"
          >
            <Monitor size={18} />
            Try Demo Mode
          </button>
        </div>
      </div>
    );
  }

  if (connectionStatus === 'connected') {
    return null; // Don't show when connected — DeviceStatus handles it
  }

  return (
    <div className="flex flex-col items-center justify-center gap-6 p-8 md:p-16 bg-bg-secondary rounded-2xl max-w-lg mx-auto">
      <Bluetooth size={64} className="text-accent-blue" />
      <h2 className="text-xl font-semibold">Connect Your Device</h2>
      <p className="text-gray-400 text-center leading-relaxed">
        Pair your Viatom Checkme Pro, AirBP, or compatible device via Bluetooth.
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
          {connectionStatus === 'scanning'
            ? 'Scanning...'
            : connectionStatus === 'connecting'
            ? 'Connecting...'
            : 'Scan for Devices'}
        </button>

        <button
          onClick={onDemoMode}
          className="btn-outline flex items-center justify-center gap-2"
        >
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
