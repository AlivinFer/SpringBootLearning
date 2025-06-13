package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 学员统计模块-柱状图
 * @date 2025/5/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOption {

    /**
     * 班级信息
     */
    private List<Object> clazzList;

    /**
     * 人数信息
     */
    private List<Object> dataList;
}
