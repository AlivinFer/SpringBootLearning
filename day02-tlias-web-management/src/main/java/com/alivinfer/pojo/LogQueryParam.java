package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 日志分页查询参数
 * @date 2025/6/10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogQueryParam {

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页展示条数
     */
    private Integer pageSize = 10;
}
