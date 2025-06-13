package com.alivinfer.service.impl;

import com.alivinfer.mapper.DeptMapper;
import com.alivinfer.pojo.Dept;
import com.alivinfer.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 部门实现类
 * @date 2025/4/24
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer deptId) {
        return deptMapper.findById(deptId);
    }

    @Override
    public void update(Dept dept) {
        // 更新时间
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }
}
