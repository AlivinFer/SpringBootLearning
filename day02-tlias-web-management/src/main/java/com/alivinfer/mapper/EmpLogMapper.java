package com.alivinfer.mapper;

import com.alivinfer.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fer
 * @version 1.0
 * @description 员工管理日志
 * @date 2025/4/30
 */
@Mapper
public interface EmpLogMapper {

    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    void insert(EmpLog empLog);
}
