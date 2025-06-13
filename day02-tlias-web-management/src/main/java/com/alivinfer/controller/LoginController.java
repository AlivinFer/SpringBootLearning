package com.alivinfer.controller;

import com.alivinfer.pojo.Emp;
import com.alivinfer.pojo.LoginInfo;
import com.alivinfer.pojo.Result;
import com.alivinfer.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fer
 * @version 1.0
 * @description 登录控制管理类
 * @date 2025/5/26
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * 登录模块-登录功能
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录: {}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
