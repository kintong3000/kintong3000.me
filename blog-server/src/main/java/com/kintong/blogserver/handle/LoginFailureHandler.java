package com.kintong.blogserver.handle;

import com.kintong.blogserver.commons.consts.ApiCode;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.commons.ultils.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author kintong
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String apiResult = ApiResult.failure(ApiCode.LOGIN_EXCEPTION).toJsonString();
        ServletUtil.renderString(response,apiResult);

    }
}
