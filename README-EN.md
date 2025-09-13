# kintong3000.me Personal Blog

This is a modern, feature-rich personal blog built with Nuxt.js 3.

The page style and architecture are inspired by [antfu.me](https://github.com/antfu/antfu.me).

**Shout out to Anthony Fu.**

## ✨ Features

-   **Static Site Generation (SSG)**: Based on the power of Nuxt 3, all pages are pre-rendered as static HTML at build time, providing extreme loading speed and excellent SEO results.  
-   **Blog System**: Supports rendering from Markdown files.
-   **Built-in API**: Uses the Nuxt 3 server engine to provide endpoints for article and project lists.
-   **Automated Deployment**: Can be deployed for free on platforms like Vercel, allowing automatic updates upon code commits.

## 🛠️ Tech Stack

-   **Framework**: [Nuxt.js 3](https://nuxt.com/) (SSG Mode)
-   **Styling**: [UnoCSS](https://unocss.dev/)

## 🚀 Local Development

Please ensure you have [Node.js](https://nodejs.org/) (version >= 18 recommended) and [pnpm](https://pnpm.io/installation) installed.

**1. Clone the Project**

```bash
git clone <your-repo-url>
cd kintong3000.me
```

**2. Install Dependencies**

```bash
pnpm install
```

**3. Start the Development Server**

This command starts a hot-reloading development server, available by default at `http://localhost:3000`.

```bash
pnpm dev
```

## 📁 Project Structure

```
.
├─── assets/         # Static assets (styles, images, etc.)
├─── components/     # Reusable Vue components
├─── content/        # Markdown content files (blogs, projects)
├─── pages/          # Pages and routing
├─── server/         # Server-side code (API endpoints)
├─── nuxt.config.ts  # Nuxt configuration file
└─── package.json    # Project dependencies and scripts
```

## 🌐 Vercel Automated Deployment Workflow
Once the project is linked to Vercel, every code push triggers an automated deployment:

1.  **Local Commit**: Add or modify Markdown files in the `content/blogs` or `content/projects` directory, then use `git push` to send the changes to your GitHub repository.

2.  **Trigger Deployment**: GitHub automatically notifies Vercel of the update via a webhook.

3.  **Cloud Build**: Upon receiving the notification, Vercel pulls the latest code and automatically runs the `pnpm build` command to complete the build process.

4.  **Atomic Deployment**: After a successful build, Vercel deploys the generated `dist/` directory to its global CDN network and instantly points your domain to this latest version. The entire process is smooth and seamless.
