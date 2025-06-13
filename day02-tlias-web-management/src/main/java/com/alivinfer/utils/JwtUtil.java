package com.alivinfer.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.security.Key;

/**
 * @author Fer
 * @version 1.0
 * @description JWT 工具类
 * @date 2025/5/26
 */

@Component
public class JwtUtil {

    // 后续可优化成动态随机生成或从配置文件中读取
//    private static final String SECRET_KEY = "ZmVpenl5YW5n";

//    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    @Autowired
    private JwtProperties jwtProperties;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
    }

    /**
     * 生成 JWT 令牌
     * @param claims 用户 id 和 用户名的映射关系
     * @return 生成的令牌字符串
     */
    public String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .compact();

    }

    /**
     * 解析JWT令牌并返回其中的声明信息。
     * 该方法使用预定义的密钥对令牌进行验证，并解析出其中的声明信息。
     *
     * @param token 要解析的JWT令牌字符串
     * @return 返回解析出的声明信息
     */
    public Claims parseToken(String token) throws Exception {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
