package com.kintong.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kintong.blogserver.entity.dto.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kintong
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
