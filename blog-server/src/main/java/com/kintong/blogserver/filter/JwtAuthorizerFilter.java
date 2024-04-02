package com.kintong.blogserver.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.kintong.blogserver.core.ultils.JwtUltils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @Author kintong
 */
@Slf4j
@Component
public class JwtAuthorizerFilter extends OncePerRequestFilter {
    @Autowired
    JwtUltils jwtUltils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        DecodedJWT decodedJWT = jwtUltils.resolveJwt(jwtUltils.convertToken(headerToken));
        if (decodedJWT != null){
            UserDetails userDetails = jwtUltils.toUser(decodedJWT);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            request.setAttribute("id",decodedJWT.getId());
        }
        filterChain.doFilter(request, response);

    }
}
