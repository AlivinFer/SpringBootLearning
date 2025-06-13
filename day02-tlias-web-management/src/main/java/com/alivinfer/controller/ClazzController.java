package com.alivinfer.controller;

import com.alivinfer.pojo.Clazz;
import com.alivinfer.pojo.ClazzQueryParam;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.pojo.Result;
import com.alivinfer.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fer
 * @version 1.0
 * @description 班级控制类
 * @date 2025/5/12
 */

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级信息,参数：{}", clazzQueryParam);
        PageResult<Clazz> clazzList = clazzService.list(clazzQueryParam);

        return Result.success(clazzList);
    }

    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级信息：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询班级信息：{}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息,参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        clazzService.delete(id);
        log.info("删除班级信息,参数：{}", id);
        return Result.success();
    }
}
