package com.kintong.blogserver.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author kintong
 */
@Data
@TableName("account")
public class Account {
    @TableId(type = IdType.AUTO)
    Integer id;
    @TableField("username")
    String username;
    @TableField("email")
    String email;
    @TableField("password")
    String password;
    @TableField("role")
    String role;
}
