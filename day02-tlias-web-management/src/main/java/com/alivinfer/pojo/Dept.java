package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Fer
 * @version 1.0
 * @description 部门实体类
 * @date 2025/4/24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    /**
     * id
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
