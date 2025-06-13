package com.alivinfer.controller;

import com.alivinfer.anno.LogOperation;
import com.alivinfer.pojo.Dept;
import com.alivinfer.pojo.Result;
import com.alivinfer.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 部门管理类
 * @date 2025/4/24
 */

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        log.info("查询所有部门:{}", deptList);
        return Result.success(deptList);
    }

    @LogOperation
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        try {
            log.info("删除部门id为：{}", id);
            deptService.deleteById(id);
            return Result.success();
        } catch (Exception e) {
            log.error("删除部门失败：{}", e.getMessage());
            return Result.error(e.getMessage());
        }

    }

    @LogOperation
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        log.info("添加部门:{}",dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer deptId) {
        log.info("查询部门id为：{}", deptId);
        Dept dept = deptService.findById(deptId);
        return Result.success(dept);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        log.info("修改部门:{}", dept);
        return Result.success();
    }

}
