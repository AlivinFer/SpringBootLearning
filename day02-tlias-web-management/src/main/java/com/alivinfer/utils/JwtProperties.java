package com.alivinfer.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Fer
 * @version 1.0
 * @description JWT 配置
 * @date 2025/6/11
 */

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 签名密钥
     */
    private String secretKey;

    /**
     * 过期时间
     */
    private long expiration;
}
