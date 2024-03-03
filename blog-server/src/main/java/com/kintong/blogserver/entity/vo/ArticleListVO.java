package com.kintong.blogserver.entity.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author kintong
 */
@Data
public class ArticleListVO {
    private Integer id;
    private String title;
    private LocalDateTime createTime;
    private String urlName;
}
