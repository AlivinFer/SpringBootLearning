package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Fer
 * @version 1.0
 * @description 员工管理日志
 * @date 2025/4/30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpLog {

    /**
     * 主键 ID
     */
    private Integer id;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 详细信息
     */
    private String info;
}
