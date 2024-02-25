package com.kintong.blogserver.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kintong.blogserver.commons.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.commons.ultils.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * @Author kintong
 */

public class UnauthorizedHandle implements AuthenticationEntryPoint {
    //认证失败
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String apiResult = ApiResult.fail(ApiCode.UNAUTHORIZED).toJsonString();
        ServletUtil.renderString(response,apiResult);
    }
}
