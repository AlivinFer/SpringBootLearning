package com.alivinfer.service;

import com.alivinfer.pojo.Dept;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 部门服务接口
 * @date 2025/4/24
 */
public interface DeptService {

    /**
     * 部门管理 -- 查询所有部门
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 部门管理 -- 根据 id 删除
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 部门管理 -- 新增部门
     * @param dept 部门信息
     */
    void add(Dept dept);

    /**
     * 部门管理 -- 根据 id 查找
     * @param deptId 部门 id
     * @return 部门信息
     */
    Dept findById(Integer deptId);

    /**
     * 部门管理 -- 更新部门信息
     * @param dept 部门信息
     */
    void update(Dept dept);
}
