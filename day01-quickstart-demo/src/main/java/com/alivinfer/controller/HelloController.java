package com.alivinfer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fer
 * @version 1.0
 * @description 测试 demo
 * @date 2025/4/16
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("HelloController ... hello: " + name);
        return "Hello " + name;
    }
}
