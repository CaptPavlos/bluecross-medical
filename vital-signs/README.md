# Vital Signs Monitor

Real-time vital signs monitoring web app — ECG, SpO2, Blood Pressure, Temperature.  
Connects to Viatom Checkme Pro and compatible devices via **Web Bluetooth**.

## Features

- **Live ECG Waveform** — Canvas-based 500Hz display with standard grid (25mm/s, 10mm/mV)
- **Vital Signs Dashboard** — Heart Rate, SpO2, Blood Pressure, Temperature with normal range indicators
- **Web Bluetooth** — Scan, pair, and stream data from Viatom BLE devices
- **Demo Mode** — Simulated data for testing without a physical device
- **ECG Analysis** — Pan-Tompkins R-peak detection, heart rate, rhythm analysis
- **Recording** — Record ECG sessions with full playback
- **History** — Browse and review past recordings stored in IndexedDB
- **Export** — CSV and JSON export of vital records
- **Dark Medical Theme** — Professional medical UI with dark background

## Requirements

- **Browser:** Google Chrome or Microsoft Edge (Web Bluetooth required)
- **Protocol:** HTTPS (Web Bluetooth requirement — works on localhost for dev)
- **Device (optional):** Viatom Checkme Pro, AirBP, or compatible BLE device

## Getting Started

```bash
# Install dependencies
npm install

# Development server
npm run dev

# Build for production
npm run build

# Start production server
npm start
```

Open [http://localhost:3000](http://localhost:3000) in Chrome or Edge.

## Deploy to Vercel

This app is designed for independent Vercel deployment:

```bash
vercel deploy
```

Or connect the repo to Vercel for automatic deployments.

## Architecture

```
vital-signs/
├── app/             # Next.js 14 App Router pages
├── components/      # React components (ECG, VitalCard, etc.)
├── lib/
│   ├── bluetooth/   # Web Bluetooth API manager
│   ├── processors/  # ECG signal processing (Pan-Tompkins)
│   ├── stores/      # Zustand state management
│   ├── storage/     # IndexedDB local storage
│   └── types.ts     # Shared TypeScript interfaces
```

## BLE Service UUIDs

| Service      | UUID                                   |
|-------------|----------------------------------------|
| Viatom Main | `14839ac4-7d7e-415c-9a42-167340cf2339` |
| ECG         | `8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3` |
| SpO2        | `0734594A-A8E7-4B1A-A6B1-CD5243059A57` |
| Blood Pressure | `00001810-0000-1000-8000-00805F9B34FB` |
| Temperature | `00001809-0000-1000-8000-00805F9B34FB` |

## Tech Stack

- **Next.js 14** (App Router, standalone output)
- **React 18** with TypeScript
- **Tailwind CSS** (dark medical theme)
- **Zustand** (state management)
- **idb** (IndexedDB wrapper)
- **Lucide React** (icons)
- **Recharts** (history charts)

## License

Private — BlueCross Medical
