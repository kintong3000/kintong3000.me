// server/api/projects.js
import { promises as fs } from 'fs';
import path from 'path';
import matter from 'gray-matter';
import MarkdownIt from 'markdown-it'


const md = new MarkdownIt();
export default defineEventHandler(async (event) => {
    const directoryPath = path.join(process.cwd(), 'content/projects');

    try {
        // 读取文件夹内容
        const files = await fs.readdir(directoryPath);
        const projects = [];

        for (const file of files) {
            const filePath = path.join(directoryPath, file);
            const fileContent = await fs.readFile(filePath, 'utf-8');
            const { data: frontmatter, content } = matter(fileContent);
            const contentRendered = md.render(content)
            projects.push({ ...frontmatter, contentRendered,urlName: file.replace('.md', '') });
        }

        return { data: { items: projects } };
    } catch (error) {
        return { error: 'Error reading projects' };
    }
});
