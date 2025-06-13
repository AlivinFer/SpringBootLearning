package com.alivinfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Fer
 * @version 1.0
 * @description Tlias web 管理系统
 * @date 2025/4/24
 */

//@ServletComponentScan   //开启对Servlet组件的支持
@SpringBootApplication
public class Day02TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day02TliasWebManagementApplication.class, args);
    }
}
