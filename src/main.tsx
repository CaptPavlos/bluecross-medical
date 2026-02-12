/**
 * @fileoverview Application entry point.
 * Renders the React application with StrictMode and Helmet provider for SEO.
 */
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { HelmetProvider } from 'react-helmet-async';
import App from './App';

/** Initialize React root and render application with providers */
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <HelmetProvider>
      <App />
    </HelmetProvider>
  </StrictMode>
);
