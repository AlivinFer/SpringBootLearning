package com.alivinfer.aop;

import com.alivinfer.anno.LogOperation;
import com.alivinfer.mapper.OperateMapper;
import com.alivinfer.pojo.OperateLog;
import com.alivinfer.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Fer
 * @version 1.0
 * @description 操作日志切面类，用于拦截控制器方法并记录操作日志
 *              通过AOP（面向切面编程）实现对指定方法的环绕通知，记录方法执行的详细信息
 *              包括方法名称、参数、返回值、执行耗时以及操作人ID和名称，并将日志数据保存到数据库中
 * @date 2025/5/27
 */

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateMapper operateMapper;

    @Around("@annotation(logOperation)")
    public Object logAround(ProceedingJoinPoint joinPoint, LogOperation logOperation) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 执行目标方法
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        // 计算方法执行耗时
        long costTime = endTime - startTime;

        // 创建操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getOperateEmpId());
        operateLog.setOperateEmpName(getOperateEmpName());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setCostTime(costTime);
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");

        // 保存操作日志
        log.info("操作日志: {}", operateLog);
        operateMapper.insert(operateLog);

        return result;
    }

    private Integer getOperateEmpId() {
        return CurrentHolder.getCurrentUserId();
    }

    private String getOperateEmpName() {
        return CurrentHolder.getUsername();
    }

    // 在此处理会干扰 @Around 的后续处理逻辑
   /* @After("@annotation(logOperation)")
    public void removeThreadLocal(LogOperation logOperation) {
        System.out.println("执行 removeThreadLocal 操作");
        CurrentHolder.remove();
    }*/
}
