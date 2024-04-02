package com.kintong.blogserver.handler;


import com.kintong.blogserver.core.ultils.ApiResult;
import com.kintong.blogserver.core.ultils.JwtUltils;
import com.kintong.blogserver.core.ultils.ServletUtil;
import com.kintong.blogserver.entity.dto.Account;
import com.kintong.blogserver.entity.vo.AuthorizeVO;
import com.kintong.blogserver.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author kintong
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    AccountService accountService;

    @Autowired
    JwtUltils jwtUltils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        Account account = accountService.findAccountByUserNameOrEmail(user.getUsername());
        String token = jwtUltils.createJwt(user,account);
        AuthorizeVO vo = new AuthorizeVO();
        BeanUtils.copyProperties(account,vo);
        vo.setExpire(jwtUltils.expireTime());
        vo.setToken(token);
        ServletUtil.renderString(response, ApiResult.success(vo).toJsonString());


    }
}
