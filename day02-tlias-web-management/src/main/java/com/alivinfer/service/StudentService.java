package com.alivinfer.service;

import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Student;
import com.alivinfer.pojo.StudentQueryParam;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 学员业务接口
 * @date 2025/5/15
 */
public interface StudentService {

    /**
     * 学员管理-分页查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 学员管理-新增
     */
    void add(Student student);

    /**
     * 学员管理-根据id查询学员
     */
    Student findById(Integer id);

    /**
     * 学员管理-修改
     */
    void update(Student student);

    /**
     * 学员管理-批量删除
     */
    void delete(List<Integer> ids);

    /**
     * 学员管理-违纪处理
     */
    void violation(Integer id, Integer score);
}
