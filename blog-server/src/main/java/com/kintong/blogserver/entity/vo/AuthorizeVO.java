package com.kintong.blogserver.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author kintong
 */
@Data
public class AuthorizeVO {
    private String username;
    private String role;
    private String token;
    private Date expire;
}
