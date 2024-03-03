package com.kintong.blogserver.controller;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author kintong
 */
@RestController
@RequestMapping("/cms/blog")
public class ArticleManageController {
    @Autowired
    ArticleService articleService;

    @GetMapping("article")
    public ApiResult<PageVo<Article>> queryArticleListInCMS(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam (required = false,defaultValue = "10") Integer limit){
        PageVo<Article> pageVo= articleService.getArticlesList(page,limit);
        return ApiResult.success(pageVo);
    }

    @GetMapping("article/{id}")
    public ApiResult<Article> queryArticleInCMS(@PathVariable Integer id){
        Article article = articleService.getArticle(id);
        if(article==null){
            return ApiResult.failure(ApiCode.NOT_FOUND);
        }
        return ApiResult.success(article);
    }

    @PostMapping("/article/save")
    public ApiResult saveArticle(@RequestBody Article article){
        boolean success = articleService.saveArticle(article);
        if (success){
            return ApiResult.success();
        }
        return ApiResult.failure(ApiCode.FAIL);
    }

}
