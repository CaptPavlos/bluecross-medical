/**
 * Web Bluetooth API Manager for Viatom Checkme Pro
 * 
 * Based on the official Viatom BLE protocol from:
 * https://github.com/viatom-develop/LepuBle
 * 
 * Protocol details:
 * - Service UUID: 14839ac4-7d7e-415c-9a42-167340cf2339
 * - Write characteristic: 8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3
 * - Notify characteristic: 0734594A-A8E7-4B1A-A6B1-CD5243059A57
 * 
 * Command protocol (SPCP):
 * - Commands:  [0xAA, cmd, ~cmd, pkg_no(2), len(2), content(len), CRC8]
 * - Responses: [0x55, cmd, ~cmd, pkg_no(2), len(2), content(len), CRC8]
 * 
 * Real-time data packets (monitor mode):
 *   [0xA5, 0x5A, size, ecg_type, 5x ECG(2B), HR(2B), QRS(2B), ST(2B), PVCs(2B),
 *    R-mark(1B), note(1B), spo2_type(1B), 5x SpO2(2B), PR(2B), SpO2%(1B), PI(1B),
 *    pulse_mark(1B), note(1B), 0xF1, battery(1B), CRC]
 */

import { ECGSample, SpO2Reading, BLECallbacks, ConnectionStatus, CheckmeDeviceInfo, StoredRecord } from '@/lib/types';

// Viatom GATT UUIDs
const VIATOM_SERVICE_UUID = '14839ac4-7d7e-415c-9a42-167340cf2339';
const WRITE_CHARACTERISTIC_UUID = '8b00ace7-eb0b-49b0-bbe9-9aee0a26e1a3';
const NOTIFY_CHARACTERISTIC_UUID = '0734594a-a8e7-4b1a-a6b1-cd5243059a57';

// Protocol constants
const SAMPLES_PER_PACKET = 5;
const PACKET_INTERVAL_MS = 40;

// Command bytes
const CMD_HEADER = 0xAA;
const CMD_PING = 0x15;
const CMD_GET_INFO = 0x14;
const CMD_SYNC_TIME = 0x06;
const CMD_READ_START = 0x03;
const CMD_READ_PKG = 0x04;
const CMD_READ_END = 0x05;

// ECG voltage conversion: sample * 4033 / 32767 / 12 / 8.0 → millivolts
const ECG_MV_FACTOR = 4033 / 32767 / 12 / 8.0;

// Reconnection
const MAX_RECONNECT_ATTEMPTS = 3;
const INITIAL_RECONNECT_DELAY = 1000;

export function isWebBluetoothSupported(): boolean {
  return typeof navigator !== 'undefined' && 'bluetooth' in navigator;
}

interface CheckmeRtPacket {
  ecgSamples: number[];
  ecgMv: number[];
  heartRate: number;
  qrs: number;
  st: number;
  pvcs: number;
  isRMark: boolean;
  spo2Samples: number[];
  pulseRate: number;
  spo2: number;
  pi: number;
  isPulseMark: boolean;
  battery: number;
}

// CRC8 lookup table (matches BleCRC.calCRC8 from official SDK)
const TABLE_CRC8 = [
  0x00, 0x07, 0x0E, 0x09, 0x1C, 0x1B, 0x12, 0x15, 0x38, 0x3F, 0x36, 0x31, 0x24, 0x23, 0x2A, 0x2D,
  0x70, 0x77, 0x7E, 0x79, 0x6C, 0x6B, 0x62, 0x65, 0x48, 0x4F, 0x46, 0x41, 0x54, 0x53, 0x5A, 0x5D,
  0xE0, 0xE7, 0xEE, 0xE9, 0xFC, 0xFB, 0xF2, 0xF5, 0xD8, 0xDF, 0xD6, 0xD1, 0xC4, 0xC3, 0xCA, 0xCD,
  0x90, 0x97, 0x9E, 0x99, 0x8C, 0x8B, 0x82, 0x85, 0xA8, 0xAF, 0xA6, 0xA1, 0xB4, 0xB3, 0xBA, 0xBD,
  0xC7, 0xC0, 0xC9, 0xCE, 0xDB, 0xDC, 0xD5, 0xD2, 0xFF, 0xF8, 0xF1, 0xF6, 0xE3, 0xE4, 0xED, 0xEA,
  0xB7, 0xB0, 0xB9, 0xBE, 0xAB, 0xAC, 0xA5, 0xA2, 0x8F, 0x88, 0x81, 0x86, 0x93, 0x94, 0x9D, 0x9A,
  0x27, 0x20, 0x29, 0x2E, 0x3B, 0x3C, 0x35, 0x32, 0x1F, 0x18, 0x11, 0x16, 0x03, 0x04, 0x0D, 0x0A,
  0x57, 0x50, 0x59, 0x5E, 0x4B, 0x4C, 0x45, 0x42, 0x6F, 0x68, 0x61, 0x66, 0x73, 0x74, 0x7D, 0x7A,
  0x89, 0x8E, 0x87, 0x80, 0x95, 0x92, 0x9B, 0x9C, 0xB1, 0xB6, 0xBF, 0xB8, 0xAD, 0xAA, 0xA3, 0xA4,
  0xF9, 0xFE, 0xF7, 0xF0, 0xE5, 0xE2, 0xEB, 0xEC, 0xC1, 0xC6, 0xCF, 0xC8, 0xDD, 0xDA, 0xD3, 0xD4,
  0x69, 0x6E, 0x67, 0x60, 0x75, 0x72, 0x7B, 0x7C, 0x51, 0x56, 0x5F, 0x58, 0x4D, 0x4A, 0x43, 0x44,
  0x19, 0x1E, 0x17, 0x10, 0x05, 0x02, 0x0B, 0x0C, 0x21, 0x26, 0x2F, 0x28, 0x3D, 0x3A, 0x33, 0x34,
  0x4E, 0x49, 0x40, 0x47, 0x52, 0x55, 0x5C, 0x5B, 0x76, 0x71, 0x78, 0x7F, 0x6A, 0x6D, 0x64, 0x63,
  0x3E, 0x39, 0x30, 0x37, 0x22, 0x25, 0x2C, 0x2B, 0x06, 0x01, 0x08, 0x0F, 0x1A, 0x1D, 0x14, 0x13,
  0xAE, 0xA9, 0xA0, 0xA7, 0xB2, 0xB5, 0xBC, 0xBB, 0x96, 0x91, 0x98, 0x9F, 0x8A, 0x8D, 0x84, 0x83,
  0xDE, 0xD9, 0xD0, 0xD7, 0xC2, 0xC5, 0xCC, 0xCB, 0xE6, 0xE1, 0xE8, 0xEF, 0xFA, 0xFD, 0xF4, 0xF3,
];

export class WebBluetoothManager {
  private device: BluetoothDevice | null = null;
  private server: BluetoothRemoteGATTServer | null = null;
  private writeCharacteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private notifyCharacteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private reconnectAttempts = 0;
  private callbacks: BLECallbacks;
  private isStreaming = false;
  private packetBuffer: Uint8Array = new Uint8Array(0);
  private deviceInfo: CheckmeDeviceInfo | null = null;
  private intentionalDisconnect = false;
  private keepAliveTimer: ReturnType<typeof setInterval> | null = null;
  private pkgNumber = 0;

  // Data download state
  private isDownloading = false;
  private downloadBuffer: Uint8Array[] = [];
  private downloadResolve: ((data: Uint8Array) => void) | null = null;
  private downloadTimeout: ReturnType<typeof setTimeout> | null = null;

  constructor(callbacks: BLECallbacks) {
    this.callbacks = callbacks;
  }

  // ─── Public API ──────────────────────────────────────

  async requestDevice(): Promise<boolean> {
    if (!isWebBluetoothSupported()) {
      this.callbacks.onError('Web Bluetooth is not supported. Use Chrome or Edge on desktop.');
      return false;
    }

    try {
      this.callbacks.onConnectionChange('scanning');
      this.intentionalDisconnect = false;
      this.reconnectAttempts = 0;
      this.deviceInfo = null;
      this.pkgNumber = 0;

      this.device = await navigator.bluetooth.requestDevice({
        filters: [
          { services: [VIATOM_SERVICE_UUID] },
          { namePrefix: 'Checkme' },
          { namePrefix: 'CheckMe' },
          { namePrefix: 'AirBP' },
          { namePrefix: 'Viatom' },
          { namePrefix: 'PC-68B' },
          { namePrefix: 'O2Ring' },
        ],
        optionalServices: [VIATOM_SERVICE_UUID],
      });

      console.log(`[BLE] Device selected: ${this.device.name}`);

      this.device.addEventListener('gattserverdisconnected', () => {
        this.handleDisconnection();
      });

      return await this.connect();
    } catch (error) {
      const err = error as Error;
      if (err.name === 'NotFoundError') {
        this.callbacks.onConnectionChange('disconnected');
      } else {
        console.error('[BLE] Scan error:', err);
        this.callbacks.onError(`Scan failed: ${err.message}`);
        this.callbacks.onConnectionChange('error');
      }
      return false;
    }
  }

  disconnect(): void {
    this.intentionalDisconnect = true;
    this.isStreaming = false;
    this.isDownloading = false;
    this.stopKeepAlive();

    if (this.server?.connected) {
      this.server.disconnect();
    }

    this.device = null;
    this.server = null;
    this.writeCharacteristic = null;
    this.notifyCharacteristic = null;
    this.packetBuffer = new Uint8Array(0);
    this.deviceInfo = null;

    this.callbacks.onConnectionChange('disconnected');
  }

  get connected(): boolean {
    return this.server?.connected ?? false;
  }

  get deviceName(): string | undefined {
    return this.device?.name ?? undefined;
  }

  /**
   * Request stored data download from device.
   * Call after connection is established.
   */
  async downloadStoredData(): Promise<void> {
    if (!this.writeCharacteristic || !this.server?.connected) {
      this.callbacks.onError('Not connected to device');
      return;
    }

    console.log('[BLE] Starting stored data download...');
    this.isDownloading = true;

    try {
      // Send READ_START command to initiate data transfer
      await this.sendCommand(this.buildCommand(CMD_READ_START));
      console.log('[BLE] READ_START sent');

      // Wait for data to arrive (device sends response packets)
      // The response handler will collect data and call downloadComplete
      // Set a timeout in case the device has no data
      if (this.downloadTimeout) clearTimeout(this.downloadTimeout);
      this.downloadTimeout = setTimeout(() => {
        if (this.isDownloading) {
          console.log('[BLE] Download timeout — device may have no stored data');
          this.finishDownload();
        }
      }, 5000);
    } catch (e) {
      console.error('[BLE] Download error:', e);
      this.isDownloading = false;
      this.callbacks.onError('Failed to download stored data');
    }
  }

  // ─── Connection ──────────────────────────────────────

  private async connect(): Promise<boolean> {
    if (!this.device?.gatt) return false;
    if (this.intentionalDisconnect) return false;

    try {
      this.callbacks.onConnectionChange('connecting');

      // Step 1: Connect GATT
      this.server = await this.device.gatt.connect();
      console.log('[BLE] GATT server connected');

      await this.delay(300);
      if (!this.server?.connected) return false;

      // Step 2: Discover service + characteristics
      const service = await this.server.getPrimaryService(VIATOM_SERVICE_UUID);
      console.log('[BLE] Viatom service found');

      try {
        this.writeCharacteristic = await service.getCharacteristic(WRITE_CHARACTERISTIC_UUID);
        console.log('[BLE] Write characteristic ready');
      } catch (e) {
        console.warn('[BLE] Write characteristic not available:', e);
      }

      try {
        this.notifyCharacteristic = await service.getCharacteristic(NOTIFY_CHARACTERISTIC_UUID);
        console.log('[BLE] Notify characteristic found');
      } catch (e) {
        console.warn('[BLE] Notify characteristic not available:', e);
      }

      // Step 3: Subscribe to notifications
      if (this.notifyCharacteristic) {
        await this.notifyCharacteristic.startNotifications();
        this.notifyCharacteristic.addEventListener('characteristicvaluechanged', (event) => {
          this.handleNotification(event);
        });
        console.log('[BLE] Notify subscribed');
      }

      // Step 4: Start keep-alive IMMEDIATELY (before any commands)
      // This prevents the device from disconnecting during initialization
      this.startKeepAlive();

      // Step 5: Send PING first to establish bidirectional communication
      await this.sendPing();

      // Step 6: Get device info
      await this.sendGetDeviceInfo();

      // Wait for device info response (handled async in notification handler)
      await this.delay(1500);

      // Mark as connected regardless of device mode
      if (!this.server?.connected || this.intentionalDisconnect) {
        this.stopKeepAlive();
        return false;
      }

      const name = this.device?.name || 'Checkme Pro';
      this.callbacks.onConnectionChange('connected', name);
      this.isStreaming = true;

      // If device is in MODE_HOME, notify but stay connected
      if (this.deviceInfo?.Application === 'MODE_HOME') {
        console.log('[BLE] Connected in MODE_HOME — can download stored data or start a measurement on device');
      }

      return true;
    } catch (error) {
      if (this.intentionalDisconnect) return false;
      const err = error as Error;
      console.error('[BLE] Connection error:', err);
      this.callbacks.onError(`Connection failed: ${err.message}`);
      this.callbacks.onConnectionChange('error');
      this.stopKeepAlive();
      return false;
    }
  }

  // ─── Commands ────────────────────────────────────────

  private calCRC8(buf: Uint8Array): number {
    let crc = 0;
    for (let i = 0; i < buf.length - 1; i++) {
      crc = TABLE_CRC8[0xff & (crc ^ buf[i])];
    }
    return crc;
  }

  private buildCommand(cmd: number, content?: Uint8Array): Uint8Array {
    const contentLen = content?.length ?? 0;
    const buf = new Uint8Array(8 + contentLen);
    buf[0] = CMD_HEADER;
    buf[1] = cmd;
    buf[2] = (~cmd) & 0xFF;
    buf[3] = this.pkgNumber & 0xFF;
    buf[4] = (this.pkgNumber >> 8) & 0xFF;
    buf[5] = contentLen & 0xFF;
    buf[6] = (contentLen >> 8) & 0xFF;
    if (content) {
      buf.set(content, 7);
    }
    buf[buf.length - 1] = this.calCRC8(buf);
    this.pkgNumber++;
    return buf;
  }

  private async sendCommand(cmd: Uint8Array): Promise<void> {
    if (!this.writeCharacteristic) return;
    try {
      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      await this.writeCharacteristic.writeValueWithoutResponse(cmd as any);
    } catch (e) {
      console.warn('[BLE] Failed to send command:', e);
    }
  }

  private async sendPing(): Promise<void> {
    if (!this.writeCharacteristic || !this.server?.connected) return;
    await this.sendCommand(this.buildCommand(CMD_PING));
    console.log('[BLE] PING sent');
  }

  private async sendGetDeviceInfo(): Promise<void> {
    if (!this.writeCharacteristic) return;
    await this.sendCommand(this.buildCommand(CMD_GET_INFO));
    console.log('[BLE] GetDeviceInfo sent');
  }

  // ─── Keep-alive ──────────────────────────────────────

  private startKeepAlive(): void {
    this.stopKeepAlive();
    // Send PING every 2 seconds to prevent idle disconnect
    this.keepAliveTimer = setInterval(async () => {
      if (this.server?.connected && this.writeCharacteristic && !this.intentionalDisconnect) {
        try {
          await this.sendPing();
        } catch {
          // Disconnect handler will take care of it
        }
      }
    }, 2000);
  }

  private stopKeepAlive(): void {
    if (this.keepAliveTimer) {
      clearInterval(this.keepAliveTimer);
      this.keepAliveTimer = null;
    }
  }

  private delay(ms: number): Promise<void> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  // ─── Notification handling ───────────────────────────

  private handleNotification(event: Event): void {
    const characteristic = event.target as BluetoothRemoteGATTCharacteristic;
    const dataView = characteristic.value;
    if (!dataView) return;

    const incoming = new Uint8Array(dataView.buffer);
    const hex = Array.from(incoming).map(b => b.toString(16).padStart(2, '0')).join(' ');
    console.log(`[BLE] Notify (${incoming.length}B): ${hex}`);

    // Append to buffer
    const combined = new Uint8Array(this.packetBuffer.length + incoming.length);
    combined.set(this.packetBuffer);
    combined.set(incoming, this.packetBuffer.length);
    this.packetBuffer = combined;

    this.processBuffer();
  }

  private processBuffer(): void {
    while (this.packetBuffer.length >= 4) {
      const firstByte = this.packetBuffer[0];

      // Data sync response: starts with 0x55
      if (firstByte === 0x55) {
        if (this.packetBuffer.length < 8) return;
        const len = (this.packetBuffer[5] & 0xff) + ((this.packetBuffer[6] & 0xff) << 8);
        const totalSize = 8 + len;
        if (this.packetBuffer.length < totalSize) return;

        const packet = this.packetBuffer.slice(0, totalSize);
        this.packetBuffer = this.packetBuffer.slice(totalSize);

        this.handleSyncResponse(packet, len);
        continue;
      }

      // Monitor RT data: starts with 0xA5 0x5A
      if (firstByte === 0xA5 && this.packetBuffer.length > 1 && this.packetBuffer[1] === 0x5A) {
        if (this.packetBuffer.length < 3) return;
        const packetSize = this.packetBuffer[2];
        const totalSize = packetSize + 3;
        if (this.packetBuffer.length < totalSize) return;

        const packet = this.packetBuffer.slice(0, totalSize);
        this.packetBuffer = this.packetBuffer.slice(totalSize);

        try {
          const parsed = this.parseRtPacket(packet);
          if (parsed) this.dispatchRtData(parsed);
        } catch (e) {
          console.warn('[BLE] RT packet parse error:', e);
        }
        continue;
      }

      // Unknown byte — skip
      this.packetBuffer = this.packetBuffer.slice(1);
    }
  }

  private handleSyncResponse(packet: Uint8Array, len: number): void {
    const cmd = packet[1] & 0xff;
    console.log(`[BLE] Response: cmd=0x${cmd.toString(16)}, len=${len}`);

    // Extract content
    const content = len > 0 ? packet.slice(7, 7 + len) : null;

    // Handle by command type
    switch (cmd) {
      case CMD_GET_INFO & 0xFF:
      case 0x00: // Sometimes device info comes as cmd 0
        this.handleDeviceInfoResponse(content, len);
        break;

      case CMD_READ_START & 0xFF:
        console.log('[BLE] READ_START acknowledged');
        // Device accepted read — now request packages
        this.requestNextPackage();
        break;

      case CMD_READ_PKG & 0xFF:
        console.log(`[BLE] READ_PKG received (${len} bytes)`);
        if (content && len > 0) {
          this.downloadBuffer.push(content);
          // Request next package
          this.requestNextPackage();
        } else {
          // Empty package = no more data
          this.finishDownload();
        }
        break;

      case CMD_READ_END & 0xFF:
        console.log('[BLE] READ_END received');
        this.finishDownload();
        break;

      case CMD_PING & 0xFF:
        // Ping acknowledged — connection alive
        break;

      default:
        console.log(`[BLE] Unhandled response cmd=0x${cmd.toString(16)}`);
        // If downloading, this might be data
        if (this.isDownloading && content && len > 0) {
          this.downloadBuffer.push(content);
        }
        break;
    }
  }

  private handleDeviceInfoResponse(content: Uint8Array | null, len: number): void {
    if (!content || len < 10) return;

    try {
      const jsonStart = content.indexOf(0x7B); // '{'
      const jsonEnd = content.lastIndexOf(0x7D); // '}'
      if (jsonStart >= 0 && jsonEnd > jsonStart) {
        const jsonStr = new TextDecoder().decode(content.slice(jsonStart, jsonEnd + 1));
        this.deviceInfo = JSON.parse(jsonStr);
        console.log('[BLE] Device info:', this.deviceInfo);

        if (this.deviceInfo) {
          this.callbacks.onDeviceInfo(this.deviceInfo);

          // Update device name with SN
          if (this.deviceInfo.SN) {
            const name = `Checkme ${this.deviceInfo.SN}`.trim();
            this.callbacks.onConnectionChange('connected', name);
          }

          if (this.deviceInfo.Application) {
            console.log(`[BLE] Device mode: ${this.deviceInfo.Application}`);
          }
        }
      }
    } catch {
      // Not JSON — that's fine
    }
  }

  private async requestNextPackage(): Promise<void> {
    if (!this.isDownloading || !this.writeCharacteristic) return;
    try {
      await this.sendCommand(this.buildCommand(CMD_READ_PKG));
      console.log('[BLE] READ_PKG requested');

      // Reset download timeout
      if (this.downloadTimeout) clearTimeout(this.downloadTimeout);
      this.downloadTimeout = setTimeout(() => {
        if (this.isDownloading) {
          this.finishDownload();
        }
      }, 3000);
    } catch (e) {
      console.warn('[BLE] Failed to request package:', e);
      this.finishDownload();
    }
  }

  private finishDownload(): void {
    if (this.downloadTimeout) {
      clearTimeout(this.downloadTimeout);
      this.downloadTimeout = null;
    }

    this.isDownloading = false;

    // Send READ_END to tell device we're done
    if (this.writeCharacteristic && this.server?.connected) {
      this.sendCommand(this.buildCommand(CMD_READ_END)).catch(() => {});
    }

    if (this.downloadBuffer.length === 0) {
      console.log('[BLE] No stored data received from device');
      this.callbacks.onStoredData([]);
      return;
    }

    // Combine all downloaded chunks
    const totalLen = this.downloadBuffer.reduce((sum, buf) => sum + buf.length, 0);
    const combined = new Uint8Array(totalLen);
    let offset = 0;
    for (const buf of this.downloadBuffer) {
      combined.set(buf, offset);
      offset += buf.length;
    }
    this.downloadBuffer = [];

    console.log(`[BLE] Downloaded ${totalLen} bytes of stored data`);

    // Try to parse as records
    const records = this.parseStoredData(combined);
    this.callbacks.onStoredData(records);
  }

  private parseStoredData(data: Uint8Array): StoredRecord[] {
    const records: StoredRecord[] = [];

    // Try to parse as JSON first (some Checkme firmware sends JSON records)
    try {
      const text = new TextDecoder().decode(data);
      // Look for JSON objects
      const jsonMatches = text.match(/\{[^{}]+\}/g);
      if (jsonMatches) {
        for (const match of jsonMatches) {
          try {
            const obj = JSON.parse(match);
            records.push({
              type: this.inferRecordType(obj),
              timestamp: obj.timestamp || obj.time || Date.now(),
              data: obj,
            });
          } catch {
            // Not valid JSON
          }
        }
      }
    } catch {
      // Binary data — parse as raw records
    }

    // If no JSON records, store as raw binary
    if (records.length === 0 && data.length > 0) {
      records.push({
        type: 'ecg',
        timestamp: Date.now(),
        data: { rawBytes: data.length, format: 'binary' },
        raw: data,
      });
    }

    return records;
  }

  private inferRecordType(obj: Record<string, unknown>): StoredRecord['type'] {
    if ('ecg' in obj || 'ECG' in obj || 'heartRate' in obj) return 'ecg';
    if ('spo2' in obj || 'SpO2' in obj) return 'spo2';
    if ('systolic' in obj || 'diastolic' in obj || 'BP' in obj) return 'bp';
    if ('temperature' in obj || 'temp' in obj) return 'temperature';
    return 'ecg'; // default
  }

  // ─── RT data parsing ─────────────────────────────────

  private parseRtPacket(buf: Uint8Array): CheckmeRtPacket | null {
    if (buf.length < 44) return null;

    let index = 3; // Skip header (2) + size (1)
    index++; // ECG type

    const ecgSamples: number[] = [];
    const ecgMv: number[] = [];
    for (let i = 0; i < SAMPLES_PER_PACKET; i++) {
      const sample = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
      ecgSamples.push(sample);
      ecgMv.push(sample * ECG_MV_FACTOR);
      index += 2;
    }

    const heartRate = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8); index += 2;
    const qrs = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8); index += 2;
    const st = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8); index += 2;
    const pvcs = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8); index += 2;
    const isRMark = buf[index] !== 0x00; index++;
    index++; // note
    index++; // spo2_type

    const spo2Samples: number[] = [];
    for (let i = 0; i < SAMPLES_PER_PACKET; i++) {
      const sample = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
      spo2Samples.push(sample);
      index += 2;
    }

    const pulseRate = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8); index += 2;
    const spo2 = buf[index] & 0xff; index++;
    const pi = buf[index] & 0xff; index++;
    const isPulseMark = buf[index] !== 0x00; index++;
    index++; // note
    index++; // 0xF1
    const battery = buf[index] & 0xff;

    return { ecgSamples, ecgMv, heartRate, qrs, st, pvcs, isRMark, spo2Samples, pulseRate, spo2, pi, isPulseMark, battery };
  }

  private dispatchRtData(packet: CheckmeRtPacket): void {
    const now = Date.now();

    const ecgSamples: ECGSample[] = packet.ecgSamples.map((value, i) => ({
      timestamp: now + i * (PACKET_INTERVAL_MS / SAMPLES_PER_PACKET),
      value,
      leadOff: false,
    }));
    this.callbacks.onECGData(ecgSamples);

    if (packet.spo2 > 0 && packet.spo2 <= 100) {
      this.callbacks.onSpO2Data({
        timestamp: now,
        spo2: packet.spo2,
        heartRate: packet.heartRate > 0 ? packet.heartRate : packet.pulseRate,
        perfusionIndex: (packet.pi / 10).toFixed(1),
      });
    }
  }

  // ─── Disconnection handling ──────────────────────────

  private async handleDisconnection(): Promise<void> {
    console.log('[BLE] Device disconnected');
    this.isStreaming = false;
    this.isDownloading = false;
    this.stopKeepAlive();
    this.writeCharacteristic = null;
    this.notifyCharacteristic = null;
    this.server = null;
    this.packetBuffer = new Uint8Array(0);

    if (this.intentionalDisconnect) {
      this.callbacks.onConnectionChange('disconnected');
      return;
    }

    // Auto-reconnect for unexpected disconnections
    if (this.reconnectAttempts < MAX_RECONNECT_ATTEMPTS && this.device) {
      this.callbacks.onConnectionChange('reconnecting');
      this.reconnectAttempts++;

      const delay = INITIAL_RECONNECT_DELAY * Math.pow(2, this.reconnectAttempts - 1);
      console.log(`[BLE] Reconnect attempt ${this.reconnectAttempts}/${MAX_RECONNECT_ATTEMPTS} in ${delay}ms`);

      await new Promise(resolve => setTimeout(resolve, delay));

      if (this.device && !this.intentionalDisconnect) {
        await this.connect();
      }
    } else {
      this.callbacks.onConnectionChange('disconnected');
      if (this.reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) {
        this.callbacks.onError('Device disconnected after max reconnection attempts.');
      }
    }
  }
}
