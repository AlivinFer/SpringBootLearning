package com.alivinfer.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Fer
 * @version 1.0
 * @description 预热数据库连接池
 * @date 2025/6/10
 */

@Slf4j
@Component
public class DatabasePreHeater {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void warmUp() {
        try {
            log.info("开始预热数据库连接池...");
            jdbcTemplate.execute("SELECT 1");
            log.info("数据库连接池预热完成！");
        } catch (Exception e) {
            log.error("数据库预热失败", e);
        }
    }
}
