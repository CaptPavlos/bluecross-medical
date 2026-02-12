# Blue Cross Medical 🏥

**Emergency medicine database for yacht crew**

## Problem

Yacht crew handle medical emergencies far from hospitals:
- Need quick access to treatment protocols
- Drug dosages, contraindications, procedures
- No reliable offline-capable medical reference
- Generic apps don't cover maritime-specific scenarios

## Solution

A searchable medical database tailored for:
- Remote/maritime emergency medicine
- Quick drug lookup with dosages
- Step-by-step emergency procedures
- Works offline (PWA)

## Architecture

```
┌─────────────────┐     ┌──────────────┐
│   Next.js 14    │────▶│   Supabase   │
│   PWA-enabled   │     │   Postgres   │
└─────────────────┘     └──────────────┘
```

**Stack:**
- **Frontend:** Next.js 14, TypeScript, Tailwind
- **Database:** Supabase (Postgres)
- **Offline:** Service Worker (PWA)
- **Deployment:** Vercel

## Key Features

- 💊 Drug database with dosages
- 🚨 Emergency protocols
- 🔍 Fast search
- 📱 Mobile-first, offline-capable
- 🏥 Maritime medicine focus

## Getting Started

```bash
pnpm install
cp .env.example .env.local
pnpm dev
```

## License

Private - MarSoft AI
