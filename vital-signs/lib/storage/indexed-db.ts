/**
 * IndexedDB Storage for Vital Records
 * 
 * Browser-based local storage using idb wrapper.
 * Stores vital records and ECG sessions.
 */

import { openDB, DBSchema, IDBPDatabase } from 'idb';
import { VitalRecord, ECGSessionRecord } from '@/lib/types';

interface VitalsDB extends DBSchema {
  records: {
    key: string;
    value: VitalRecord;
    indexes: {
      'by-timestamp': number;
      'by-type': string;
    };
  };
  ecgSessions: {
    key: string;
    value: ECGSessionRecord;
    indexes: {
      'by-start': number;
    };
  };
}

const DB_NAME = 'vital-signs-db';
const DB_VERSION = 1;

let dbPromise: Promise<IDBPDatabase<VitalsDB>> | null = null;

function getDB(): Promise<IDBPDatabase<VitalsDB>> {
  if (!dbPromise) {
    dbPromise = openDB<VitalsDB>(DB_NAME, DB_VERSION, {
      upgrade(db) {
        // Vital records store
        if (!db.objectStoreNames.contains('records')) {
          const recordStore = db.createObjectStore('records', { keyPath: 'id' });
          recordStore.createIndex('by-timestamp', 'timestamp');
          recordStore.createIndex('by-type', 'type');
        }

        // ECG sessions store
        if (!db.objectStoreNames.contains('ecgSessions')) {
          const sessionStore = db.createObjectStore('ecgSessions', { keyPath: 'id' });
          sessionStore.createIndex('by-start', 'startTime');
        }
      },
    });
  }
  return dbPromise;
}

/**
 * Save a vital record
 */
export async function saveVitalRecord(record: VitalRecord): Promise<string> {
  const db = await getDB();
  await db.put('records', record);
  return record.id;
}

/**
 * Get all vital records, optionally filtered by date range
 */
export async function getVitalRecords(
  startDate?: Date,
  endDate?: Date,
  type?: string
): Promise<VitalRecord[]> {
  const db = await getDB();
  let records = await db.getAllFromIndex('records', 'by-timestamp');

  if (startDate) {
    records = records.filter(r => r.timestamp >= startDate.getTime());
  }
  if (endDate) {
    records = records.filter(r => r.timestamp <= endDate.getTime());
  }
  if (type) {
    records = records.filter(r => r.type === type);
  }

  // Sort newest first
  return records.sort((a, b) => b.timestamp - a.timestamp);
}

/**
 * Get a single vital record by ID
 */
export async function getVitalRecord(id: string): Promise<VitalRecord | undefined> {
  const db = await getDB();
  return db.get('records', id);
}

/**
 * Delete a vital record
 */
export async function deleteVitalRecord(id: string): Promise<void> {
  const db = await getDB();
  await db.delete('records', id);
}

/**
 * Save an ECG session
 */
export async function saveECGSession(session: ECGSessionRecord): Promise<string> {
  const db = await getDB();
  await db.put('ecgSessions', session);
  return session.id;
}

/**
 * Get all ECG sessions
 */
export async function getECGSessions(): Promise<ECGSessionRecord[]> {
  const db = await getDB();
  const sessions = await db.getAllFromIndex('ecgSessions', 'by-start');
  return sessions.sort((a, b) => (b.startTime) - (a.startTime));
}

/**
 * Get a single ECG session by ID
 */
export async function getECGSession(id: string): Promise<ECGSessionRecord | undefined> {
  const db = await getDB();
  return db.get('ecgSessions', id);
}

/**
 * Delete an ECG session
 */
export async function deleteECGSession(id: string): Promise<void> {
  const db = await getDB();
  await db.delete('ecgSessions', id);
}

/**
 * Get record count
 */
export async function getRecordCount(): Promise<number> {
  const db = await getDB();
  return db.count('records');
}

/**
 * Clear all data
 */
export async function clearAllData(): Promise<void> {
  const db = await getDB();
  await db.clear('records');
  await db.clear('ecgSessions');
}

/**
 * Export all records as JSON
 */
export async function exportAllRecords(): Promise<VitalRecord[]> {
  const db = await getDB();
  return db.getAll('records');
}
