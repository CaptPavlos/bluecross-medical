import type { Metadata } from 'next';
import './globals.css';

export const metadata: Metadata = {
  title: 'Vital Signs Monitor',
  description: 'Real-time vital signs monitoring — ECG, SpO2, Blood Pressure, Temperature. Powered by Web Bluetooth.',
  icons: {
    icon: '/favicon.ico',
  },
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className="min-h-screen bg-bg-primary text-white">
        <div className="flex flex-col min-h-screen">
          {/* Header */}
          <header className="flex items-center justify-between px-6 py-4 bg-bg-secondary border-b border-white/10">
            <div className="flex items-center gap-3">
              <span className="text-2xl">💓</span>
              <h1 className="text-xl font-semibold tracking-tight">
                Vital Signs Monitor
              </h1>
            </div>
            <div className="text-xs text-gray-500">
              BlueCross Medical
            </div>
          </header>

          {/* Main content */}
          <main className="flex-1 px-4 md:px-8 py-6">
            {children}
          </main>

          {/* Footer */}
          <footer className="flex items-center justify-between px-6 py-3 bg-bg-secondary border-t border-white/10 text-xs text-gray-500">
            <span>© {new Date().getFullYear()} BlueCross Medical</span>
            <span>Web Bluetooth • Chrome/Edge Required • HTTPS</span>
          </footer>
        </div>
      </body>
    </html>
  );
}
