import { promises as fs } from 'fs';
import path from 'path';
import matter from 'gray-matter';

export default defineEventHandler(async (event) => {
    const directoryPath = path.join(process.cwd(), 'content/blogs');

    try {
        // 读取文件夹内容
        const files = (await fs.readdir(directoryPath)).filter(file => file !== 'introduction.md');
        const articles = [];

        for (const file of files) {
            const filePath = path.join(directoryPath, file);
            const fileContent = await fs.readFile(filePath, 'utf-8');
            const { data: frontmatter } = matter(fileContent);
            articles.push({ ...frontmatter, urlName: file.replace('.md', '') });
        }
        // 根据日期进行排序
        articles.sort((a, b) => new Date(a.date).getTime() - new Date(b.date).getTime());

        return { data: { items: articles } };
    } catch (error) {
        return { error: 'Error reading articles' };
    }
});
