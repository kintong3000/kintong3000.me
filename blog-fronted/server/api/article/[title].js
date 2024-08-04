import { promises as fs } from 'fs';
import path from 'path';
import matter from 'gray-matter';
export default defineEventHandler(async (event) => {
    const { title } = event.context.params;

    try {
        // 构建文件路径
        const filePath = path.join(process.cwd(), 'content/blogs', `${title}.md`);
        // 读取文件内容
        const fileContent = await fs.readFile(filePath, 'utf-8');
        // 解析文件内容和 frontmatter
        const { data: frontmatter, content } = matter(fileContent);
        return { data: { frontmatter, content } };
    } catch (error) {
        return { error: 'File not found' };
    }
});
