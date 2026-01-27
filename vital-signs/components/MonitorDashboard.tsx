'use client';

/**
 * Main Monitor Dashboard
 * 
 * Orchestrates all vital sign components:
 * - ECG Waveform with recording controls
 * - Vital Cards (HR, SpO2, BP, Temp)
 * - Bluetooth connection or Demo mode
 * - Device status
 * - Recording and export controls
 */

import React, { useCallback, useEffect, useRef, useState } from 'react';
import { Circle, History, Save } from 'lucide-react';
import Link from 'next/link';
import { ECGWaveform } from './ECGWaveform';
import { VitalCard } from './VitalCard';
import { DeviceStatus } from './DeviceStatus';
import { BluetoothConnect } from './BluetoothConnect';
import { DemoModeToggle, useDemoMode } from './DemoMode';
import { ExportButton } from './ExportButton';
import { useVitalsStore } from '@/lib/stores/vitals-store';
import { ECGProcessor } from '@/lib/processors/ecg-processor';
import { saveVitalRecord, saveECGSession } from '@/lib/storage/indexed-db';
import { ECGSessionRecord, VitalRecord } from '@/lib/types';

export const MonitorDashboard: React.FC = () => {
  const [isMounted, setIsMounted] = useState(false);
  const processorRef = useRef(new ECGProcessor());
  const recordedSamplesRef = useRef<Array<{ timestamp: number; value: number }>>([]);

  const {
    connectionStatus,
    deviceName,
    isDemoMode,
    ecgData,
    ecgAnalysis,
    spo2,
    heartRate,
    bloodPressure,
    temperature,
    isRecording,
    recordingStartTime,
    setConnectionStatus,
    setECGAnalysis,
    setRecording,
    reset,
  } = useVitalsStore();

  const { startDemo, stopDemo } = useDemoMode();

  // Prevent hydration mismatch — only render dynamic content after mount
  useEffect(() => {
    setIsMounted(true);
  }, []);

  const isConnected = connectionStatus === 'connected';
  const isStreaming = isConnected && ecgData.length > 0;

  // Run ECG analysis periodically
  useEffect(() => {
    if (ecgData.length > 500) {
      const analysis = processorRef.current.analyze(ecgData.slice(-2500));
      setECGAnalysis(analysis);
    }
  }, [ecgData.length, setECGAnalysis, ecgData]);

  // Collect samples while recording
  useEffect(() => {
    if (isRecording && ecgData.length > 0) {
      const latest = ecgData.slice(-10);
      recordedSamplesRef.current.push(
        ...latest.map(s => ({ timestamp: s.timestamp, value: s.value }))
      );
    }
  }, [isRecording, ecgData]);

  const handleDisconnect = useCallback(() => {
    if (isDemoMode) {
      stopDemo();
    } else {
      // Real BLE disconnect is handled by BluetoothConnect
      setConnectionStatus('disconnected');
    }
    reset();
  }, [isDemoMode, stopDemo, setConnectionStatus, reset]);

  const handleStartDemo = useCallback(() => {
    startDemo();
  }, [startDemo]);

  const handleToggleRecording = useCallback(async () => {
    if (isRecording) {
      // Stop recording and save
      const session: ECGSessionRecord = {
        id: crypto.randomUUID(),
        startTime: recordingStartTime || Date.now(),
        endTime: Date.now(),
        samples: recordedSamplesRef.current,
        analysis: ecgAnalysis
          ? {
              heartRate: ecgAnalysis.heartRate,
              rhythm: ecgAnalysis.rhythm,
              abnormalities: ecgAnalysis.abnormalities,
            }
          : undefined,
      };

      try {
        await saveECGSession(session);

        const record: VitalRecord = {
          id: crypto.randomUUID(),
          timestamp: session.startTime,
          type: 'ecg',
          data: session,
          summary: `ECG ${session.analysis?.heartRate ?? '--'} BPM, ${session.analysis?.rhythm ?? 'Unknown'}`,
        };
        await saveVitalRecord(record);
      } catch (err) {
        console.error('Failed to save recording:', err);
      }

      recordedSamplesRef.current = [];
      setRecording(false);
    } else {
      // Start recording
      recordedSamplesRef.current = [];
      setRecording(true);
    }
  }, [isRecording, recordingStartTime, ecgAnalysis, setRecording]);

  // Save current vitals as a snapshot
  const handleSaveSnapshot = useCallback(async () => {
    try {
      if (spo2 !== null && heartRate !== null) {
        await saveVitalRecord({
          id: crypto.randomUUID(),
          timestamp: Date.now(),
          type: 'spo2',
          data: { timestamp: Date.now(), spo2, heartRate, perfusionIndex: '0' },
          summary: `SpO2 ${spo2}%, HR ${heartRate} BPM`,
        });
      }
      if (bloodPressure) {
        await saveVitalRecord({
          id: crypto.randomUUID(),
          timestamp: Date.now(),
          type: 'bp',
          data: bloodPressure,
          summary: `BP ${bloodPressure.systolic}/${bloodPressure.diastolic} mmHg`,
        });
      }
      if (temperature !== null) {
        await saveVitalRecord({
          id: crypto.randomUUID(),
          timestamp: Date.now(),
          type: 'temperature',
          data: {
            timestamp: Date.now(),
            celsius: temperature,
            fahrenheit: parseFloat((temperature * 9 / 5 + 32).toFixed(1)),
          },
          summary: `Temp ${temperature}°C`,
        });
      }
    } catch (err) {
      console.error('Failed to save snapshot:', err);
    }
  }, [spo2, heartRate, bloodPressure, temperature]);

  // Derived display values
  const displayHR = ecgAnalysis?.heartRate ?? heartRate ?? null;
  const displayRhythm = ecgAnalysis?.rhythm ?? null;
  const bpValue = bloodPressure
    ? `${bloodPressure.systolic}/${bloodPressure.diastolic}`
    : null;
  const tempValue = temperature !== null ? temperature.toFixed(1) : null;

  return (
    <div className="flex flex-col gap-6">
      {/* Header controls row */}
      <div className="flex flex-wrap items-center justify-between gap-4">
        <div className="flex items-center gap-3">
          <DeviceStatus
            status={connectionStatus}
            deviceName={deviceName}
            onDisconnect={handleDisconnect}
          />
          {isConnected && isDemoMode && (
            <DemoModeToggle
              onStart={handleStartDemo}
              onStop={stopDemo}
              isActive={isDemoMode}
            />
          )}
        </div>

        <div className="flex items-center gap-3">
          {isConnected && (
            <>
              <button
                onClick={handleToggleRecording}
                className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium transition-all ${
                  isRecording
                    ? 'bg-accent-red/20 text-accent-red border border-accent-red/50'
                    : 'btn-secondary'
                }`}
              >
                <Circle size={14} className={isRecording ? 'fill-accent-red text-accent-red animate-pulse' : ''} />
                {isRecording ? 'Stop Recording' : 'Record ECG'}
              </button>

              <button
                onClick={handleSaveSnapshot}
                className="btn-secondary flex items-center gap-2 text-sm"
              >
                <Save size={14} />
                Save Snapshot
              </button>
            </>
          )}

          <ExportButton />

          <Link
            href="/history"
            className="btn-outline flex items-center gap-2 text-sm"
          >
            <History size={14} />
            History
          </Link>
        </div>
      </div>

      {/* Connection panel (when not connected) */}
      {!isConnected && (
        <BluetoothConnect onDemoMode={handleStartDemo} />
      )}

      {/* ECG Section */}
      {isConnected && (
        <div className="bg-bg-secondary rounded-xl p-5">
          <div className="flex items-center justify-between mb-4">
            <h2 className="text-lg font-semibold">ECG Monitor</h2>
            {displayRhythm && (
              <span className={`text-sm px-3 py-1 rounded-full ${
                displayRhythm === 'Normal Sinus Rhythm'
                  ? 'bg-accent-green/20 text-accent-green'
                  : 'bg-accent-yellow/20 text-accent-yellow'
              }`}>
                {displayRhythm}
              </span>
            )}
            {isRecording && isMounted && (
              <span className="text-sm px-3 py-1 rounded-full bg-accent-red/20 text-accent-red flex items-center gap-1">
                <Circle size={8} className="fill-accent-red animate-pulse" />
                REC
              </span>
            )}
          </div>
          <ECGWaveform data={ecgData} isStreaming={isStreaming} />
        </div>
      )}

      {/* Vital Cards Grid */}
      {isConnected && (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
          <VitalCard
            title="Heart Rate"
            value={displayHR}
            unit="BPM"
            type="hr"
            normalRange={{ min: 60, max: 100 }}
          />
          <VitalCard
            title="SpO2"
            value={spo2}
            unit="%"
            type="spo2"
            normalRange={{ min: 95, max: 100 }}
          />
          <VitalCard
            title="Blood Pressure"
            value={bpValue}
            unit="mmHg"
            type="bp"
            secondaryValue={bloodPressure ? `Pulse: ${bloodPressure.pulse}` : undefined}
          />
          <VitalCard
            title="Temperature"
            value={tempValue}
            unit="°C"
            type="temp"
            normalRange={{ min: 36.1, max: 37.2 }}
          />
        </div>
      )}
    </div>
  );
};
