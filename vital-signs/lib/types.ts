/**
 * Shared TypeScript interfaces for Vital Signs app
 */

export interface ECGSample {
  timestamp: number;
  value: number;
  leadOff: boolean;
}

export interface ECGAnalysis {
  heartRate: number;
  rhythm: string;
  rPeakIndices: number[];
  rrIntervals: number[];
  abnormalities: string[];
}

export interface BloodPressure {
  systolic: number;
  diastolic: number;
  pulse: number;
  timestamp: number;
}

export interface SpO2Reading {
  timestamp: number;
  spo2: number;
  heartRate: number;
  perfusionIndex: string;
}

export interface TemperatureReading {
  timestamp: number;
  celsius: number;
  fahrenheit: number;
}

export interface VitalRecord {
  id: string;
  timestamp: number;
  type: 'ecg' | 'spo2' | 'bp' | 'temperature';
  data: ECGSessionRecord | SpO2Reading | BloodPressure | TemperatureReading;
  summary?: string;
}

export interface ECGSessionRecord {
  id: string;
  startTime: number;
  endTime?: number;
  samples: Array<{ timestamp: number; value: number }>;
  analysis?: {
    heartRate: number;
    rhythm: string;
    abnormalities?: string[];
  };
}

export interface DeviceInfo {
  id: string;
  name: string;
  connected: boolean;
}

export type ConnectionStatus = 'disconnected' | 'scanning' | 'connecting' | 'connected' | 'reconnecting' | 'error';

export interface BLECallbacks {
  onECGData: (samples: ECGSample[]) => void;
  onSpO2Data: (reading: SpO2Reading) => void;
  onBPData: (reading: BloodPressure) => void;
  onTemperatureData: (reading: TemperatureReading) => void;
  onConnectionChange: (status: ConnectionStatus, deviceName?: string) => void;
  onError: (message: string) => void;
}
