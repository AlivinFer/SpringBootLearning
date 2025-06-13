package com.alivinfer.controller;

import com.alivinfer.pojo.LogQueryParam;
import com.alivinfer.pojo.OperateLog;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Result;
import com.alivinfer.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fer
 * @version 1.0
 * @description TODO
 * @date 2025/6/10
 */

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(LogQueryParam logQueryParam) {
        log.info("分页查询日志信息,参数: {}", logQueryParam);
        PageResult<OperateLog> page = logService.page(logQueryParam);
        return Result.success(page);
    }
}
