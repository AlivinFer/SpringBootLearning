package com.alivinfer.mapper;

import com.alivinfer.pojo.LogQueryParam;
import com.alivinfer.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 日志操作数据层
 * @date 2025/6/10
 */

@Mapper
public interface LogMapper {

    List<OperateLog> list(LogQueryParam logQueryParam);
}
