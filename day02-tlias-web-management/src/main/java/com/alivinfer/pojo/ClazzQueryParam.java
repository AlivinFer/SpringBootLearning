package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Fer
 * @version 1.0
 * @description 班级查询参数
 * @date 2025/5/12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {

    /**
     * 班级名称
     */
    private String name;

    /**
     * 结课时间的开始时间
     */
    private LocalDate begin;

    /**
     * 结课时间的结束时间
     */
    private LocalDate end;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页展示记录数
     */
    private Integer pageSize = 10;
}
