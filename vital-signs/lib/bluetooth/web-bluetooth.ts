/**
 * Web Bluetooth API Manager for Viatom Checkme Suit
 * 
 * Based on the official Viatom BLE protocol from:
 * https://github.com/viatom-develop/LepuBle (MonitorBleManager.java + MonitorRtData.java)
 * 
 * Protocol details:
 * - Service UUID: 14839ac4-7d7e-415c-9a42-167340cf2339
 * - Write characteristic: 8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3 (commands, write-no-response)
 * - Notify characteristic: 0734594A-A8E7-4B1A-A6B1-CD5243059A57 (all real-time data)
 * 
 * Data packet (sent every ~40ms = 25 packets/sec):
 *   [0xA5, 0x5A] header
 *   [pkg_size]
 *   [ecg_type]
 *   [5x ECG samples, 2 bytes each, little-endian uint16]
 *   [HR, 2 bytes LE]
 *   [QRS, 2 bytes]
 *   [ST, 2 bytes]
 *   [PVCs, 2 bytes]
 *   [R-wave mark, 1 byte]
 *   [note, 1 byte]
 *   [spo2_type, 1 byte]
 *   [5x SpO2 wave samples, 2 bytes each]
 *   [PR, 2 bytes LE]
 *   [SpO2, 1 byte]
 *   [PI, 1 byte]
 *   [pulse_mark, 1 byte]
 *   [note, 1 byte]
 *   [0xF1]
 *   [battery, 1 byte]
 *   [CRC]
 * 
 * Total: ~44 bytes per packet
 * Effective ECG rate: 5 samples × 25 packets/sec = 125 Hz real-time
 * (500Hz is for the Holter recording mode)
 */

import { ECGSample, SpO2Reading, BLECallbacks, ConnectionStatus } from '@/lib/types';

// Viatom GATT UUIDs (from official MonitorBleManager.java)
const VIATOM_SERVICE_UUID = '14839ac4-7d7e-415c-9a42-167340cf2339';
const WRITE_CHARACTERISTIC_UUID = '8b00ace7-eb0b-49b0-bbe9-9aee0a26e1a3';
const NOTIFY_CHARACTERISTIC_UUID = '0734594a-a8e7-4b1a-a6b1-cd5243059a57';

// Protocol constants
const HEADER_BYTE_1 = 0xA5;
const HEADER_BYTE_2 = 0x5A;
const PACKET_INTERVAL_MS = 40; // Device sends every ~40ms
const SAMPLES_PER_PACKET = 5;  // 5 ECG + 5 SpO2 samples per packet

// Checkme Pro command protocol (from CheckMe_BLE_Demo/ce branch):
// Commands: [0xAA, cmd, ~cmd, pkg_no(2), len(2), CRC8]
// Responses: [0x55, cmd, ~cmd, pkg_no(2), len(2), content(len), CRC8]
const CMD_HEADER = 0xAA;
const CMD_PING = 0x15;
const CMD_GET_INFO = 0x14;

// Monitor mode RT data command (from LepuBle MonitorBleInterface)
const RT_DATA_COMMAND = 0x00;

// ECG voltage conversion factor from official SDK:
// sample * 4033 / 32767 / 12 / 8.0  → millivolts
const ECG_MV_FACTOR = 4033 / 32767 / 12 / 8.0;

// Reconnection
const MAX_RECONNECT_ATTEMPTS = 5;
const INITIAL_RECONNECT_DELAY = 1000;

/**
 * Check if Web Bluetooth is supported in the current browser
 */
export function isWebBluetoothSupported(): boolean {
  return typeof navigator !== 'undefined' && 'bluetooth' in navigator;
}

/**
 * Parsed real-time data packet from Checkme Pro
 */
interface CheckmeRtPacket {
  ecgSamples: number[];      // 5 raw ECG samples (uint16)
  ecgMv: number[];           // 5 ECG samples in millivolts
  heartRate: number;
  qrs: number;
  st: number;
  pvcs: number;
  isRMark: boolean;          // R-wave marker (for heart sound)
  spo2Samples: number[];     // 5 raw SpO2 wave samples
  pulseRate: number;
  spo2: number;              // SpO2 percentage (0-100)
  pi: number;                // Perfusion Index
  isPulseMark: boolean;      // Pulse detected marker
  battery: number;           // Battery level (0-100)
}

export class WebBluetoothManager {
  private device: BluetoothDevice | null = null;
  private server: BluetoothRemoteGATTServer | null = null;
  private writeCharacteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private notifyCharacteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private reconnectAttempts = 0;
  private callbacks: BLECallbacks;
  private isStreaming = false;
  private packetBuffer: Uint8Array = new Uint8Array(0);
  private deviceMode: string | null = null;
  private isDisconnecting = false;       // Flag to prevent race conditions
  private intentionalDisconnect = false;  // Flag for user-initiated disconnect

  constructor(callbacks: BLECallbacks) {
    this.callbacks = callbacks;
  }

  /**
   * Request and connect to a Viatom device.
   * Must be called from a user gesture (click/tap) — Web Bluetooth requirement.
   */
  async requestDevice(): Promise<boolean> {
    if (!isWebBluetoothSupported()) {
      this.callbacks.onError('Web Bluetooth is not supported. Please use Chrome or Edge on desktop.');
      return false;
    }

    try {
      this.callbacks.onConnectionChange('scanning');
      this.intentionalDisconnect = false;
      this.isDisconnecting = false;
      this.reconnectAttempts = 0;
      this.deviceMode = null;

      // Request device — user will see the Chrome BLE picker dialog.
      // Many BLE devices don't advertise service UUIDs, only their name.
      // Use multiple filter entries (OR logic) to match by service OR by name.
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
        // Must list services here too so we can access them after connecting
        // (Web Bluetooth requires services in filters or optionalServices)
        optionalServices: [VIATOM_SERVICE_UUID],
      });

      console.log(`[BLE] Device selected: ${this.device.name}`);

      // Listen for disconnection
      this.device.addEventListener('gattserverdisconnected', () => {
        this.handleDisconnection();
      });

      // Connect to GATT server
      return await this.connect();
    } catch (error) {
      const err = error as Error;
      if (err.name === 'NotFoundError') {
        // User cancelled the device picker — not an error
        this.callbacks.onConnectionChange('disconnected');
      } else {
        console.error('[BLE] Scan error:', err);
        this.callbacks.onError(`Scan failed: ${err.message}`);
        this.callbacks.onConnectionChange('error');
      }
      return false;
    }
  }

  /**
   * Connect to the selected device's GATT server and set up characteristics.
   * 
   * Connection sequence (based on official Viatom SDK):
   * 1. Connect GATT server
   * 2. Discover service + characteristics
   * 3. Subscribe to notifications
   * 4. Send GetDeviceInfo to establish communication
   * 5. Start keep-alive if device is in measurement mode
   */
  private async connect(): Promise<boolean> {
    if (!this.device?.gatt) return false;
    if (this.isDisconnecting) return false;

    try {
      this.callbacks.onConnectionChange('connecting');
      this.deviceMode = null;

      // Step 1: Connect to GATT server
      this.server = await this.device.gatt.connect();
      console.log('[BLE] GATT server connected');

      // Check if disconnected during async operation
      if (this.isDisconnecting || !this.server?.connected) return false;

      // Small delay to let the connection stabilize
      await this.delay(500);

      if (this.isDisconnecting || !this.server?.connected) return false;

      // Step 2: Discover service
      const service = await this.server.getPrimaryService(VIATOM_SERVICE_UUID);
      console.log('[BLE] Viatom service found');

      // Step 3: Get BOTH characteristics before doing anything else
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

      if (this.isDisconnecting) return false;

      // Step 4: Subscribe to notifications FIRST (before sending any commands).
      // This ensures we don't miss any response from the device.
      if (this.notifyCharacteristic) {
        try {
          await this.notifyCharacteristic.startNotifications();
          this.notifyCharacteristic.addEventListener('characteristicvaluechanged', (event) => {
            this.handleNotification(event);
          });
          console.log('[BLE] Notify subscribed');
        } catch (e) {
          console.warn('[BLE] Failed to subscribe to notifications:', e);
          this.callbacks.onError('Could not subscribe to device notifications');
        }
      }

      if (this.isDisconnecting) return false;

      // Step 5: Initialize communication with proper protocol commands.
      // Must happen quickly after notification subscription to prevent idle disconnect.
      await this.initializeCommunication();

      // Check again — device may have disconnected during initialization
      if (this.isDisconnecting || !this.server?.connected) {
        console.log('[BLE] Device disconnected during initialization');
        return false;
      }

      const deviceName = this.device?.name || 'Checkme Pro';
      this.callbacks.onConnectionChange('connected', deviceName);
      this.isStreaming = true;

      // Step 6: Start keep-alive PING every 2 seconds
      this.startKeepAlive();

      return true;
    } catch (error) {
      if (this.isDisconnecting || this.intentionalDisconnect) return false;
      const err = error as Error;
      console.error('[BLE] Connection error:', err);
      this.callbacks.onError(`Connection failed: ${err.message}`);
      this.callbacks.onConnectionChange('error');
      return false;
    }
  }

  /**
   * CRC8 calculation — matches BleCRC.calCRC8() from the official SDK.
   */
  private calCRC8(buf: Uint8Array): number {
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
    let crc = 0;
    for (let i = 0; i < buf.length - 1; i++) {
      crc = TABLE_CRC8[0xff & (crc ^ buf[i])];
    }
    return crc;
  }

  /**
   * Build a Checkme Pro command packet.
   * Format: [0xAA, cmd, ~cmd, pkgNo(2), len(2), CRC8]
   */
  private buildCommand(cmd: number): Uint8Array {
    const buf = new Uint8Array(8);
    buf[0] = CMD_HEADER;        // 0xAA
    buf[1] = cmd;               // command word
    buf[2] = (~cmd) & 0xFF;     // inverse of command
    buf[3] = 0;                 // pkg number low
    buf[4] = 0;                 // pkg number high
    buf[5] = 0;                 // content length low
    buf[6] = 0;                 // content length high
    buf[7] = this.calCRC8(buf); // CRC8
    return buf;
  }

  /**
   * Send a command to the device.
   */
  private async sendCommand(cmd: Uint8Array): Promise<void> {
    if (!this.writeCharacteristic) return;
    try {
      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      await this.writeCharacteristic.writeValueWithoutResponse(cmd as any);
    } catch (e) {
      console.warn('[BLE] Failed to send command:', e);
    }
  }

  /**
   * Send PING command to keep connection alive.
   * From official SDK: CMD_WORD_PING = 0x15
   */
  private async sendPing(): Promise<void> {
    if (!this.writeCharacteristic || !this.server?.connected) return;
    const cmd = this.buildCommand(CMD_PING);
    await this.sendCommand(cmd);
    console.log('[BLE] PING sent');
  }

  /**
   * Send GetDeviceInfo command.
   * From official SDK: CMD_WORD_GET_INFO = 0x14
   */
  private async sendGetDeviceInfo(): Promise<void> {
    const cmd = this.buildCommand(CMD_GET_INFO);
    await this.sendCommand(cmd);
    console.log('[BLE] GetDeviceInfo sent');
  }

  /**
   * Send monitor-mode RT data command.
   * From LepuBle: byteArrayOfInts(0) = single byte 0x00
   */
  private async sendRtDataCommand(): Promise<void> {
    await this.sendCommand(new Uint8Array([RT_DATA_COMMAND]));
    console.log('[BLE] RT data command sent');
  }

  /**
   * Initialize communication with the device.
   * 1. GetDeviceInfo — establishes communication & retrieves device state
   * 2. PING — confirms connection is alive
   * 
   * NOTE: Do NOT send raw 0x00 RT data command — it causes disconnect
   * when device is in MODE_HOME. Real-time data streams when the user
   * starts a measurement on the device (ECG, SpO2, etc).
   */
  private async initializeCommunication(): Promise<void> {
    await this.sendGetDeviceInfo();
    await this.delay(300);
    await this.sendPing();
  }

  /**
   * Keep-alive: periodically send PING to prevent idle disconnect.
   */
  private keepAliveTimer: ReturnType<typeof setInterval> | null = null;

  private startKeepAlive(): void {
    this.stopKeepAlive();
    this.keepAliveTimer = setInterval(async () => {
      if (this.server?.connected && this.writeCharacteristic && !this.isDisconnecting) {
        try {
          await this.sendPing();
        } catch {
          // Ignore — disconnect handler will take care of it
        }
      }
    }, 2000); // Every 2 seconds
  }

  private stopKeepAlive(): void {
    if (this.keepAliveTimer) {
      clearInterval(this.keepAliveTimer);
      this.keepAliveTimer = null;
    }
  }

  /** Simple delay helper */
  private delay(ms: number): Promise<void> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  /**
   * Handle incoming BLE notifications.
   * 
   * The Checkme Pro may send:
   * 1. Data sync responses: header 0x55 (file transfer, device info, ping ack)
   * 2. Monitor RT data: header 0xA5 0x5A (ECG + SpO2 + vitals)
   * 
   * Packets may be split across multiple BLE notifications due to MTU limits.
   */
  private handleNotification(event: Event): void {
    const characteristic = event.target as BluetoothRemoteGATTCharacteristic;
    const dataView = characteristic.value;
    if (!dataView) return;

    // Log raw data for debugging
    const incoming = new Uint8Array(dataView.buffer);
    const hex = Array.from(incoming).map(b => b.toString(16).padStart(2, '0')).join(' ');
    console.log(`[BLE] Notify (${incoming.length}B): ${hex}`);

    // Append incoming data to buffer
    const combined = new Uint8Array(this.packetBuffer.length + incoming.length);
    combined.set(this.packetBuffer);
    combined.set(incoming, this.packetBuffer.length);
    this.packetBuffer = combined;

    // Process complete packets from buffer
    this.processBuffer();
  }

  /**
   * Process buffered data, extracting complete packets.
   * Recognizes two packet types:
   * - Monitor RT data: [0xA5, 0x5A, size, ...]
   * - Data sync response: [0x55, cmd, ~cmd, pkgNo(2), len(2), content(len), CRC8]
   */
  private processBuffer(): void {
    while (this.packetBuffer.length >= 4) {
      const firstByte = this.packetBuffer[0];

      // Data sync response: starts with 0x55
      if (firstByte === 0x55) {
        if (this.packetBuffer.length < 8) return; // Need at least 8 bytes
        const len = (this.packetBuffer[5] & 0xff) + ((this.packetBuffer[6] & 0xff) << 8);
        const totalSize = 8 + len;
        if (this.packetBuffer.length < totalSize) return; // Wait for full packet

        const packet = this.packetBuffer.slice(0, totalSize);
        this.packetBuffer = this.packetBuffer.slice(totalSize);

        const cmd = packet[1] & 0xff;
        console.log(`[BLE] Data sync response: cmd=0x${cmd.toString(16)}, len=${len}`);

        // Try to decode content as text (device info is JSON)
        if (len > 10) {
          try {
            const content = packet.slice(7, 7 + len);
            // Find the JSON part (starts with '{', ends with '}')
            const jsonStart = content.indexOf(0x7B); // '{'
            const jsonEnd = content.lastIndexOf(0x7D); // '}'
            if (jsonStart >= 0 && jsonEnd > jsonStart) {
              const jsonStr = new TextDecoder().decode(content.slice(jsonStart, jsonEnd + 1));
              const deviceInfo = JSON.parse(jsonStr);
              console.log('[BLE] Device info:', deviceInfo);
              // Update connection name with device model + SN
              if (deviceInfo.Model || deviceInfo.SN) {
                const name = `Checkme ${deviceInfo.SN || ''}`.trim();
                this.callbacks.onConnectionChange('connected', name);
              }
              // Track application mode — important for knowing if RT data is available
              if (deviceInfo.Application) {
                this.deviceMode = deviceInfo.Application;
                console.log(`[BLE] Device mode: ${this.deviceMode}`);
                if (this.deviceMode === 'MODE_HOME') {
                  console.log('[BLE] Device is on home screen. Start a measurement (ECG/SpO2) on the device for real-time data.');
                  this.callbacks.onError('Device is on home screen. Please start a measurement (ECG or SpO2) on the Checkme Pro, then reconnect.');
                }
              }
            }
          } catch {
            // Not JSON content — that's fine
          }
        }
        continue;
      }

      // Monitor RT data: starts with 0xA5, 0x5A
      if (firstByte === 0xA5 && this.packetBuffer.length > 1 && this.packetBuffer[1] === 0x5A) {
        if (this.packetBuffer.length < 3) return;
        const packetSize = this.packetBuffer[2]; // pkg_size field
        const totalSize = packetSize + 3; // header (2) + size byte (1) + data (packetSize)

        if (this.packetBuffer.length < totalSize) return; // Wait for full packet

        const packet = this.packetBuffer.slice(0, totalSize);
        this.packetBuffer = this.packetBuffer.slice(totalSize);

        try {
          const parsed = this.parsePacket(packet);
          if (parsed) {
            this.dispatchParsedData(parsed);
          }
        } catch (e) {
          console.warn('[BLE] RT packet parse error:', e);
        }
        continue;
      }

      // Unknown byte — skip it
      console.log(`[BLE] Skipping unknown byte: 0x${firstByte.toString(16)}`);
      this.packetBuffer = this.packetBuffer.slice(1);
    }
  }

  /**
   * Parse a complete Checkme real-time data packet.
   * Based on MonitorRtData.java from the official Viatom SDK.
   */
  private parsePacket(buf: Uint8Array): CheckmeRtPacket | null {
    if (buf.length < 44) {
      // Packet too short for RT data
      return null;
    }

    let index = 0;

    // Header: 0xA5, 0x5A
    index += 2;

    // Package size
    // const pkgSize = buf[index];
    index++;

    // ECG type
    index++;

    // 5 ECG samples (2 bytes each, little-endian unsigned 16-bit)
    const ecgSamples: number[] = [];
    const ecgMv: number[] = [];
    for (let i = 0; i < SAMPLES_PER_PACKET; i++) {
      const sample = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
      ecgSamples.push(sample);
      ecgMv.push(sample * ECG_MV_FACTOR);
      index += 2;
    }

    // Heart rate (2 bytes LE)
    const heartRate = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
    index += 2;

    // QRS duration (2 bytes)
    const qrs = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
    index += 2;

    // ST segment (2 bytes)
    const st = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
    index += 2;

    // PVCs (2 bytes)
    const pvcs = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
    index += 2;

    // R-wave mark
    const isRMark = buf[index] !== 0x00;
    index++;

    // Note
    index++;

    // SpO2 type
    index++;

    // 5 SpO2 wave samples (2 bytes each)
    const spo2Samples: number[] = [];
    for (let i = 0; i < SAMPLES_PER_PACKET; i++) {
      const sample = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
      spo2Samples.push(sample);
      index += 2;
    }

    // Pulse rate (2 bytes LE)
    const pulseRate = (buf[index] & 0xff) + ((buf[index + 1] & 0xff) << 8);
    index += 2;

    // SpO2 percentage (1 byte)
    const spo2 = buf[index] & 0xff;
    index++;

    // Perfusion Index (1 byte)
    const pi = buf[index] & 0xff;
    index++;

    // Pulse mark
    const isPulseMark = buf[index] !== 0x00;
    index++;

    // Note
    index++;

    // 0xF1 marker
    index++;

    // Battery level
    const battery = buf[index] & 0xff;

    return {
      ecgSamples,
      ecgMv,
      heartRate,
      qrs,
      st,
      pvcs,
      isRMark,
      spo2Samples,
      pulseRate,
      spo2,
      pi,
      isPulseMark,
      battery,
    };
  }

  /**
   * Dispatch parsed packet data to the appropriate callbacks
   */
  private dispatchParsedData(packet: CheckmeRtPacket): void {
    const now = Date.now();

    // ECG samples (5 per packet, ~40ms apart total → 8ms between samples)
    const ecgSamples: ECGSample[] = packet.ecgSamples.map((value, i) => ({
      timestamp: now + i * (PACKET_INTERVAL_MS / SAMPLES_PER_PACKET),
      value,
      leadOff: false,
    }));
    this.callbacks.onECGData(ecgSamples);

    // SpO2 + Heart Rate (valid if non-zero)
    if (packet.spo2 > 0 && packet.spo2 <= 100) {
      this.callbacks.onSpO2Data({
        timestamp: now,
        spo2: packet.spo2,
        heartRate: packet.heartRate > 0 ? packet.heartRate : packet.pulseRate,
        perfusionIndex: (packet.pi / 10).toFixed(1), // PI is stored as x10
      });
    }

    // Battery level could be displayed too (not currently in UI)
    // console.log(`[BLE] Battery: ${packet.battery}%`);
  }

  /**
   * Handle device disconnection — attempt auto-reconnect only if appropriate.
   * 
   * Do NOT reconnect when:
   * - User intentionally disconnected
   * - Device is in MODE_HOME (no measurement active — reconnect would just fail again)
   * - Already handling a disconnection (prevent re-entrancy)
   */
  private async handleDisconnection(): Promise<void> {
    if (this.isDisconnecting) return; // Prevent re-entrancy
    this.isDisconnecting = true;

    console.log('[BLE] Device disconnected');
    this.isStreaming = false;
    this.stopKeepAlive();
    this.writeCharacteristic = null;
    this.notifyCharacteristic = null;
    this.server = null;
    this.packetBuffer = new Uint8Array(0);

    // Don't reconnect if user disconnected intentionally
    if (this.intentionalDisconnect) {
      this.isDisconnecting = false;
      this.callbacks.onConnectionChange('disconnected');
      return;
    }

    // Don't reconnect if device was in MODE_HOME — user needs to start a measurement first
    if (this.deviceMode === 'MODE_HOME') {
      console.log('[BLE] Not reconnecting — device is on home screen. Start a measurement first.');
      this.isDisconnecting = false;
      this.callbacks.onConnectionChange('disconnected');
      return;
    }

    // Auto-reconnect for unexpected disconnections during active measurement
    if (this.reconnectAttempts < MAX_RECONNECT_ATTEMPTS && this.device) {
      this.callbacks.onConnectionChange('reconnecting');
      this.reconnectAttempts++;

      const delay = INITIAL_RECONNECT_DELAY * Math.pow(2, this.reconnectAttempts - 1);
      console.log(`[BLE] Reconnect attempt ${this.reconnectAttempts}/${MAX_RECONNECT_ATTEMPTS} in ${delay}ms`);

      await new Promise(resolve => setTimeout(resolve, delay));

      this.isDisconnecting = false;

      if (this.device && !this.intentionalDisconnect) {
        await this.connect();
      }
    } else {
      this.isDisconnecting = false;
      this.callbacks.onConnectionChange('disconnected');
      if (this.reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) {
        this.callbacks.onError('Device disconnected. Max reconnection attempts reached.');
      }
    }
  }

  /**
   * Disconnect from the device
   */
  disconnect(): void {
    this.intentionalDisconnect = true;
    this.isStreaming = false;
    this.stopKeepAlive();

    if (this.server?.connected) {
      this.server.disconnect();
    }

    this.device = null;
    this.server = null;
    this.writeCharacteristic = null;
    this.notifyCharacteristic = null;
    this.packetBuffer = new Uint8Array(0);
    this.deviceMode = null;

    this.callbacks.onConnectionChange('disconnected');
  }

  /** Connection status */
  get connected(): boolean {
    return this.server?.connected ?? false;
  }

  /** Device name */
  get deviceName(): string | undefined {
    return this.device?.name ?? undefined;
  }
}
