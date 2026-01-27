'use client';

/**
 * Vital Sign Display Card
 * 
 * Ported from Electron app VitalCard.tsx
 * Heart Rate, SpO2, Blood Pressure, Temperature
 * Normal range indicators with abnormal warnings
 * Pulse animation for abnormal values
 */

import React from 'react';
import { Heart, Droplets, Activity, Thermometer } from 'lucide-react';

interface VitalCardProps {
  title: string;
  value: string | number | null;
  unit: string;
  type: 'hr' | 'spo2' | 'bp' | 'temp';
  normalRange?: { min: number; max: number };
  secondaryValue?: string;
}

const iconMap = {
  hr: Heart,
  spo2: Droplets,
  bp: Activity,
  temp: Thermometer,
};

const colorMap = {
  hr: '#ff6b6b',
  spo2: '#45b7d1',
  bp: '#f9ca24',
  temp: '#00ff88',
};

export const VitalCard: React.FC<VitalCardProps> = ({
  title,
  value,
  unit,
  type,
  normalRange,
  secondaryValue,
}) => {
  const IconComponent = iconMap[type];
  const color = colorMap[type];

  const numValue = value !== null ? (typeof value === 'string' ? parseFloat(value) : value) : NaN;
  const isAbnormal = normalRange && !isNaN(numValue) &&
    (numValue < normalRange.min || numValue > normalRange.max);

  const displayValue = value !== null && value !== undefined ? value : '--';

  return (
    <div
      className={`
        relative bg-bg-secondary rounded-xl p-5 flex gap-4 border-l-4 transition-all duration-200
        hover:-translate-y-0.5 hover:shadow-lg hover:shadow-black/30
        ${isAbnormal ? 'bg-red-500/10 animate-pulse-vital' : ''}
      `}
      style={{ borderColor: color }}
    >
      {/* Icon */}
      <div className="text-3xl flex items-start pt-1">
        <IconComponent size={32} style={{ color }} />
      </div>

      {/* Content */}
      <div className="flex-1">
        <h3 className="text-sm text-gray-400 mb-1">{title}</h3>
        <div className="flex items-baseline gap-1" style={{ color }}>
          <span className="text-3xl font-bold">{displayValue}</span>
          <span className="text-base font-normal text-gray-400">{unit}</span>
        </div>
        {secondaryValue && (
          <div className="text-xs text-gray-500 mt-1">{secondaryValue}</div>
        )}
        {normalRange && (
          <div className="text-xs text-gray-500 mt-1">
            Normal: {normalRange.min}–{normalRange.max}
          </div>
        )}
      </div>

      {/* Abnormal indicator */}
      {isAbnormal && (
        <div className="absolute top-3 right-3 text-2xl">⚠️</div>
      )}
    </div>
  );
};
