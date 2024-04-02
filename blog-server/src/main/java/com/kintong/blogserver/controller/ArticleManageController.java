package com.kintong.blogserver.controller;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.core.ultils.ApiResult;
import com.kintong.blogserver.core.ultils.GitHubUltils;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.dto.Introduction;
import com.kintong.blogserver.service.ArticleService;
import com.kintong.blogserver.service.IntroductionService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

/**
 * @Author kintong
 */
@RestController
@RequestMapping("/cms/blog")
public class ArticleManageController {
    @Autowired
    ArticleService articleService;

    @Autowired
    IntroductionService introductionService;

    @Autowired
    GitHubUltils gitHubUltils;

//    @GetMapping("article")
//    public ApiResult<PageVo<Article>> queryArticleListInCMS(@RequestParam(required = false,defaultValue = "1") Integer page,
//                                      @RequestParam (required = false,defaultValue = "10") Integer limit){
//        PageVo<Article> pageVo= articleService.getArticlesList(page,limit);
//        return ApiResult.success(pageVo);
//    }

//    @GetMapping("article/{id}")
//    public ApiResult<Article> queryArticleInCMS(@PathVariable Integer id){
//        Article article = articleService.getArticle(id);
//        if(article==null){
//            return ApiResult.failure(ApiCode.NOT_FOUND);
//        }
//        return ApiResult.success(article);
//    }

    @PostMapping("article/save")
    public ApiResult<Null> saveArticle(@RequestBody Article article){
        boolean saveSuccess = articleService.saveArticle(article);
        if (saveSuccess){
            String mdName = article.getTitle()+".md";
            String contentBase64 = Base64.getEncoder().encodeToString(article.getContent().getBytes());
            gitHubUltils.updateRepositoryContent(mdName,contentBase64);
            return ApiResult.success();
        }
        return ApiResult.failure(ApiCode.FAIL);
    }

    @DeleteMapping("article/{id}")
    public ApiResult<Null> deleateArticle(@PathVariable Integer id){
        boolean deleateSuccess = articleService.deleateArticle(id);
        if (deleateSuccess){
            return ApiResult.success();
        }
        return ApiResult.failure(ApiCode.FAIL);
    }

    @PostMapping("introduction/update")
    public ApiResult<Null> updateIntroduction(@RequestBody Introduction introduction){
        boolean saveSuccess = introductionService.updateIntroduction(introduction);
        if (saveSuccess){
            return ApiResult.success();
        }
        return ApiResult.failure(ApiCode.FAIL);
    }
}
