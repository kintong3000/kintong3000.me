# 个人博客项目

这是一个功能完善的全栈个人博客系统，采用前后端分离的现代架构。项目包含三个核心模块：后端API服务、前端用户界面和后台管理面板。

页面样式,架构参考自[antfu.me](https://github.com/antfu/antfu.me)

**Shout out to Anthony Fu.**

## ✨ 功能特性
- **🚀 极致性能与体验**：采用 Nuxt.js 构建，通过 ISR (增量静态再生) 技术，为用户带来静态站点的秒开速度和动态内容的实时更新。

- **🤖 SEO 友好**：所有页面预渲染为静态 HTML，对搜索引擎天然友好，轻松获得更高排名。

- **✍️ 内容即代码** (Content-as-Code)：文章内容直接与指定的 GitHub 仓库同步，享受 Git 带来的版本控制、协作和备份优势。

- **🔄 自动同步至Github备份**：发布新文章或更新内容自动同步至 GitHub。

- **💰 成本效益**：相比传统的 SSR (服务器端渲染)，ISR 极大降低了服务器的实时计算压力，有效节约了服务器成本。

- **🎨 现代技术栈**：基于 Vue/Nuxt/spring 生态，提供流畅的开发体验和丰富的扩展可能性。

- **🔩 前后端分离**：独立的后台管理系统，让内容管理与前端展示完全解耦，架构清晰，易于维护。

- **📝 Markdown 编辑器**: 后台提供 Markdown 编辑器用于撰写文章。



## 项目架构

本项目由三个独立的子项目组成：

-   **`blog-server`**: 后端服务，基于 Java 和 Spring Boot 构建，提供 RESTful API 接口，负责所有业务逻辑、数据处理和持久化。
-   **`blog-fronted`**: 前端展示系统，基于 Nuxt.js 3 构建，为访问者提供美观、高性能的博客文章阅读体验。
-   **`blog-admin`**: 后台管理系统，基于 Vue.js 3 和 Vite 构建，提供一个内容管理后台，方便博主进行文章发布、用户管理等操作。

它们之间的交互关系如下：
```
(用户) --> blog-fronted (Nuxt.js) --> blog-server (Spring Boot API) --> 数据库
                                          ^
(管理员) --> blog-admin (Vue.js) -----------|
```

---

## 技术栈

### 后端 (`blog-server`)

-   **语言**: Java
-   **框架**: Spring Boot
-   **数据库 ORM**: MyBatis-Plus
-   **安全认证**: Spring Security + JWT (JSON Web Tokens)
-   **构建工具**: Maven
-   **数据库**: MySQL (或其他关系型数据库)

### 前端 (`blog-fronted`)

-   **框架**: Nuxt.js 3
-   **语言**: TypeScript
-   **UI & 样式**: UnoCSS
-   **构建工具**: Vite

### 后台管理 (`blog-admin`)

-   **框架**: Vue.js 3
-   **语言**: JavaScript
-   **构建工具**: Vite
-   **路由**: Vue Router
-   **UI & 样式**: UnoCSS

---
## 部分页面展示

### 部分界面
![CleanShot 2024-03-13 at 14.55.04@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.55.04@2x.png)
![CleanShot 2024-03-13 at 14.56.03@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.56.03@2x.png)
![CleanShot 2024-03-13 at 14.56.47@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.56.47@2x.png)
![CleanShot 2024-03-13 at 14.57.29@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.57.29@2x.png)
![CleanShot 2024-03-13 at 14.58.28@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.58.28@2x.png)

---

## 快速开始

### 环境准备

在开始之前，请确保你的开发环境中安装了以下软件：

-   JDK 17 或更高版本
-   Maven 3.6+
-   Node.js 18+
-   pnpm
-   MySQL 8.0+ (或其他兼容的数据库)

### 数据库设置

1.  创建一个新的数据库 (例如 `my_blog`)。
2.  依次导入项目根目录下的 SQL 文件来创建所需的数据表：
    -   `account.sql`
    -   `article.sql`
    -   `introduction.sql`

### 后端 (`blog-server`)

1.  **进入目录**:
    ```bash
    cd blog-server
    ```
2.  **配置数据库**:
    修改 `src/main/resources/application-dev.yml` 文件，更新 `spring.datasource` 部分的数据库连接信息（URL, username, password）。
3.  **启动服务**:
    ```bash
    mvn spring-boot:run
    ```
    服务默认将在 `http://localhost:8080` 启动。

### 前端 (`blog-fronted`)

1.  **进入目录**:
    ```bash
    cd blog-fronted
    ```
2.  **安装依赖**:
    ```bash
    pnpm install
    ```
3.  **启动开发服务器**:
    ```bash
    pnpm dev
    ```
    前端应用将在 `http://localhost:3000` (或其他可用端口) 启动。

### 后台管理 (`blog-admin`)

1.  **进入目录**:
    ```bash
    cd blog-admin
    ```
2.  **安装依赖**:
    ```bash
    pnpm install
    ```
3.  **启动开发服务器**:
    ```bash
    pnpm dev
    ```
    后台管理面板将在 `http://localhost:5173` (或 Vite 指定的其他端口) 启动。

