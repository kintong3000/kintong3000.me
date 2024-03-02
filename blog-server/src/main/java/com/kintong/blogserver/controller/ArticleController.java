package com.kintong.blogserver.controller;

import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客前台 Controller
 * @Author kintong
 */

@RestController
@RequestMapping("/cms/blog")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @GetMapping("article")
    public ApiResult queryArticleList(@RequestParam (required = false,defaultValue = "1") int page,
                                      @RequestParam (required = false,defaultValue = "10") int limit){

        PageVo<Article> pageVo= articleService.getArticlesList(page,limit);
        return ApiResult.success(pageVo);
    }
}
