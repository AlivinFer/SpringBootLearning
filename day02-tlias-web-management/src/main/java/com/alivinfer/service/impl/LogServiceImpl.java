package com.alivinfer.service.impl;

import com.alivinfer.mapper.LogMapper;
import com.alivinfer.pojo.LogQueryParam;
import com.alivinfer.pojo.OperateLog;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.service.LogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 日志实现类
 * @date 2025/6/10
 */

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<OperateLog> page(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());

        List<OperateLog> logList = logMapper.list(logQueryParam);

        // 封装结果并返回
        Page<OperateLog> pageResult = (Page<OperateLog>) logList;
        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }
}
