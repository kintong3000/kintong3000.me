package com.kintong.blogserver.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @Author kintong
 */
@Data
@TableName("introduction")
public class Introduction {
    private Integer id ;
    private String title;
    private String content;
}
