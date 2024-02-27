package com.kintong.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kintong.blogserver.entity.dto.Account;
import com.kintong.blogserver.mapper.AccountMapper;
import com.kintong.blogserver.service.AccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author kintong
 */
@Service
public class AccountServiceimpl extends ServiceImpl<AccountMapper, Account>  implements AccountService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.findAccountByUserNameOrEmail(username);
        if(account == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User.withUsername(username)
                .password(account.getPassword())
                .roles(account.getRole())
                .build();

    }



    public Account findAccountByUserNameOrEmail(String text){
        return this.query()
                .eq("username", text).or()
                .eq("email", text)
                .one();
    }
}
