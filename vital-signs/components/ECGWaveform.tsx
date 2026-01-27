'use client';

/**
 * Real-time ECG Waveform Display
 * 
 * Ported from Electron app ECGWaveform.tsx
 * Canvas-based rendering at 500Hz with standard ECG grid (25mm/s, 10mm/mV)
 * Green waveform on dark background with glow effect
 * Lead-off detection indicator
 * Responsive width
 */

import React, { useRef, useEffect, useMemo, useCallback } from 'react';
import { ECGSample } from '@/lib/types';

interface ECGWaveformProps {
  data: ECGSample[];
  isStreaming: boolean;
  height?: number;
  secondsToShow?: number;
}

export const ECGWaveform: React.FC<ECGWaveformProps> = ({
  data,
  isStreaming,
  height = 300,
  secondsToShow = 5,
}) => {
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const containerRef = useRef<HTMLDivElement>(null);
  const animationRef = useRef<number>(0);
  const widthRef = useRef<number>(1200);

  // ECG display parameters
  const samplesPerSecond = 500;
  const totalSamples = samplesPerSecond * secondsToShow;

  // Colors
  const gridColor = 'rgba(255, 100, 100, 0.3)';
  const gridColorLight = 'rgba(255, 100, 100, 0.15)';
  const waveformColor = '#00ff88';
  const backgroundColor = '#1a1a2e';

  // Get the most recent samples to display
  const displayData = useMemo(() => {
    if (data.length <= totalSamples) return data;
    return data.slice(-totalSamples);
  }, [data, totalSamples]);

  // Detect lead-off from recent samples
  const hasLeadOff = useMemo(() => {
    if (displayData.length === 0) return false;
    const recentSamples = displayData.slice(-50);
    return recentSamples.some(s => s.leadOff);
  }, [displayData]);

  const drawGrid = useCallback((ctx: CanvasRenderingContext2D, w: number, h: number) => {
    const smallGridSize = w / (secondsToShow * 5);
    const largeGridSize = smallGridSize * 5;

    // Small grid (light)
    ctx.strokeStyle = gridColorLight;
    ctx.lineWidth = 0.5;
    ctx.beginPath();
    for (let x = 0; x <= w; x += smallGridSize) {
      ctx.moveTo(x, 0);
      ctx.lineTo(x, h);
    }
    for (let y = 0; y <= h; y += smallGridSize) {
      ctx.moveTo(0, y);
      ctx.lineTo(w, y);
    }
    ctx.stroke();

    // Large grid (bold)
    ctx.strokeStyle = gridColor;
    ctx.lineWidth = 1;
    ctx.beginPath();
    for (let x = 0; x <= w; x += largeGridSize) {
      ctx.moveTo(x, 0);
      ctx.lineTo(x, h);
    }
    for (let y = 0; y <= h; y += largeGridSize) {
      ctx.moveTo(0, y);
      ctx.lineTo(w, y);
    }
    ctx.stroke();
  }, [secondsToShow]);

  const drawWaveform = useCallback((ctx: CanvasRenderingContext2D, samples: ECGSample[], w: number, h: number) => {
    const pixelsPerSample = w / totalSamples;
    const midY = h / 2;
    const scale = h / 4000; // Scale for 16-bit values

    // Main waveform stroke
    ctx.strokeStyle = waveformColor;
    ctx.lineWidth = 2;
    ctx.lineCap = 'round';
    ctx.lineJoin = 'round';
    ctx.shadowColor = waveformColor;
    ctx.shadowBlur = 8;
    ctx.beginPath();

    samples.forEach((sample, index) => {
      const x = index * pixelsPerSample;
      const y = midY - (sample.value * scale);

      if (index === 0) {
        ctx.moveTo(x, y);
      } else {
        ctx.lineTo(x, y);
      }
    });

    ctx.stroke();

    // Reset shadow
    ctx.shadowBlur = 0;

    // Draw lead-off markers
    samples.forEach((sample, index) => {
      if (sample.leadOff) {
        const x = index * pixelsPerSample;
        ctx.fillStyle = '#ff0000';
        ctx.fillRect(x - 1, 0, 2, 5);
      }
    });
  }, [totalSamples]);

  const drawStatus = useCallback((ctx: CanvasRenderingContext2D, w: number, h: number, dataLen: number) => {
    // Streaming indicator dot
    ctx.fillStyle = isStreaming ? '#00ff88' : '#ff6b6b';
    ctx.beginPath();
    ctx.arc(20, 20, 8, 0, Math.PI * 2);
    ctx.fill();

    // Status text
    ctx.fillStyle = '#ffffff';
    ctx.font = '14px monospace';
    ctx.fillText(isStreaming ? 'LIVE' : 'STOPPED', 35, 25);

    // Lead-off warning
    if (hasLeadOff) {
      ctx.fillStyle = '#ff6b6b';
      ctx.font = 'bold 14px monospace';
      ctx.fillText('⚠ LEAD OFF', w / 2 - 60, 25);
    }

    // Sample count
    ctx.fillStyle = '#888888';
    ctx.font = '12px monospace';
    ctx.fillText(`${dataLen} samples`, w - 120, 25);

    // Speed indicator
    ctx.fillText('25mm/s', w - 80, h - 10);
  }, [isStreaming, hasLeadOff]);

  // Handle resize
  useEffect(() => {
    const handleResize = () => {
      if (containerRef.current) {
        const newWidth = containerRef.current.clientWidth;
        widthRef.current = newWidth;
        if (canvasRef.current) {
          canvasRef.current.width = newWidth;
        }
      }
    };

    handleResize();
    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  // Draw loop
  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;

    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    const draw = () => {
      const w = widthRef.current;
      canvas.width = w;
      canvas.height = height;

      // Clear canvas
      ctx.fillStyle = backgroundColor;
      ctx.fillRect(0, 0, w, height);

      // Draw grid
      drawGrid(ctx, w, height);

      // Draw waveform
      if (displayData.length > 1) {
        drawWaveform(ctx, displayData, w, height);
      }

      // Draw status
      drawStatus(ctx, w, height, displayData.length);

      // Continue animation if streaming
      if (isStreaming) {
        animationRef.current = requestAnimationFrame(draw);
      }
    };

    draw();

    return () => {
      if (animationRef.current) {
        cancelAnimationFrame(animationRef.current);
      }
    };
  }, [displayData, isStreaming, height, drawGrid, drawWaveform, drawStatus]);

  return (
    <div ref={containerRef} className="ecg-waveform-container relative rounded-lg overflow-hidden w-full">
      <canvas
        ref={canvasRef}
        height={height}
        className="ecg-canvas block w-full"
        style={{ height: `${height}px` }}
      />
      <div className="absolute bottom-2 left-2 flex gap-3">
        <span className="bg-black/50 px-2 py-1 rounded text-xs text-gray-400">Lead II</span>
        <span className="bg-black/50 px-2 py-1 rounded text-xs text-gray-400">10mm/mV</span>
      </div>
    </div>
  );
};
