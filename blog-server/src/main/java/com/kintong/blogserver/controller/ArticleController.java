package com.kintong.blogserver.controller;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ApiResult queryArticleList(@RequestParam (required = false,defaultValue = "1") Integer page,
                                      @RequestParam (required = false,defaultValue = "10") Integer limit){

        PageVo<Article> pageVo= articleService.getArticlesList(page,limit);
        return ApiResult.success(pageVo);
    }

    @GetMapping("article/{urlName}")
    public ApiResult queryArticle(@PathVariable String urlName){
        Article article = articleService.getArticle(urlName);
        if(article==null){
            return ApiResult.failure(ApiCode.NOT_FOUND);
        }
        return ApiResult.success(article);
    }
}
