package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Fer
 * @version 1.0
 * @description 员工搜索请求参数类
 * @date 2025/4/26
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpQueryParam {

    /**
     *  当前页码
     */
    private Integer page = 1;

    /**
     * 每页显示条数
     */
    private Integer pageSize = 10;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 1：男 2：女
     */
    private Integer gender;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
