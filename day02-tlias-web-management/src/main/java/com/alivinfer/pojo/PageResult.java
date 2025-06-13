package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 分页查询结果
 * @date 2025/4/26
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    /**
     * 总数
     */
    private Long total;

    /**
     * 当前页数据
     */
    private List<T> rows;
}
