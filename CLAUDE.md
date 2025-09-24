# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Development Commands

- `pnpm dev` - Start development server with hot reload
- `pnpm build` - Build static site for production
- `pnpm preview` - Preview built site locally

## Architecture Overview

This is a Vue 3 static blog site using Vite SSG (Static Site Generation). Key architectural features:

### File-Based Routing
- Pages are automatically generated from `.vue` and `.md` files in the `pages/` directory
- `unplugin-vue-router` scans the `pages/` folder and generates routes
- Markdown files are processed as Vue components via `unplugin-vue-markdown`

### Markdown Processing
- Markdown files support frontmatter for metadata
- Syntax highlighting via Shiki with light/dark themes
- Table of contents generation with custom styling
- GitHub-style alerts support
- Custom wrapper components for different content types

### Styling System
- UnoCSS with Wind4 preset for utility-first CSS
- Shadcn UI components with custom preset
- Icon system using Material Symbols via UnoCSS preset
- Dark mode support via VueUse

### Component Architecture
- UI components in `src/components/ui/` follow Radix Vue patterns
- Layout components in `src/components/` (AppHeader, AppFooter, etc.)
- Markdown wrapper components (WrapperIntroduction, WrapperPost)
- Auto-import of Vue, Vue Router, and VueUse APIs

### Static Generation
- `vite-ssg` pre-renders all pages to static HTML
- Routes are scanned and generated at build time
- Frontmatter from Markdown files is exposed to route meta

## Important Configuration Files

- `vite.config.js` - Vite configuration with plugins for routing, markdown, and auto-imports
- `uno.config.ts` - UnoCSS configuration with presets for styling and icons
- `package.json` - Project dependencies and scripts

## Content Structure

- `pages/` - Main content (homepage, blog posts)
- `src/components/` - Vue components
- `src/styles/` - Global styles and markdown prose styling
- Blog posts are stored in `pages/blogs/` as Markdown files with frontmatter