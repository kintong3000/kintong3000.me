package com.kintong.blogserver.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author kintong
 */
@Data
public class UserInfoVO {
    private Integer id;
    private String username;
    private String role;
    private String email;
}

