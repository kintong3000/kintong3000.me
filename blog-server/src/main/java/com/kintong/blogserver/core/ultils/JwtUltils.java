package com.kintong.blogserver.core.ultils;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kintong.blogserver.commons.consts.Const;
import com.kintong.blogserver.entity.dto.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author kintong
 */

@Slf4j
@Component
public class JwtUltils {

    @Value("${spring.security.jwt.key}")
    String key;

    @Value("${spring.security.jwt.expire}")
    int expire;
    @Autowired
    StringRedisTemplate template;

    public String createJwt(UserDetails userDetails, Account account) {
        Algorithm algorithm = Algorithm.HMAC256(key);
        Date expire = expireTime();
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("id", account.getId())
                .withClaim("username", account.getUsername())
                .withClaim("authorities", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withExpiresAt(expire)
                .withIssuedAt(new Date())
                .sign(algorithm);

    }


    public boolean deleateJwt(String header) {
        String token = convertToken(header);
        if (token == null) {
            return false;
        }
        DecodedJWT jwt = resolveJwt(token);
        String id = jwt.getId();
        Date jwtExpire = jwt.getExpiresAt();
        long expire = Math.max(jwtExpire.getTime() - System.currentTimeMillis(), 0);
        template.opsForValue().set(Const.JWT_BLACK_LIST + id, "", expire, TimeUnit.MILLISECONDS);
        return true;

    }

    public DecodedJWT resolveJwt(String token) {
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            if (!isValid(decodedJWT)) {
                return null;
            }
            return decodedJWT;
        } catch (JWTVerificationException e) {
            return null;
        }

    }

    public UserDetails toUser(DecodedJWT decodedJWT){
        Map<String, Claim> claims = decodedJWT.getClaims();
        return User.withUsername(claims.get("username").asString())
                .password("*****")
                .authorities(claims.get("authorities").asArray(String.class))
                .build();
    }

    public boolean isValid(DecodedJWT decodedJWT) {
        Date expire = decodedJWT.getExpiresAt();
        Date now = new Date();
        boolean isInvalidated = isInvalidated(decodedJWT.getId());
        if (!expire.before(now) && !isInvalidated) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isInvalidated(String id) {
        return Boolean.TRUE.equals(template.hasKey(Const.JWT_BLACK_LIST + id));
    }

    public Date expireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, expire);
        return calendar.getTime();
    }

    public String convertToken(String headerToken) {
        if (headerToken == null || !headerToken.startsWith("Bearer ")) {
            return null;
        }
        return headerToken.replace("Bearer ", "");
    }

}
