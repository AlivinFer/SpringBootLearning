package com.alivinfer.controller;

import com.alivinfer.anno.LogOperation;
import com.alivinfer.pojo.Emp;
import com.alivinfer.pojo.EmpQueryParam;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Result;
import com.alivinfer.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 员工管理类
 * @date 2025/4/26
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;


    /**
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询: {}, {}", page, pageSize);
//        PageResult<Emp> empPageResult = empService.page(page, pageSize);
        // 基于 pageHelper 进行分页查询
        PageResult<Emp> empPageResult = empService.listPage(page, pageSize);
        return Result.success(empPageResult);
    }*/

    /**
     * 分页查询（优化版本）
     * @return 员工分页查询结果
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询员工信息,参数: {}", empQueryParam);
        PageResult<Emp> empPageResult = empService.searchEmp(empQueryParam);
        return Result.success(empPageResult);
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("新增员工信息: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工的id: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询员工信息id: {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息,参数: {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
