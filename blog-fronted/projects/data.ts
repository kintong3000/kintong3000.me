import MarkdownIt from 'markdown-it'

const md = new MarkdownIt()

// // @ts-expect-error missing types
// function parseMarkdown(markdownContent) {
//     // 使用 gray-matter 解析 Frontmatter 和正文内容
//     const { data: frontmatter, content } = matter(markdownContent);
//
//     const htmlContent = md.render(content);
//
//
//     return {
//         frontmatter, // 包含了所有 Frontmatter 字段
//         content: htmlContent, // Markdown 转换后的 HTML 内容
//     };
// };

// const demoItems = Array.from(Object.entries(import.meta.glob('./demos/*.md', { eager: true })))
//     .map(([path, module]) => {
//         console.log(module);
//         // const content1 = module;        // 使用自定义的 parseMarkdown 函数或者其他方式来解析 Markdown 文件内容
//         // const { frontmatter, content } = parseMarkdown(content1);
//         //
//         // return {
//         //     url: frontmatter.url,
//         //     img: frontmatter.img,
//         //     text: content,
//         // };
//     });


const demoItems = [
    {
        url:'https://github.com/kintong3000/kintong3000.me',
        img: 'https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/60c7791ffb4e4f66ad791b3ff7a46b20.png~tplv-0es2k971ck-image.png',
        text: '### 一个简单的个人博客\n' +
            '\n' +
            '- 前端博客展示+后台管理系统\n' +
            '\n' +
            '- 博客前端使用nuxt构建，实现ISR（Incremental Static Regeneration）动态更新无需重新部署，且相比CSR(Client-Side Rendering)有良好的SEO,同时减短加载时间，使得用户有更好的体验。相比SSR(Server-Side Rendering),减少了服务器的实时计算需求，帮助降低服务器成本。\n' +
            '\n' +
            '- 文章自动同步于github仓库'
    },
    {
        url:'https://github.com/kintong3000/linux-ultils-shells',
        img: 'https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/iShot_2024-04-08_21.21.26.png',
        text: '### Something useful shells for linux\n' +
            '- oh-my-zsh-config.sh\n\n' +
            '- backup.sh'
    },
]

const renderedItems = demoItems.map(item => ({
    ...item,
    text: md.render(item.text)
}))

export default renderedItems;


