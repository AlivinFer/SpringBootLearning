package com.alivinfer.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Fer
 * @version 1.0
 * @description 工作经历
 * @date 2025/4/26
 */

@Data
public class EmpExpr {

    /**
     * ID 主键
     */
    private Integer id;

    /**
     * 员工 ID
     */
    private Integer empId;

    /**
     * 开始时间
     */
    private LocalDate begin;

    /**
     * 结束时间
     */
    private LocalDate end;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 职位
     */
    private String job;
}
