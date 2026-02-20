/**
 * Zustand Store for Vital Signs State
 * 
 * Adapted from Electron app vitalsStore.ts
 * Added: demo mode, connection status, ECG analysis
 */

import { create } from 'zustand';
import { ECGSample, BloodPressure, SpO2Reading, ConnectionStatus, ECGAnalysis, CheckmeDeviceInfo, StoredRecord } from '@/lib/types';

interface VitalsState {
  // Connection
  connectionStatus: ConnectionStatus;
  deviceName: string | undefined;
  deviceInfo: CheckmeDeviceInfo | null;

  // Demo mode
  isDemoMode: boolean;

  // ECG
  ecgData: ECGSample[];
  ecgAnalysis: ECGAnalysis | null;
  isRecording: boolean;
  recordingStartTime: number | null;

  // SpO2
  spo2: number | null;
  heartRate: number | null;
  perfusionIndex: string | null;

  // Blood Pressure
  bloodPressure: BloodPressure | null;
  isMeasuringBP: boolean;

  // Temperature
  temperature: number | null;

  // Stored data from device
  storedRecords: StoredRecord[];
  isDownloading: boolean;

  // Actions
  setConnectionStatus: (status: ConnectionStatus, deviceName?: string) => void;
  setDeviceInfo: (info: CheckmeDeviceInfo) => void;
  setDemoMode: (active: boolean) => void;
  addECGData: (samples: ECGSample[]) => void;
  setECGAnalysis: (analysis: ECGAnalysis | null) => void;
  clearECGData: () => void;
  setRecording: (isRecording: boolean) => void;
  setSpO2: (spo2: number, heartRate: number, perfusionIndex?: string) => void;
  setBloodPressure: (systolic: number, diastolic: number, pulse: number) => void;
  setMeasuringBP: (measuring: boolean) => void;
  setTemperature: (celsius: number) => void;
  setStoredRecords: (records: StoredRecord[]) => void;
  setDownloading: (downloading: boolean) => void;
  reset: () => void;
}

const MAX_ECG_SAMPLES = 5000; // ~10 seconds at 500Hz

const initialState = {
  connectionStatus: 'disconnected' as ConnectionStatus,
  deviceName: undefined,
  deviceInfo: null as CheckmeDeviceInfo | null,
  isDemoMode: false,
  ecgData: [] as ECGSample[],
  ecgAnalysis: null as ECGAnalysis | null,
  isRecording: false,
  recordingStartTime: null as number | null,
  spo2: null as number | null,
  heartRate: null as number | null,
  perfusionIndex: null as string | null,
  bloodPressure: null as BloodPressure | null,
  isMeasuringBP: false,
  temperature: null as number | null,
  storedRecords: [] as StoredRecord[],
  isDownloading: false,
};

export const useVitalsStore = create<VitalsState>((set) => ({
  ...initialState,

  setConnectionStatus: (status, deviceName) =>
    set((state) => ({
      connectionStatus: status,
      deviceName: deviceName ?? state.deviceName ?? (status === 'disconnected' ? undefined : undefined),
    })),

  setDeviceInfo: (info) => set({ deviceInfo: info }),

  setDemoMode: (active) =>
    set({
      isDemoMode: active,
      connectionStatus: active ? 'connected' : 'disconnected',
      deviceName: active ? 'Demo Device' : undefined,
    }),

  addECGData: (samples) =>
    set((state) => {
      const newData = [...state.ecgData, ...samples];
      if (newData.length > MAX_ECG_SAMPLES) {
        return { ecgData: newData.slice(-MAX_ECG_SAMPLES) };
      }
      return { ecgData: newData };
    }),

  setECGAnalysis: (analysis) => set({ ecgAnalysis: analysis }),

  clearECGData: () => set({ ecgData: [], ecgAnalysis: null }),

  setRecording: (isRecording) =>
    set({
      isRecording,
      recordingStartTime: isRecording ? Date.now() : null,
    }),

  setSpO2: (spo2, heartRate, perfusionIndex) =>
    set({ spo2, heartRate, perfusionIndex: perfusionIndex ?? null }),

  setBloodPressure: (systolic, diastolic, pulse) =>
    set({
      bloodPressure: {
        systolic,
        diastolic,
        pulse,
        timestamp: Date.now(),
      },
      isMeasuringBP: false,
    }),

  setMeasuringBP: (measuring) => set({ isMeasuringBP: measuring }),

  setTemperature: (celsius) => set({ temperature: celsius }),

  setStoredRecords: (records) => set({ storedRecords: records, isDownloading: false }),

  setDownloading: (downloading) => set({ isDownloading: downloading }),

  reset: () => set(initialState),
}));
