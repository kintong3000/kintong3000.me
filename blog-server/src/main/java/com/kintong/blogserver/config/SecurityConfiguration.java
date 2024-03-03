package com.kintong.blogserver.config;

import com.kintong.blogserver.filter.JwtAuthorizerFilter;
import com.kintong.blogserver.filter.RequestLogFilter;
import com.kintong.blogserver.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UnauthorizedHandler unauthorizedHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Autowired
    PermissionDeniedHandler permissionDeniedHandler;

    @Autowired
    LogoutHandler logoutHandler;

    @Autowired
    JwtAuthorizerFilter authorizerFilter;

    @Autowired
    RequestLogFilter requestLogFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(conf -> conf
                        .requestMatchers("/admin/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(conf -> conf
                        .loginProcessingUrl("/admin/auth/login")
                        .successHandler(loginSuccessHandler)
                        .failureHandler(loginFailureHandler)
                )
                .logout(conf -> conf
                        .logoutUrl("/admin/auth/logout")
                        .logoutSuccessHandler(logoutHandler)
                )
                .exceptionHandling(conf -> conf
                        .authenticationEntryPoint(unauthorizedHandler)
                        .accessDeniedHandler(permissionDeniedHandler)
                )
                .sessionManagement(conf -> conf
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(AbstractHttpConfigurer::disable)
//                .addFilterBefore(authorizerFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(requestLogFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authorizerFilter, RequestLogFilter.class)
                .build();


    }


}
