package com.alivinfer.service.impl;

import com.alivinfer.mapper.EmpLogMapper;
import com.alivinfer.pojo.EmpLog;
import com.alivinfer.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fer
 * @version 1.0
 * @description 员工管理日志实现类
 * @date 2025/4/30
 */

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    //事务传播行为,创建一个新事务执行
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
