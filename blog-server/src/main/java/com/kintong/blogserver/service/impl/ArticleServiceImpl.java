package com.kintong.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.mapper.ArticleMapper;
import com.kintong.blogserver.service.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * @Author kintong
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public PageVo<Article> getArticlesList(Integer current, Integer limit) {
        Page<Article> page = new Page<>(current, limit);
        LambdaQueryWrapper<Article> wrapper = new QueryWrapper<Article>().lambda()
                .select(Article.class, info -> !"content".equals(info.getColumn()));
        IPage<Article> iPage = articleMapper.selectPage(page,wrapper);
        return new PageVo<>(iPage);
    }

    @Override
    public Article getArticle(String urlName) {
        return this.query().eq("url_name",urlName).one();
    }

    @Override
    public Article getArticle(Integer id) {
        return this.query().eq("id",id).one();
    }

    @Override
    public boolean saveArticle(Article article) {
//        return this.saveOrUpdate(article);
        try {
            this.saveOrUpdate(article);
            return true; // 如果没有异常发生，表示保存成功
        } catch (DataIntegrityViolationException e) {
            // 在这里处理违反数据完整性的异常，例如重复的键
            return false; // 返回false，表示保存失败
        }

    }

    @Override
    public boolean deleateArticle(Integer id) {
        return this.removeById(id);
    }
}
