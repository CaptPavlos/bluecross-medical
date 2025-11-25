/** @type {import('tailwindcss').Config} */
export default {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}',
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          // Maritime color palette
          navy: '#0A1628',        // Deep ocean navy
          'navy-light': '#132743', // Lighter navy
          blue: '#1E3A5F',        // Maritime blue
          'blue-light': '#2E5A8B', // Lighter blue
          ocean: '#0077B6',       // Ocean blue (primary accent)
          'ocean-light': '#0096C7', // Bright ocean
          sky: '#48CAE4',         // Light sky/water
          'sky-light': '#90E0EF', // Pale sky
          white: '#CAF0F8',       // Sea foam white
          slate: '#1E293B',
          red: '#DC2626',
          green: '#10B981',
          yellow: '#F59E0B',
          gray: '#64748B',
          // Legacy aliases for compatibility
          teal: '#0077B6',
          'teal-dark': '#005F92',
        },
        surface: {
          primary: '#FFFFFF',
          secondary: '#F0F9FF',   // Very light blue tint
          tertiary: '#E0F2FE',    // Light blue tint
        },
      },
      spacing: {
        'safe-top': 'max(1rem, env(safe-area-inset-top))',
        'safe-bottom': 'max(1rem, env(safe-area-inset-bottom))',
        'safe-left': 'max(1rem, env(safe-area-inset-left))',
        'safe-right': 'max(1rem, env(safe-area-inset-right))',
      },
      fontFamily: {
        sans: [
          'Inter',
          '-apple-system',
          'BlinkMacSystemFont',
          'Segoe UI',
          'Roboto',
          'Oxygen',
          'Ubuntu',
          'Cantarell',
          'sans-serif',
        ],
        mono: ['Monaco', 'Courier New', 'monospace'],
      },
      fontSize: {
        'display': ['32px', { lineHeight: '1.2', fontWeight: '700' }],
        'h1': ['28px', { lineHeight: '1.2', fontWeight: '700' }],
        'h2': ['24px', { lineHeight: '1.3', fontWeight: '600' }],
        'h3': ['20px', { lineHeight: '1.4', fontWeight: '600' }],
        'body-lg': ['16px', { lineHeight: '1.5', fontWeight: '400' }],
        'body': ['14px', { lineHeight: '1.5', fontWeight: '400' }],
        'small': ['12px', { lineHeight: '1.5', fontWeight: '500' }],
      },
      borderRadius: {
        'sm': '6px',
        'md': '8px',
        'lg': '12px',
      },
      boxShadow: {
        'subtle': '0 1px 2px rgba(0, 0, 0, 0.05)',
        'sm': '0 1px 3px rgba(0, 0, 0, 0.08)',
        'md': '0 4px 6px rgba(0, 0, 0, 0.10)',
        'lg': '0 10px 15px rgba(0, 0, 0, 0.15)',
      },
      transitionDuration: {
        'fast': '150ms',
        'normal': '250ms',
        'slow': '350ms',
      },
      animation: {
        'fade-in': 'fadeIn 0.2s ease-out forwards',
        'slide-up': 'slideUp 0.2s ease-out forwards',
        'ping': 'ping 1s cubic-bezier(0, 0, 0.2, 1) infinite',
        'wave': 'wave 8s ease-in-out infinite',
        'wave-slow': 'wave 12s ease-in-out infinite',
        'float': 'float 6s ease-in-out infinite',
        'pulse-line': 'pulseLine 3s ease-in-out infinite',
      },
      keyframes: {
        fadeIn: {
          '0%': { opacity: '0' },
          '100%': { opacity: '1' },
        },
        slideUp: {
          '0%': { transform: 'translateY(20px)', opacity: '0' },
          '100%': { transform: 'translateY(0)', opacity: '1' },
        },
        ping: {
          '75%, 100%': { transform: 'scale(2)', opacity: '0' },
        },
        wave: {
          '0%, 100%': { transform: 'translateX(0) translateY(0)' },
          '25%': { transform: 'translateX(-5%) translateY(2px)' },
          '50%': { transform: 'translateX(0) translateY(0)' },
          '75%': { transform: 'translateX(5%) translateY(-2px)' },
        },
        float: {
          '0%, 100%': { transform: 'translateY(0)' },
          '50%': { transform: 'translateY(-10px)' },
        },
        pulseLine: {
          '0%': { left: '-10%', opacity: '0' },
          '10%': { opacity: '1' },
          '90%': { opacity: '1' },
          '100%': { left: '110%', opacity: '0' },
        },
      },
    },
  },
  plugins: [],
};
