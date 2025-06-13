package com.alivinfer.mapper;

import com.alivinfer.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fer
 * @version 1.0
 * @description 日志操作 mapper 接口
 * @date 2025/5/27
 */

@Mapper
public interface OperateMapper {

    public void insert(OperateLog log);
}
