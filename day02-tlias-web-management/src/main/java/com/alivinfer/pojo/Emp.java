package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 员工实体类
 * @date 2025/4/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 性别 1：男 2：女
     */
    private Integer gender;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师
     */
    private Integer job;

    /**
     * 薪水
     */
    private Integer salary;

    /**
     * 图像
     */
    private String image;

    /**
     * 入职日期
     */
    private LocalDate entryDate;

    /**
     * 外键 -- 部门 Id
     */
    private Integer deptId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 工作经历
     */
    private List<EmpExpr> exprList;
}
