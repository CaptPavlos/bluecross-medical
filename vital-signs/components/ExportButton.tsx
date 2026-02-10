'use client';

/**
 * Export Button Component
 * 
 * Exports vital records as CSV or JSON.
 * Uses the API route for CSV generation and direct download for JSON.
 */

import React, { useState } from 'react';
import { Download, FileSpreadsheet, FileJson } from 'lucide-react';
import { exportAllRecords } from '@/lib/storage/indexed-db';

interface ExportButtonProps {
  /** Optional date range filter */
  startDate?: Date;
  endDate?: Date;
}

export const ExportButton: React.FC<ExportButtonProps> = ({ startDate, endDate }) => {
  const [isExporting, setIsExporting] = useState(false);
  const [showMenu, setShowMenu] = useState(false);

  const handleExportCSV = async () => {
    setIsExporting(true);
    setShowMenu(false);

    try {
      const records = await exportAllRecords();

      // Filter by date range if provided
      let filtered = records;
      if (startDate) {
        filtered = filtered.filter(r => r.timestamp >= startDate.getTime());
      }
      if (endDate) {
        filtered = filtered.filter(r => r.timestamp <= endDate.getTime());
      }

      // Build CSV
      const headers = ['ID', 'Timestamp', 'Type', 'Summary', 'Data'];
      const rows = filtered.map(r => [
        r.id,
        new Date(r.timestamp).toISOString(),
        r.type,
        r.summary || '',
        JSON.stringify(r.data).replace(/,/g, ';'), // Escape commas in JSON
      ]);

      const csv = [headers.join(','), ...rows.map(row => row.join(','))].join('\n');

      // Download
      const blob = new Blob([csv], { type: 'text/csv;charset=utf-8;' });
      const url = URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = `vitals-export-${new Date().toISOString().slice(0, 10)}.csv`;
      a.click();
      URL.revokeObjectURL(url);
    } catch (error) {
      console.error('Export failed:', error);
    } finally {
      setIsExporting(false);
    }
  };

  const handleExportJSON = async () => {
    setIsExporting(true);
    setShowMenu(false);

    try {
      const records = await exportAllRecords();

      let filtered = records;
      if (startDate) {
        filtered = filtered.filter(r => r.timestamp >= startDate.getTime());
      }
      if (endDate) {
        filtered = filtered.filter(r => r.timestamp <= endDate.getTime());
      }

      const json = JSON.stringify(filtered, null, 2);
      const blob = new Blob([json], { type: 'application/json' });
      const url = URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = `vitals-export-${new Date().toISOString().slice(0, 10)}.json`;
      a.click();
      URL.revokeObjectURL(url);
    } catch (error) {
      console.error('Export failed:', error);
    } finally {
      setIsExporting(false);
    }
  };

  return (
    <div className="relative">
      <button
        onClick={() => setShowMenu(!showMenu)}
        disabled={isExporting}
        className="btn-outline flex items-center gap-2"
      >
        <Download size={16} />
        {isExporting ? 'Exporting...' : 'Export'}
      </button>

      {showMenu && (
        <div className="absolute right-0 top-full mt-2 bg-bg-card rounded-lg shadow-xl border border-white/10 overflow-hidden z-50 min-w-[160px]">
          <button
            onClick={handleExportCSV}
            className="w-full px-4 py-3 text-left text-sm hover:bg-white/5 flex items-center gap-2 transition-colors"
          >
            <FileSpreadsheet size={16} className="text-accent-green" />
            Export CSV
          </button>
          <button
            onClick={handleExportJSON}
            className="w-full px-4 py-3 text-left text-sm hover:bg-white/5 flex items-center gap-2 transition-colors"
          >
            <FileJson size={16} className="text-accent-blue" />
            Export JSON
          </button>
        </div>
      )}
    </div>
  );
};
