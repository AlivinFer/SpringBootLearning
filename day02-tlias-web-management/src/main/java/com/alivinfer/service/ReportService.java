package com.alivinfer.service;

import com.alivinfer.pojo.JobOption;
import com.alivinfer.pojo.StudentOption;

import java.util.List;
import java.util.Map;

/**
 * @author Fer
 * @version 1.0
 * @description 报表统计服务
 * @date 2025/5/8
 */
public interface ReportService {

    /**
     * 统计员工职位人数信息
     * @return 员工职位数据
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     * @return 员工性别数据
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计班级人数
     */
    StudentOption getStudentCountData();

    /**
     * 统计学员学历
     */
    List<Map<String, Object>> getStudentEduData();
}
