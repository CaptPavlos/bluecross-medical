/**
 * Web Bluetooth API Manager for Viatom Checkme Suit
 * 
 * Converted from Electron BluetoothManager.ts to use the Web Bluetooth API.
 * 
 * Handles:
 * - Device discovery via navigator.bluetooth.requestDevice()
 * - GATT service connections
 * - Real-time data streaming
 * - Automatic reconnection with exponential backoff
 * - BLE MTU handling (≤20 bytes per notification)
 */

import { ECGSample, SpO2Reading, BloodPressure, TemperatureReading, BLECallbacks, ConnectionStatus } from '@/lib/types';

// Viatom GATT Service UUIDs
const VIATOM_SERVICE_UUID = '14839ac4-7d7e-415c-9a42-167340cf2339';
const ECG_CHARACTERISTIC_UUID = '8b00ace7-eb0b-49b0-bbe9-9aee0a26e1a3';
const SPO2_CHARACTERISTIC_UUID = '0734594a-a8e7-4b1a-a6b1-cd5243059a57';
const BP_SERVICE_UUID = '00001810-0000-1000-8000-00805f9b34fb';
const TEMP_SERVICE_UUID = '00001809-0000-1000-8000-00805f9b34fb';

// Constants
const ECG_SAMPLE_RATE = 500; // Hz
const MAX_RECONNECT_ATTEMPTS = 5;
const INITIAL_RECONNECT_DELAY = 1000; // ms

/**
 * Check if Web Bluetooth is supported in the current browser
 */
export function isWebBluetoothSupported(): boolean {
  return typeof navigator !== 'undefined' && 'bluetooth' in navigator;
}

export class WebBluetoothManager {
  private device: BluetoothDevice | null = null;
  private server: BluetoothRemoteGATTServer | null = null;
  private ecgCharacteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private spo2Characteristic: BluetoothRemoteGATTCharacteristic | null = null;
  private reconnectAttempts = 0;
  private callbacks: BLECallbacks;
  private isStreaming = false;

  constructor(callbacks: BLECallbacks) {
    this.callbacks = callbacks;
  }

  /**
   * Request and connect to a Viatom device
   * Must be called from a user gesture (click/tap)
   */
  async requestDevice(): Promise<boolean> {
    if (!isWebBluetoothSupported()) {
      this.callbacks.onError('Web Bluetooth is not supported in this browser. Please use Chrome or Edge.');
      return false;
    }

    try {
      this.callbacks.onConnectionChange('scanning');

      // Request device with Viatom service filter
      this.device = await navigator.bluetooth.requestDevice({
        filters: [
          { services: [VIATOM_SERVICE_UUID] },
          { namePrefix: 'Checkme' },
          { namePrefix: 'AirBP' },
          { namePrefix: 'Viatom' },
        ],
        optionalServices: [VIATOM_SERVICE_UUID, BP_SERVICE_UUID, TEMP_SERVICE_UUID],
      });

      // Listen for disconnection
      this.device.addEventListener('gattserverdisconnected', () => {
        this.handleDisconnection();
      });

      // Connect to GATT server
      return await this.connect();
    } catch (error) {
      if ((error as Error).name === 'NotFoundError') {
        // User cancelled the device picker
        this.callbacks.onConnectionChange('disconnected');
      } else {
        this.callbacks.onError(`Scan failed: ${(error as Error).message}`);
        this.callbacks.onConnectionChange('error');
      }
      return false;
    }
  }

  /**
   * Connect to the selected device's GATT server
   */
  private async connect(): Promise<boolean> {
    if (!this.device) return false;

    try {
      this.callbacks.onConnectionChange('connecting');
      this.reconnectAttempts = 0;

      this.server = await this.device.gatt!.connect();

      // Discover primary service
      try {
        const service = await this.server.getPrimaryService(VIATOM_SERVICE_UUID);

        // Subscribe to ECG characteristic
        try {
          this.ecgCharacteristic = await service.getCharacteristic(ECG_CHARACTERISTIC_UUID);
          await this.ecgCharacteristic.startNotifications();
          this.ecgCharacteristic.addEventListener('characteristicvaluechanged', (event) => {
            this.handleECGNotification(event);
          });
        } catch {
          console.warn('[BLE] ECG characteristic not available');
        }

        // Subscribe to SpO2 characteristic
        try {
          this.spo2Characteristic = await service.getCharacteristic(SPO2_CHARACTERISTIC_UUID);
          await this.spo2Characteristic.startNotifications();
          this.spo2Characteristic.addEventListener('characteristicvaluechanged', (event) => {
            this.handleSpO2Notification(event);
          });
        } catch {
          console.warn('[BLE] SpO2 characteristic not available');
        }
      } catch {
        console.warn('[BLE] Primary Viatom service not available, device may support limited features');
      }

      this.callbacks.onConnectionChange('connected', this.device.name || 'Viatom Device');
      return true;
    } catch (error) {
      this.callbacks.onError(`Connection failed: ${(error as Error).message}`);
      this.callbacks.onConnectionChange('error');
      return false;
    }
  }

  /**
   * Handle ECG BLE notifications
   * BLE MTU ≤20 bytes, ECG samples are 16-bit signed = 2 bytes each
   * So up to 10 samples per notification
   */
  private handleECGNotification(event: Event): void {
    const characteristic = (event.target as BluetoothRemoteGATTCharacteristic);
    const dataView = characteristic.value;
    if (!dataView) return;

    const samples: ECGSample[] = [];
    const now = Date.now();

    // Parse 16-bit signed ECG samples
    for (let i = 0; i < dataView.byteLength; i += 2) {
      if (i + 1 < dataView.byteLength) {
        const value = dataView.getInt16(i, true); // little-endian
        const leadOff = (value & 0x8000) !== 0; // MSB indicates lead-off

        samples.push({
          timestamp: now + (i / 2) * (1000 / ECG_SAMPLE_RATE),
          value: leadOff ? 0 : value,
          leadOff,
        });
      }
    }

    if (samples.length > 0) {
      this.callbacks.onECGData(samples);
    }
  }

  /**
   * Handle SpO2 BLE notifications
   */
  private handleSpO2Notification(event: Event): void {
    const characteristic = (event.target as BluetoothRemoteGATTCharacteristic);
    const dataView = characteristic.value;
    if (!dataView || dataView.byteLength < 4) return;

    const spo2 = dataView.getUint8(0);
    const heartRate = dataView.getUint8(1);
    const pi = dataView.getUint8(2) / 10; // Perfusion index * 10

    if (spo2 > 0 && spo2 <= 100 && heartRate > 0 && heartRate <= 250) {
      this.callbacks.onSpO2Data({
        timestamp: Date.now(),
        spo2,
        heartRate,
        perfusionIndex: pi.toFixed(1),
      });
    }
  }

  /**
   * Handle disconnection - attempt reconnect
   */
  private async handleDisconnection(): Promise<void> {
    this.isStreaming = false;
    this.ecgCharacteristic = null;
    this.spo2Characteristic = null;

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

    if (this.server?.connected) {
      this.server.disconnect();
    }

    this.device = null;
    this.server = null;
    this.ecgCharacteristic = null;
    this.spo2Characteristic = null;

    this.callbacks.onConnectionChange('disconnected');
  }

  /**
   * Get connection status
   */
  get connected(): boolean {
    return this.server?.connected ?? false;
  }

  /**
   * Get device name
   */
  get name(): string | undefined {
    return this.device?.name ?? undefined;
  }
}
