'use client';

/**
 * Demo Mode - Simulated vital signs data
 * 
 * Generates realistic ECG waveform, SpO2, BP, and Temperature data
 * for testing the app without a physical BLE device.
 * 
 * Based on the simulation logic from the Electron BluetoothManager.
 */

import React, { useEffect, useRef, useCallback } from 'react';
import { useVitalsStore } from '@/lib/stores/vitals-store';
import { ECGSample } from '@/lib/types';

const ECG_SAMPLE_RATE = 500; // Hz
const ECG_BATCH_SIZE = 10; // Samples per batch (match BLE MTU behavior)
const ECG_BATCH_INTERVAL = ECG_BATCH_SIZE * (1000 / ECG_SAMPLE_RATE); // ~20ms

export function useDemoMode() {
  const ecgTimerRef = useRef<ReturnType<typeof setInterval> | null>(null);
  const vitalsTimerRef = useRef<ReturnType<typeof setInterval> | null>(null);
  const sampleCountRef = useRef(0);

  const {
    isDemoMode,
    setDemoMode,
    addECGData,
    setSpO2,
    setBloodPressure,
    setTemperature,
  } = useVitalsStore();

  /**
   * Generate realistic ECG waveform sample
   * Simulates a normal sinus rhythm ~72 BPM
   */
  const generateECGSample = useCallback((sampleIndex: number): number => {
    const beatDuration = ECG_SAMPLE_RATE * (60 / 72); // samples per beat at 72 BPM
    const t = (sampleIndex % beatDuration) / beatDuration; // normalized position in beat cycle

    let value: number;

    if (t < 0.08) {
      // P wave
      value = Math.sin(t / 0.08 * Math.PI) * 100;
    } else if (t < 0.12) {
      // PR segment
      value = 0;
    } else if (t < 0.16) {
      // QRS complex
      const qrsPhase = (t - 0.12) / 0.04;
      if (qrsPhase < 0.25) {
        value = -200 * (qrsPhase / 0.25); // Q wave
      } else if (qrsPhase < 0.5) {
        value = -200 + 1700 * ((qrsPhase - 0.25) / 0.25); // R wave up
      } else if (qrsPhase < 0.75) {
        value = 1500 - 1800 * ((qrsPhase - 0.5) / 0.25); // R wave down to S
      } else {
        value = -300 + 300 * ((qrsPhase - 0.75) / 0.25); // S wave recovery
      }
    } else if (t < 0.22) {
      // ST segment
      value = 0;
    } else if (t < 0.36) {
      // T wave
      value = Math.sin((t - 0.22) / 0.14 * Math.PI) * 200;
    } else {
      // Baseline (isoelectric)
      value = 0;
    }

    // Add realistic noise
    value += (Math.random() - 0.5) * 20;

    // Clamp to 12-bit range
    return Math.max(-2048, Math.min(2047, Math.round(value)));
  }, []);

  /**
   * Start demo mode
   */
  const startDemo = useCallback(() => {
    setDemoMode(true);
    sampleCountRef.current = 0;

    // ECG stream — batched like BLE notifications
    ecgTimerRef.current = setInterval(() => {
      const now = Date.now();
      const samples: ECGSample[] = [];

      for (let i = 0; i < ECG_BATCH_SIZE; i++) {
        samples.push({
          timestamp: now + i * (1000 / ECG_SAMPLE_RATE),
          value: generateECGSample(sampleCountRef.current + i),
          leadOff: false,
        });
      }

      sampleCountRef.current += ECG_BATCH_SIZE;
      addECGData(samples);
    }, ECG_BATCH_INTERVAL);

    // Vitals stream (SpO2 at 1Hz, BP and Temp occasionally)
    let vitalsTick = 0;
    vitalsTimerRef.current = setInterval(() => {
      vitalsTick++;

      // SpO2 every second
      const spo2 = 97 + Math.random() * 2;
      const hr = 70 + Math.random() * 10;
      const pi = (2 + Math.random() * 3).toFixed(1);
      setSpO2(Math.round(spo2), Math.round(hr), pi);

      // Blood pressure every 30 seconds
      if (vitalsTick % 30 === 0) {
        const systolic = 115 + Math.round(Math.random() * 10);
        const diastolic = 75 + Math.round(Math.random() * 8);
        const pulse = 72 + Math.round(Math.random() * 10);
        setBloodPressure(systolic, diastolic, pulse);
      }

      // Temperature every 10 seconds
      if (vitalsTick % 10 === 0) {
        const temp = 36.5 + Math.random() * 0.8;
        setTemperature(parseFloat(temp.toFixed(1)));
      }
    }, 1000);
  }, [setDemoMode, addECGData, setSpO2, setBloodPressure, setTemperature, generateECGSample]);

  /**
   * Stop demo mode
   */
  const stopDemo = useCallback(() => {
    if (ecgTimerRef.current) {
      clearInterval(ecgTimerRef.current);
      ecgTimerRef.current = null;
    }
    if (vitalsTimerRef.current) {
      clearInterval(vitalsTimerRef.current);
      vitalsTimerRef.current = null;
    }
    setDemoMode(false);
  }, [setDemoMode]);

  // Cleanup on unmount
  useEffect(() => {
    return () => {
      if (ecgTimerRef.current) clearInterval(ecgTimerRef.current);
      if (vitalsTimerRef.current) clearInterval(vitalsTimerRef.current);
    };
  }, []);

  return { isDemoMode, startDemo, stopDemo };
}

/**
 * Demo Mode Toggle Button Component
 */
interface DemoModeProps {
  onStart: () => void;
  onStop: () => void;
  isActive: boolean;
}

export const DemoModeToggle: React.FC<DemoModeProps> = ({ onStart, onStop, isActive }) => {
  return (
    <button
      onClick={isActive ? onStop : onStart}
      className={`
        px-4 py-2 rounded-lg font-medium text-sm transition-all duration-200
        ${isActive
          ? 'bg-accent-yellow/20 text-accent-yellow border border-accent-yellow/50 hover:bg-accent-yellow/30'
          : 'bg-bg-card text-gray-300 border border-gray-600 hover:border-accent-yellow hover:text-accent-yellow'
        }
      `}
    >
      {isActive ? '⏹ Stop Demo' : '▶ Start Demo'}
    </button>
  );
};
