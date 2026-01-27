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
const RT_DATA_COMMAND = 0x00;  // Command to start real-time data

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
   * 3. Send RT data command FIRST (device may disconnect if idle too long)
   * 4. Subscribe to notifications
   * 5. Device starts streaming data
   */
  private async connect(): Promise<boolean> {
    if (!this.device?.gatt) return false;

    try {
      this.callbacks.onConnectionChange('connecting');
      this.reconnectAttempts = 0;

      // Step 1: Connect to GATT server
      this.server = await this.device.gatt.connect();
      console.log('[BLE] GATT server connected');

      // Small delay to let the connection stabilize
      await this.delay(500);

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

      // Step 4: Send RT command IMMEDIATELY to keep device from disconnecting.
      // The Checkme Pro may drop the connection if it doesn't receive a command quickly.
      await this.startRealTimeData();

      // Step 5: NOW subscribe to notifications (after command is sent)
      if (this.notifyCharacteristic) {
        try {
          await this.notifyCharacteristic.startNotifications();
          this.notifyCharacteristic.addEventListener('characteristicvaluechanged', (event) => {
            this.handleNotification(event);
          });
          console.log('[BLE] Notify subscribed — waiting for data...');
        } catch (e) {
          console.warn('[BLE] Failed to subscribe to notifications:', e);
          this.callbacks.onError('Could not subscribe to device notifications');
        }
      }

      // Step 6: Send RT command again after notifications are set up
      // (in case the device needs it after notification subscription)
      await this.delay(200);
      await this.startRealTimeData();

      this.callbacks.onConnectionChange('connected', this.device.name || 'Checkme Pro');
      this.isStreaming = true;

      // Keep sending RT command periodically to prevent idle disconnect
      this.startKeepAlive();

      return true;
    } catch (error) {
      const err = error as Error;
      console.error('[BLE] Connection error:', err);
      this.callbacks.onError(`Connection failed: ${err.message}`);
      this.callbacks.onConnectionChange('error');
      return false;
    }
  }

  /**
   * Send command to start real-time data streaming.
   * From official SDK: sends 0x00 to trigger getRtData().
   */
  private async startRealTimeData(): Promise<void> {
    if (!this.writeCharacteristic) {
      console.warn('[BLE] Cannot send RT command — write characteristic not available');
      return;
    }

    try {
      const cmd = new Uint8Array([RT_DATA_COMMAND]);
      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      await this.writeCharacteristic.writeValueWithoutResponse(cmd as any);
      console.log('[BLE] RT data command sent');
    } catch (e) {
      console.warn('[BLE] Failed to send RT command:', e);
    }
  }

  /**
   * Keep-alive: periodically send RT command to prevent idle disconnect.
   * Some Viatom devices drop the connection after a few seconds without commands.
   */
  private keepAliveTimer: ReturnType<typeof setInterval> | null = null;

  private startKeepAlive(): void {
    this.stopKeepAlive();
    this.keepAliveTimer = setInterval(async () => {
      if (this.server?.connected && this.writeCharacteristic) {
        try {
          const cmd = new Uint8Array([RT_DATA_COMMAND]);
          // eslint-disable-next-line @typescript-eslint/no-explicit-any
          await this.writeCharacteristic.writeValueWithoutResponse(cmd as any);
        } catch {
          // Ignore — disconnect handler will take care of it
        }
      }
    }, 3000); // Every 3 seconds
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
   * The Checkme Pro sends combined packets containing ECG + SpO2 + vitals data.
   * Packets may be split across multiple BLE notifications due to MTU limits.
   */
  private handleNotification(event: Event): void {
    const characteristic = event.target as BluetoothRemoteGATTCharacteristic;
    const dataView = characteristic.value;
    if (!dataView) return;

    // Append incoming data to buffer
    const incoming = new Uint8Array(dataView.buffer);
    const combined = new Uint8Array(this.packetBuffer.length + incoming.length);
    combined.set(this.packetBuffer);
    combined.set(incoming, this.packetBuffer.length);
    this.packetBuffer = combined;

    // Process complete packets from buffer
    this.processBuffer();
  }

  /**
   * Process buffered data, extracting complete Checkme packets.
   * Packet format starts with [0xA5, 0x5A] header.
   */
  private processBuffer(): void {
    while (this.packetBuffer.length >= 4) {
      // Find packet header
      const headerIndex = this.findHeader(this.packetBuffer);
      if (headerIndex === -1) {
        // No header found, discard buffer
        this.packetBuffer = new Uint8Array(0);
        return;
      }

      // Skip any garbage before header
      if (headerIndex > 0) {
        this.packetBuffer = this.packetBuffer.slice(headerIndex);
      }

      // Check if we have enough data for the size byte
      if (this.packetBuffer.length < 3) return;

      const packetSize = this.packetBuffer[2]; // pkg_size field
      const totalSize = packetSize + 3; // header (2) + size byte (1) + data (packetSize)

      // Wait for full packet
      if (this.packetBuffer.length < totalSize) return;

      // Extract and parse the packet
      const packet = this.packetBuffer.slice(0, totalSize);
      this.packetBuffer = this.packetBuffer.slice(totalSize);

      try {
        const parsed = this.parsePacket(packet);
        if (parsed) {
          this.dispatchParsedData(parsed);
        }
      } catch (e) {
        console.warn('[BLE] Packet parse error:', e);
      }
    }
  }

  /**
   * Find [0xA5, 0x5A] header in buffer
   */
  private findHeader(buf: Uint8Array): number {
    for (let i = 0; i < buf.length - 1; i++) {
      if (buf[i] === HEADER_BYTE_1 && buf[i + 1] === HEADER_BYTE_2) {
        return i;
      }
    }
    return -1;
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
   * Handle device disconnection — attempt auto-reconnect
   */
  private async handleDisconnection(): Promise<void> {
    console.log('[BLE] Device disconnected');
    this.isStreaming = false;
    this.writeCharacteristic = null;
    this.notifyCharacteristic = null;
    this.packetBuffer = new Uint8Array(0);
    this.stopKeepAlive();

    if (this.reconnectAttempts < MAX_RECONNECT_ATTEMPTS) {
      this.callbacks.onConnectionChange('reconnecting');
      this.reconnectAttempts++;

      const delay = INITIAL_RECONNECT_DELAY * Math.pow(2, this.reconnectAttempts - 1);
      console.log(`[BLE] Reconnect attempt ${this.reconnectAttempts}/${MAX_RECONNECT_ATTEMPTS} in ${delay}ms`);

      await new Promise(resolve => setTimeout(resolve, delay));

      if (this.device) {
        await this.connect();
      }
    } else {
      this.callbacks.onConnectionChange('disconnected');
      this.callbacks.onError('Device disconnected. Max reconnection attempts reached.');
    }
  }

  /**
   * Disconnect from the device
   */
  disconnect(): void {
    this.reconnectAttempts = MAX_RECONNECT_ATTEMPTS; // Prevent auto-reconnect
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

    this.callbacks.onConnectionChange('disconnected');
  }

  /**
   * Send a raw command to the device
   */
  async sendCommand(cmd: Uint8Array): Promise<void> {
    if (!this.writeCharacteristic) {
      console.warn('[BLE] Cannot send command — not connected');
      return;
    }
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    await this.writeCharacteristic.writeValueWithoutResponse(cmd as any);
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
