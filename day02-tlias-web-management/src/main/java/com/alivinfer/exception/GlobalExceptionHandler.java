package com.alivinfer.exception;

import com.alivinfer.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Fer
 * @version 1.0
 * @description 全局异常处理器
 * @date 2025/5/5
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handlerException(Exception e) {
        log.error("系统异常", e);
        return Result.error("系统异常, 请稍后重试");
    }

    /**
     * ### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '15796358358' for key 'emp.phone'
     * ; Duplicate entry '15796358358' for key 'emp.phone'
     */
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("数据库中存在重复值", e);

        // 获取异常信息
        String message = e.getMessage();
        int duplicateEntry = message.lastIndexOf("Duplicate entry");
        String errMsg = message.substring(duplicateEntry);
        String[] splitMsg = errMsg.split(" ");

        return Result.error("存在重复项：" + splitMsg[2]);
    }
}
