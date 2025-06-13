package com.alivinfer.service.impl;

import com.alivinfer.mapper.StudentMapper;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Student;
import com.alivinfer.pojo.StudentQueryParam;
import com.alivinfer.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 学员管理实现类
 * @date 2025/5/15
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // 设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        // 调用分页查询的方法
        List<Student> studentList = studentMapper.list(studentQueryParam);

        // 封装结果并返回
        Page<Student> pageResult = (Page<Student>) studentList;
        return new PageResult<> (pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        studentMapper.insertStu(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("id 不能为空");
        }
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStu(student);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteStu(ids);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id, score);
    }
}
