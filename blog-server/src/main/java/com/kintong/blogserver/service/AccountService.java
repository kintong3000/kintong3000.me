package com.kintong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kintong.blogserver.entity.dto.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author kintong
 */
public interface AccountService extends IService<Account>, UserDetailsService {
    public Account findAccountByUserNameOrEmail(String text);

}
