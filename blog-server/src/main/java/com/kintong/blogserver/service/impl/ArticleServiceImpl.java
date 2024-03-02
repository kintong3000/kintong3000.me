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
import org.springframework.stereotype.Service;

/**
 * @Author kintong
 */
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
}
