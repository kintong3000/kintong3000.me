package com.kintong.blogserver.handle;

import com.kintong.blogserver.commons.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.commons.ultils.JwtUltils;
import com.kintong.blogserver.commons.ultils.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author kintong
 */
@Component
public class LogoutHandler implements LogoutSuccessHandler {

    @Autowired
    JwtUltils jwtUltils;


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        if (jwtUltils.deleateJwt(token)){
            ServletUtil.renderString(response, ApiResult.success("注销成功").toJsonString());
            return;
        }
        ServletUtil.renderString(response,ApiResult.failure(ApiCode.FAIL).toJsonString());
    }
}
