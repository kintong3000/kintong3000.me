package com.kintong.blogserver.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author kintong
 */
@Data
public class AuthorizeVO {
    String username;
    String role;
    String token;
    Date expire;
}
