package com.alivinfer.controller;

import com.alivinfer.anno.LogOperation;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Result;
import com.alivinfer.pojo.Student;
import com.alivinfer.pojo.StudentQueryParam;
import com.alivinfer.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 学员管理控制类
 * @date 2025/5/15
 */

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam) {
        log.info("分页查询学员信息,参数：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 学员管理-- 新增学员
     */
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("新增学员信息,参数：{}", student);
        studentService.add(student);
        return Result.success();
    }

    /**
     * 学员管理-- 根据id查询学员
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        log.info("根据id查询学员信息,参数：{}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    /**
     * 学员管理-- 根据id修改学员
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员信息,参数：{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 学员管理-- 根据id批量删除学员
     */
    @LogOperation
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {
        log.info("删除学员信息,参数：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    /**
     * 学员管理-- 违纪处理
     */
    @LogOperation
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable("id") Integer id, @PathVariable("score") Integer score) {
        log.info("学员违纪处理,参数：{},违纪分数:{}", id,score);
        studentService.violation(id, score);
        return Result.success();
    }
}
