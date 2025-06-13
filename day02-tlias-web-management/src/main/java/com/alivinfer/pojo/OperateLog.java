package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Fer
 * @version 1.0
 * @description 操作日志实体类
 * @date 2025/5/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {
    /**
     * 主键 ID
     */
    private Integer id;

    /**
     *  操作人ID
     */
    private Integer operateEmpId;

    /**
     * 操作人名称
     */
    private String operateEmpName;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 操作类名
     */
    private String className;

    /**
     * 操作方法名
     */
    private String methodName;

    /**
     * 操作方法参数
     */
    private String methodParams;

    /**
     * 操作方法返回值
     */
    private String returnValue;

    /**
     * 操作耗时
     */
    private Long costTime;
}
