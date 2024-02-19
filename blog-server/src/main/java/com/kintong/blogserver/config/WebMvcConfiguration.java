package com.kintong.blogserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {



//自定义静态资源的映射路径和资源位置
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("").addResourceLocations("file:");
//    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();

    }

}
