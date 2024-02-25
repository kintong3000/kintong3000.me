package com.kintong.blogserver.commons.ultils;

import com.kintong.blogserver.commons.HttpStatus;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author kintong
 */
public class ServletUtil {
    public static void renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(HttpStatus.SUCCESS);
            response.setContentType("application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
