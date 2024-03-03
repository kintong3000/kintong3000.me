package com.kintong.blogserver.handler;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.commons.ultils.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author kintong
 */
@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint {
    //认证失败
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String apiResult = ApiResult.failure(ApiCode.UNAUTHORIZED).toJsonString();
        ServletUtil.renderString(response,apiResult);
    }
}
