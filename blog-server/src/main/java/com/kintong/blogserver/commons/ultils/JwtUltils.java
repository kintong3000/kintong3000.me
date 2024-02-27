package com.kintong.blogserver.commons.ultils;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;

import com.kintong.blogserver.entity.dto.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @Author kintong
 */
@Component
public class JwtUltils {

    @Value("${spring.security.jwt.key}")
    String key;

    @Value("${spring.security.jwt.expire}")
    int expire;

    public String createJwt(UserDetails userDetails, Account account){
        Algorithm algorithm = Algorithm.HMAC256(key);
        Date expire = expireTime();
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("id",account.getId())
                .withClaim("username",account.getUsername())
                .withClaim("authorities",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withExpiresAt(expire)
                .withIssuedAt(new Date())
                .sign(algorithm);

    }

    public Date expireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, expire);
        return calendar.getTime();
    }

}
