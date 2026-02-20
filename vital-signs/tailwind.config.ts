import type { Config } from 'tailwindcss';

const config: Config = {
  content: [
    './app/**/*.{js,ts,jsx,tsx,mdx}',
    './components/**/*.{js,ts,jsx,tsx,mdx}',
    './lib/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      colors: {
        'bg-primary': '#1a1a2e',
        'bg-secondary': '#16213e',
        'bg-card': '#0f3460',
        'accent-green': '#00ff88',
        'accent-red': '#ff6b6b',
        'accent-blue': '#45b7d1',
        'accent-yellow': '#f9ca24',
      },
      animation: {
        'pulse-vital': 'pulse-vital 2s infinite',
        'blink': 'blink 2s infinite',
      },
      keyframes: {
        'pulse-vital': {
          '0%, 100%': { opacity: '1' },
          '50%': { opacity: '0.8' },
        },
        'blink': {
          '0%, 100%': { opacity: '1' },
          '50%': { opacity: '0.5' },
        },
      },
    },
  },
  plugins: [],
};

export default config;
