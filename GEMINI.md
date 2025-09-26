### Project Overview

This is a personal blog website built with Vue 3 and Vite. It uses a modern, high-performance stack to deliver a fast, statically generated site. The content is driven by Markdown files, making it easy to create and manage blog posts.

**Key Technologies:**

*   **Framework:** Vue 3
*   **Build Tool:** Vite
*   **CSS Framework:** UnoCSS
*   **Routing:** `unplugin-vue-router` (file-based routing)
*   **Static Site Generation (SSG):** `vite-ssg`
*   **Markdown Processing:** `unplugin-vue-markdown` with Shiki for syntax highlighting.

**Architecture:**

The project follows a Static Site Generation (SSG) architecture. The `vite-ssg` plugin pre-renders the entire site into static HTML files during the build process. This results in excellent performance and SEO. The routing is handled by `unplugin-vue-router`, which automatically generates routes based on the file structure in the `pages` directory.

### Building and Running

**Prerequisites:**

*   Node.js >= 18
*   pnpm

**Development:**

To run the development server with hot-reloading:

```bash
pnpm dev
```

**Build:**

To build the static site for production:

```bash
pnpm build
```

The output will be in the `dist/` directory.

**Preview:**

To preview the production build locally:

```bash
pnpm preview
```

### Development Conventions

*   **Content:** All blog posts and pages are created as Markdown files in the `pages` directory.
*   **Routing:** The routing is file-based. For example, a file at `pages/blogs/my-first-post.md` will be available at the `/blogs/my-first-post` route.
*   **Styling:** The project uses UnoCSS for styling. Utility classes are the primary way to style components.
*   **Components:** Reusable Vue components are located in the `src/components` directory.
*   **Auto-imports:** The project uses `unplugin-auto-import` and `unplugin-vue-components` to automatically import components and APIs, reducing the need for manual import statements.
