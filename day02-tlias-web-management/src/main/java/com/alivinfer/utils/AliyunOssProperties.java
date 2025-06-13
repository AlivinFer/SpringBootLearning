package com.alivinfer.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Fer
 * @version 1.0
 * @description 阿里云配置实体类（简化注入配置）
 * @date 2025/5/3
 */

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOssProperties {

    /**
     * 访问域名
     */
    private String endpoint;

    /**
     * 存储空间名称
     */
    private String bucketName;

    /**
     * 存储区域
     */
    private String region;
}
