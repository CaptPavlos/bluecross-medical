/**
 * ECG Signal Processor
 * 
 * Direct port from Electron app ECGProcessor.ts
 * 
 * Handles:
 * - Signal filtering (baseline wander, noise)
 * - R-peak detection (Pan-Tompkins simplified)
 * - Heart rate calculation
 * - Arrhythmia detection
 */

import { ECGSample, ECGAnalysis } from '@/lib/types';

export class ECGProcessor {
  private readonly sampleRate = 500; // Hz
  private readonly baselineFilterCoeff = 0.995;
  private baseline = 0;

  /**
   * Apply baseline wander removal (high-pass filter)
   */
  removeBaselineWander(samples: ECGSample[]): ECGSample[] {
    return samples.map(sample => {
      this.baseline = this.baselineFilterCoeff * this.baseline +
        (1 - this.baselineFilterCoeff) * sample.value;
      return {
        ...sample,
        value: sample.value - this.baseline,
      };
    });
  }

  /**
   * Detect R-peaks using Pan-Tompkins algorithm (simplified)
   */
  detectRPeaks(samples: ECGSample[]): number[] {
    const values = samples.map(s => s.value);
    const peaks: number[] = [];

    // Moving average for smoothing
    const windowSize = Math.floor(this.sampleRate * 0.1); // 100ms window
    const smoothed = this.movingAverage(values, windowSize);

    // Adaptive threshold
    const threshold = this.calculateAdaptiveThreshold(smoothed);

    // Find peaks above threshold
    const minDistance = Math.floor(this.sampleRate * 0.3); // Min 300ms between peaks
    let lastPeak = -minDistance;

    for (let i = 1; i < smoothed.length - 1; i++) {
      if (
        smoothed[i] > threshold &&
        smoothed[i] > smoothed[i - 1] &&
        smoothed[i] > smoothed[i + 1] &&
        i - lastPeak >= minDistance
      ) {
        peaks.push(i);
        lastPeak = i;
      }
    }

    return peaks;
  }

  /**
   * Calculate heart rate from R-peaks
   */
  calculateHeartRate(samples: ECGSample[], rPeakIndices: number[]): number {
    if (rPeakIndices.length < 2) return 0;

    const rrIntervals: number[] = [];
    for (let i = 1; i < rPeakIndices.length; i++) {
      const intervalMs =
        samples[rPeakIndices[i]].timestamp -
        samples[rPeakIndices[i - 1]].timestamp;
      rrIntervals.push(intervalMs);
    }

    const avgRR = rrIntervals.reduce((a, b) => a + b, 0) / rrIntervals.length;
    return Math.round(60000 / avgRR); // BPM
  }

  /**
   * Analyze rhythm for abnormalities
   */
  analyzeRhythm(
    samples: ECGSample[],
    rPeakIndices: number[]
  ): {
    rhythm: string;
    abnormalities: string[];
  } {
    const abnormalities: string[] = [];

    if (rPeakIndices.length < 3) {
      return { rhythm: 'Insufficient data', abnormalities };
    }

    // Calculate RR intervals
    const rrIntervals: number[] = [];
    for (let i = 1; i < rPeakIndices.length; i++) {
      const interval =
        samples[rPeakIndices[i]].timestamp -
        samples[rPeakIndices[i - 1]].timestamp;
      rrIntervals.push(interval);
    }

    // Check for irregularity
    const avgRR = rrIntervals.reduce((a, b) => a + b, 0) / rrIntervals.length;
    const rrVariation = rrIntervals.map(rr => Math.abs(rr - avgRR) / avgRR);
    const maxVariation = Math.max(...rrVariation);

    if (maxVariation > 0.15) {
      abnormalities.push('Irregular rhythm detected');
    }

    // Check for bradycardia/tachycardia
    const hr = 60000 / avgRR;
    if (hr < 60) {
      abnormalities.push('Bradycardia');
    } else if (hr > 100) {
      abnormalities.push('Tachycardia');
    }

    // Determine rhythm classification
    let rhythm = 'Normal Sinus Rhythm';
    if (maxVariation > 0.2) {
      rhythm = 'Irregular Rhythm';
    } else if (abnormalities.length > 0) {
      rhythm = abnormalities.join(', ');
    }

    return { rhythm, abnormalities };
  }

  /**
   * Full ECG analysis
   */
  analyze(samples: ECGSample[]): ECGAnalysis {
    // Remove baseline wander
    const filtered = this.removeBaselineWander(samples);

    // Detect R-peaks
    const rPeakIndices = this.detectRPeaks(filtered);

    // Calculate heart rate
    const heartRate = this.calculateHeartRate(filtered, rPeakIndices);

    // Analyze rhythm
    const { rhythm, abnormalities } = this.analyzeRhythm(
      filtered,
      rPeakIndices
    );

    // Calculate RR intervals
    const rrIntervals: number[] = [];
    for (let i = 1; i < rPeakIndices.length; i++) {
      rrIntervals.push(
        filtered[rPeakIndices[i]].timestamp -
          filtered[rPeakIndices[i - 1]].timestamp
      );
    }

    return {
      heartRate,
      rhythm,
      rPeakIndices,
      rrIntervals,
      abnormalities,
    };
  }

  /**
   * Moving average filter
   */
  private movingAverage(values: number[], windowSize: number): number[] {
    const result: number[] = [];
    for (let i = 0; i < values.length; i++) {
      const start = Math.max(0, i - windowSize);
      const end = Math.min(values.length, i + windowSize + 1);
      const sum = values.slice(start, end).reduce((a, b) => a + b, 0);
      result.push(sum / (end - start));
    }
    return result;
  }

  /**
   * Calculate adaptive threshold for peak detection
   */
  private calculateAdaptiveThreshold(values: number[]): number {
    const sorted = [...values].sort((a, b) => a - b);
    const q75 = sorted[Math.floor(sorted.length * 0.75)];
    return q75 * 0.6;
  }
}
