# kintong3000.me 个人博客

这是一个基于 Nuxt.js 3 构建的现代化、功能丰富的个人博客。

页面样式,架构参考自[antfu.me](https://github.com/antfu/antfu.me)

**Shout out to Anthony Fu.**

## ✨ 功能特性

-   **静态站点生成 (SSG)**: 基于 Nuxt 3 的强大功能，所有页面在构建时预先渲染成静态 HTML，提供了极致的加载速度和优秀的 SEO 效果。
-   **博客系统**: 支持 Markdown 文件渲染。
-   **内置 API**: 使用 Nuxt 3 服务端引擎提供文章和项目列表接口。
-   **支持自动化部署**:可免费部署在 Vercel 等平台，提交代码即可自动更新线上页面。

## 🛠️ 技术栈

-   **框架**: [Nuxt.js 3](https://nuxt.com/) (SSG 模式)
-   **样式**: [UnoCSS](https://unocss.dev/)

## 🚀 本地开发

请确保你已经安装了 [Node.js](https://nodejs.org/) (建议版本 >= 18) 和 [pnpm](https://pnpm.io/installation)。

**1. 克隆项目**

```bash
git clone <your-repo-url>
cd kintong3000.me
```

**2. 安装依赖**

```bash
pnpm install
```

**3. 启动开发服务器**

该命令会启动一个热重载的开发服务器，默认地址为 `http://localhost:3000`。

```bash
pnpm dev
```

## 📁 项目结构

```
.
├─── assets/         # 静态资源 (样式, 图片等)
├─── components/     # 可复用的 Vue 组件
├─── content/        # Markdown 内容文件 (博客, 项目)
├─── pages/          # 页面与路由
├─── server/         # 服务端代码 (API 接口)
├─── nuxt.config.ts  # Nuxt 配置文件
└─── package.json    # 项目依赖与脚本
```

## 🌐 Vercel 自动化部署流程
当项目与 Vercel 关联后，每一次代码提交都会触发一次自动化的部署：

1.本地提交：在 `content/blogs` 或 `content/projects` 目录下添加或修改 Markdown 文件，然后使用 git push 将变更推送到 GitHub 仓库。

2.触发部署：GitHub 通过 Webhook 自动通知 Vercel 代码有更新。

3.云端构建：Vercel 收到通知后，会拉取最新的代码，并自动执行 pnpm build 命令，完成构建流程。

4.原子化部署：构建成功后，Vercel 会将生成的 dist/ 目录部署到其全球 CDN 网络，并瞬间将您的域名指向这个最新版本，整个过程平滑且无中断。


