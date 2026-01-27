/**
 * CSV Export API Route
 * 
 * Generates CSV from vital records passed in the request body.
 * Client-side data is sent here for server-side CSV formatting.
 * 
 * POST /api/export
 * Body: { records: VitalRecord[], format: 'csv' | 'json' }
 */

import { NextRequest, NextResponse } from 'next/server';

interface ExportRecord {
  id: string;
  timestamp: number;
  type: string;
  summary?: string;
  data: unknown;
}

interface ExportRequest {
  records: ExportRecord[];
  format: 'csv' | 'json';
}

export async function POST(request: NextRequest) {
  try {
    const body: ExportRequest = await request.json();

    if (!body.records || !Array.isArray(body.records)) {
      return NextResponse.json(
        { error: 'Missing or invalid records array' },
        { status: 400 }
      );
    }

    if (body.format === 'json') {
      return new NextResponse(JSON.stringify(body.records, null, 2), {
        headers: {
          'Content-Type': 'application/json',
          'Content-Disposition': `attachment; filename="vitals-export-${Date.now()}.json"`,
        },
      });
    }

    // CSV export
    const headers = ['ID', 'Timestamp', 'Date', 'Time', 'Type', 'Summary', 'Data'];
    const rows = body.records.map(record => {
      const date = new Date(record.timestamp);
      return [
        record.id,
        record.timestamp.toString(),
        date.toISOString().split('T')[0],
        date.toISOString().split('T')[1].split('.')[0],
        record.type,
        `"${(record.summary || '').replace(/"/g, '""')}"`,
        `"${JSON.stringify(record.data).replace(/"/g, '""')}"`,
      ].join(',');
    });

    const csv = [headers.join(','), ...rows].join('\n');

    return new NextResponse(csv, {
      headers: {
        'Content-Type': 'text/csv; charset=utf-8',
        'Content-Disposition': `attachment; filename="vitals-export-${Date.now()}.csv"`,
      },
    });
  } catch (error) {
    console.error('Export error:', error);
    return NextResponse.json(
      { error: 'Export failed' },
      { status: 500 }
    );
  }
}
