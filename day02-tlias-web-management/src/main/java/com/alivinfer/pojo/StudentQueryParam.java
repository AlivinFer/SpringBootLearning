package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 学员查询参数
 * @date 2025/5/14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {

    /**
     * 学员姓名
     */
    private String name;

    /**
     * 学号
     */
    private String no;

    /**
     * 最高学历
     */
    private Integer degree;

    /**
     * 所属班级
     */
    private Integer clazzId;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页数量
     */
    private Integer pageSize = 10;
}
