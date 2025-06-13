package com.alivinfer.service;

import com.alivinfer.pojo.EmpLog;
import org.springframework.stereotype.Service;

/**
 * @author Fer
 * @version 1.0
 * @description 员工管理日志业务
 * @date 2025/4/30
 */

public interface EmpLogService {

    public void insertLog(EmpLog empLog);
}
