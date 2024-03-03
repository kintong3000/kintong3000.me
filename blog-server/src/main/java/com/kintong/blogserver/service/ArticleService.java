package com.kintong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;

/**
 * @Author kintong
 */
public interface ArticleService extends IService<Article> {
    PageVo<Article> getArticlesList(Integer current, Integer limit);

    Article getArticle(String urlName);
    Article getArticle(Integer id);

    boolean saveArticle(Article article);

}
