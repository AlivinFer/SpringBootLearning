package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 员工职位柱状图和饼状图实体类
 * @date 2025/5/7
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {

    /**
     * 员工职位列表
     */
    private List<Object> jobList;

    /**
     * 员工职位对应人数列表
     */
    private List<Object> dataList;
}
