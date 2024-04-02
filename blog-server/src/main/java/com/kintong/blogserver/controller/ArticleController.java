package com.kintong.blogserver.controller;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.core.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.dto.Introduction;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.service.ArticleService;
import com.kintong.blogserver.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客前台 Controller
 * @Author kintong
 */

@RestController
@RequestMapping("/api/blog")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @Autowired
    IntroductionService introductionService;


    @GetMapping("article")
    public ApiResult<PageVo<Article>> queryArticleList(@RequestParam (required = false,defaultValue = "1") Integer page,
                                      @RequestParam (required = false,defaultValue = "10") Integer limit){

        PageVo<Article> pageVo= articleService.getArticlesList(page,limit);
        return ApiResult.success(pageVo);
    }

    @GetMapping("article/{urlName}")
    public ApiResult<Article> queryArticle(@PathVariable String urlName){
        Article article = articleService.getArticle(urlName);
        if(article==null){
            return ApiResult.failure(ApiCode.NOT_FOUND);
        }
        return ApiResult.success(article);
    }


    @GetMapping("article/id/{id}")
    public ApiResult<Article> queryArticleById(@PathVariable Integer id){
        Article article = articleService.getArticle(id);
        if(article==null){
            return ApiResult.failure(ApiCode.NOT_FOUND);
        }
        return ApiResult.success(article);
    }

    @GetMapping("introduction")
    public ApiResult<Introduction> Index(){
        Introduction introduction = introductionService.getIndex();
        if(introduction ==null){
            return ApiResult.failure(ApiCode.NOT_FOUND);
        }
        return ApiResult.success(introduction);  }


}
