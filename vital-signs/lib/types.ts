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

export interface CheckmeDeviceInfo {
  Region?: string;
  Model?: string;
  HardwareVer?: string;
  SoftwareVer?: string;
  CurLanguage?: string;
  Application?: string;  // MODE_HOME, MODE_ECG, MODE_SPO2, etc.
  SN?: string;
  BranchCode?: string;
  FileVer?: string;
  SPCPVer?: string;
}

export interface StoredRecord {
  type: 'ecg' | 'spo2' | 'bp' | 'temperature' | 'sleep';
  timestamp: number;
  data: Record<string, unknown>;
  raw?: Uint8Array;
}

export interface BLECallbacks {
  onECGData: (samples: ECGSample[]) => void;
  onSpO2Data: (reading: SpO2Reading) => void;
  onBPData: (reading: BloodPressure) => void;
  onTemperatureData: (reading: TemperatureReading) => void;
  onConnectionChange: (status: ConnectionStatus, deviceName?: string) => void;
  onDeviceInfo: (info: CheckmeDeviceInfo) => void;
  onStoredData: (records: StoredRecord[]) => void;
  onError: (message: string) => void;
}
