package com.alivinfer.controller;

import com.alivinfer.pojo.JobOption;
import com.alivinfer.pojo.Result;
import com.alivinfer.pojo.StudentOption;
import com.alivinfer.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Fer
 * @version 1.0
 * @description 报表统计控制层
 * @date 2025/5/8
 */

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("count emp job data");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("count emp gender data");

        List<Map<String, Object>> genderData = reportService.getEmpGenderData();
        return Result.success(genderData);
    }

    /**
     * 获取班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getClassNumData() {
        log.info("获取班级人数统计");
        StudentOption studentOption = reportService.getStudentCountData();
        return Result.success(studentOption);
    }

    /**
     * 获取学员学历统计
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentEduData() {
        log.info("获取学员学历统计");
        List<Map<String, Object>> eduList = reportService.getStudentEduData();
        return Result.success(eduList);
    }
}
