package com.alivinfer.service;

import com.alivinfer.pojo.Clazz;
import com.alivinfer.pojo.ClazzQueryParam;
import com.alivinfer.pojo.PageResult;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 班级服务类
 * @date 2025/5/12
 */
public interface ClazzService {

    /**
     * 班级管理-分页查询班级数据
     * @param clazzQueryParam 查询参数
     * @return 班级数据列表
     */
    PageResult<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 班级管理-新增班级
     * @param clazz 班级信息
     */
    void save(Clazz clazz);

    /**
     * 班级管理 - 根据 id 查询班级信息
     * @param id id
     * @return 班级信息
     */
    Clazz getById(Integer id);

    /**
     * 班级管理 - 更新班级信息
     * @param clazz 班级信息
     */
    void update(Clazz clazz);

    /**
     * 班级管理 - 根据 id 删除班级
     * @param id id
     */
    void delete(Integer id);
}
