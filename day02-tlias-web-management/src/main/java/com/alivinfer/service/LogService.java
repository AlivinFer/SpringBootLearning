package com.alivinfer.service;

import com.alivinfer.pojo.LogQueryParam;
import com.alivinfer.pojo.OperateLog;
import com.alivinfer.pojo.PageResult;

/**
 * @author Fer
 * @version 1.0
 * @description 日志实现服务
 * @date 2025/6/10
 */
public interface LogService {

    /**
     * 日志管理--分页查询
     */
    PageResult<OperateLog> page(LogQueryParam logQueryParam);
}
