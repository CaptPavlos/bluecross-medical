'use client';

/**
 * History Page
 * 
 * View past vital sign recordings.
 * - List recordings by date, type, summary
 * - View ECG recording playback
 * - Delete recordings
 * - Export individual sessions
 */

import React, { useEffect, useState, useCallback } from 'react';
import Link from 'next/link';
import { ArrowLeft, Trash2, Download, Heart, Droplets, Activity, Thermometer, Clock, ChevronDown, ChevronUp } from 'lucide-react';
import { VitalRecord, ECGSessionRecord } from '@/lib/types';
import { getVitalRecords, deleteVitalRecord } from '@/lib/storage/indexed-db';
import { ECGWaveform } from '@/components/ECGWaveform';

const typeIcons: Record<string, React.ReactNode> = {
  ecg: <Heart size={16} className="text-accent-red" />,
  spo2: <Droplets size={16} className="text-accent-blue" />,
  bp: <Activity size={16} className="text-accent-yellow" />,
  temperature: <Thermometer size={16} className="text-accent-green" />,
};

const typeLabels: Record<string, string> = {
  ecg: 'ECG Recording',
  spo2: 'SpO2',
  bp: 'Blood Pressure',
  temperature: 'Temperature',
};

export default function HistoryPage() {
  const [records, setRecords] = useState<VitalRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [expandedId, setExpandedId] = useState<string | null>(null);
  const [filterType, setFilterType] = useState<string>('all');

  const loadRecords = useCallback(async () => {
    setLoading(true);
    try {
      const allRecords = await getVitalRecords();
      setRecords(allRecords);
    } catch (err) {
      console.error('Failed to load records:', err);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    loadRecords();
  }, [loadRecords]);

  const handleDelete = async (id: string) => {
    if (confirm('Delete this recording?')) {
      try {
        await deleteVitalRecord(id);
        setRecords(prev => prev.filter(r => r.id !== id));
      } catch (err) {
        console.error('Delete failed:', err);
      }
    }
  };

  const handleExportRecord = (record: VitalRecord) => {
    const json = JSON.stringify(record, null, 2);
    const blob = new Blob([json], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `vital-${record.type}-${new Date(record.timestamp).toISOString().slice(0, 19)}.json`;
    a.click();
    URL.revokeObjectURL(url);
  };

  const filteredRecords = filterType === 'all'
    ? records
    : records.filter(r => r.type === filterType);

  const formatDate = (timestamp: number) => {
    const d = new Date(timestamp);
    return d.toLocaleDateString('en-US', {
      weekday: 'short',
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  const formatTime = (timestamp: number) => {
    return new Date(timestamp).toLocaleTimeString('en-US', {
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit',
    });
  };

  return (
    <div className="max-w-4xl mx-auto">
      {/* Header */}
      <div className="flex items-center justify-between mb-6">
        <div className="flex items-center gap-4">
          <Link
            href="/"
            className="p-2 rounded-lg hover:bg-white/5 transition-colors"
          >
            <ArrowLeft size={20} />
          </Link>
          <h1 className="text-2xl font-bold">Recording History</h1>
        </div>

        <span className="text-sm text-gray-400">
          {filteredRecords.length} record{filteredRecords.length !== 1 ? 's' : ''}
        </span>
      </div>

      {/* Filter Tabs */}
      <div className="flex gap-2 mb-6 overflow-x-auto pb-2">
        {['all', 'ecg', 'spo2', 'bp', 'temperature'].map(type => (
          <button
            key={type}
            onClick={() => setFilterType(type)}
            className={`
              px-4 py-2 rounded-lg text-sm font-medium whitespace-nowrap transition-all
              ${filterType === type
                ? 'bg-accent-green/20 text-accent-green border border-accent-green/50'
                : 'bg-bg-card text-gray-400 border border-transparent hover:text-white'
              }
            `}
          >
            {type === 'all' ? 'All' : typeLabels[type]}
          </button>
        ))}
      </div>

      {/* Records List */}
      {loading ? (
        <div className="text-center py-20 text-gray-400">Loading records...</div>
      ) : filteredRecords.length === 0 ? (
        <div className="text-center py-20">
          <Clock size={48} className="mx-auto mb-4 text-gray-600" />
          <p className="text-gray-400 text-lg">No recordings yet</p>
          <p className="text-gray-500 text-sm mt-2">
            Start monitoring to see your history here.
          </p>
          <Link href="/" className="btn-primary inline-block mt-6">
            Go to Monitor
          </Link>
        </div>
      ) : (
        <div className="flex flex-col gap-3">
          {filteredRecords.map(record => {
            const isExpanded = expandedId === record.id;
            const isECG = record.type === 'ecg';
            const ecgData = isECG ? (record.data as ECGSessionRecord) : null;

            return (
              <div
                key={record.id}
                className="bg-bg-secondary rounded-xl overflow-hidden border border-white/5"
              >
                {/* Record header */}
                <div
                  className="flex items-center gap-4 p-4 cursor-pointer hover:bg-white/5 transition-colors"
                  onClick={() => setExpandedId(isExpanded ? null : record.id)}
                >
                  {/* Type icon */}
                  <div className="p-2 rounded-lg bg-bg-card">
                    {typeIcons[record.type]}
                  </div>

                  {/* Info */}
                  <div className="flex-1 min-w-0">
                    <div className="flex items-center gap-2">
                      <span className="font-medium">{typeLabels[record.type]}</span>
                      {isECG && ecgData?.analysis && (
                        <span className="text-xs px-2 py-0.5 rounded-full bg-accent-green/20 text-accent-green">
                          {ecgData.analysis.heartRate} BPM
                        </span>
                      )}
                    </div>
                    <div className="text-sm text-gray-400 mt-0.5">
                      {record.summary || formatDate(record.timestamp)}
                    </div>
                  </div>

                  {/* Time */}
                  <div className="text-right hidden sm:block">
                    <div className="text-sm text-gray-400">{formatDate(record.timestamp)}</div>
                    <div className="text-xs text-gray-500">{formatTime(record.timestamp)}</div>
                  </div>

                  {/* Actions */}
                  <div className="flex items-center gap-2">
                    <button
                      onClick={(e) => {
                        e.stopPropagation();
                        handleExportRecord(record);
                      }}
                      className="p-2 rounded-lg hover:bg-white/10 text-gray-400 hover:text-accent-blue transition-colors"
                      title="Export"
                    >
                      <Download size={16} />
                    </button>
                    <button
                      onClick={(e) => {
                        e.stopPropagation();
                        handleDelete(record.id);
                      }}
                      className="p-2 rounded-lg hover:bg-white/10 text-gray-400 hover:text-accent-red transition-colors"
                      title="Delete"
                    >
                      <Trash2 size={16} />
                    </button>
                    {isExpanded ? <ChevronUp size={16} /> : <ChevronDown size={16} />}
                  </div>
                </div>

                {/* Expanded content */}
                {isExpanded && (
                  <div className="px-4 pb-4 border-t border-white/5 pt-4">
                    {isECG && ecgData ? (
                      <div>
                        {/* ECG playback */}
                        {ecgData.samples && ecgData.samples.length > 0 && (
                          <ECGWaveform
                            data={ecgData.samples.map(s => ({
                              timestamp: s.timestamp,
                              value: s.value,
                              leadOff: false,
                            }))}
                            isStreaming={false}
                            height={200}
                          />
                        )}

                        {/* Analysis */}
                        {ecgData.analysis && (
                          <div className="mt-4 grid grid-cols-2 sm:grid-cols-3 gap-4">
                            <div>
                              <span className="text-xs text-gray-500">Heart Rate</span>
                              <div className="text-lg font-bold text-accent-red">
                                {ecgData.analysis.heartRate} BPM
                              </div>
                            </div>
                            <div>
                              <span className="text-xs text-gray-500">Rhythm</span>
                              <div className="text-sm font-medium">{ecgData.analysis.rhythm}</div>
                            </div>
                            <div>
                              <span className="text-xs text-gray-500">Duration</span>
                              <div className="text-sm font-medium">
                                {ecgData.endTime
                                  ? `${Math.round((ecgData.endTime - ecgData.startTime) / 1000)}s`
                                  : '--'}
                              </div>
                            </div>
                            {ecgData.analysis.abnormalities && ecgData.analysis.abnormalities.length > 0 && (
                              <div className="col-span-full">
                                <span className="text-xs text-gray-500">Abnormalities</span>
                                <div className="text-sm text-accent-yellow mt-1">
                                  {ecgData.analysis.abnormalities.join(', ')}
                                </div>
                              </div>
                            )}
                          </div>
                        )}

                        <div className="mt-3 text-xs text-gray-500">
                          {ecgData.samples?.length ?? 0} samples recorded
                        </div>
                      </div>
                    ) : (
                      <pre className="text-xs text-gray-400 overflow-auto max-h-48 p-3 bg-bg-primary rounded-lg">
                        {JSON.stringify(record.data, null, 2)}
                      </pre>
                    )}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}
