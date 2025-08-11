import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

import federation from "@originjs/vite-plugin-federation"

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react(),
    federation({
      name: 'user-management',
      filename: 'remoteEntry.js',
      exposes: {
        './App': './src/App.tsx'
      },
      shared: ['react']
    })
  ],
  server: {
    port: 3001
  },
  preview: {
    port: 3001
  },
  build: {
    target: 'esnext'
  }
})
