package com.alivinfer.service;

import com.alivinfer.pojo.Emp;
import com.alivinfer.pojo.EmpQueryParam;
import com.alivinfer.pojo.LoginInfo;
import com.alivinfer.pojo.PageResult;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 员工业务类接口
 * @date 2025/4/26
 */
public interface EmpService {

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页个数
     * @return 员工信息
     */
    PageResult<Emp> page(Integer page, Integer pageSize);

    /**
     * 分页查询 -- 基于 PageHelper 实现
     * @param page 页码
     * @param pageSize 每页个数
     * @return 员工信息
     * 注意事项：
     *  1. 定义的 SQL 语句解为不能加分号
     *  2. PageHelper 仅仅能对紧跟其后的第一个查询语句进行分页处理
     *
     */
    PageResult<Emp> listPage(Integer page, Integer pageSize);

    /**
     * 封装查询参数
     * @param empQueryParam 查询参数
     * @return 分页员工信息
     */
    PageResult<Emp> searchEmp(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     * @param emp 员工信息
     */
    void save(Emp emp) throws Exception;

    /**
     * 批量删除员工
     * @param ids 员工 id 集合
     */
    void delete(List<Integer> ids);

    /**
     * 根据 id 查询员工信息
     * @param id 主键
     * @return 员工信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp 员工用户名和密码
     * @return 认证信息
     */
    LoginInfo login(Emp emp);
}
