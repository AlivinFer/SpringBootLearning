package com.alivinfer.service.impl;

import com.alivinfer.mapper.EmpMapper;
import com.alivinfer.mapper.StudentMapper;
import com.alivinfer.pojo.JobOption;
import com.alivinfer.pojo.StudentOption;
import com.alivinfer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Fer
 * @version 1.0
 * @description 报表服务实现类
 * @date 2025/5/8
 */

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> empJobData = empMapper.countEmpJobData();

        List<Object> jobList = empJobData.stream().map(dataMap -> dataMap.get("pos")).toList();

        List<Object> dataList = empJobData.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderDate();
    }

    @Override
    public StudentOption getStudentCountData() {
        List<Map<String, Object>> stuNumData = studentMapper.countStuNumData();

        List<Object> clazzList = stuNumData.stream().map(dataMap -> dataMap.get("cname")).toList();

        List<Object> dataList = stuNumData.stream().map(dataMap -> dataMap.get("scount")).toList();

        return new StudentOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentEduData() {
        return studentMapper.countStuEduData();
    }
}
