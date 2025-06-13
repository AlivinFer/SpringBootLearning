package com.alivinfer.service.impl;

import com.alivinfer.mapper.EmpExprMapper;
import com.alivinfer.mapper.EmpMapper;
import com.alivinfer.pojo.*;
import com.alivinfer.service.EmpLogService;
import com.alivinfer.service.EmpService;
import com.alivinfer.utils.JwtUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Fer
 * @version 1.0
 * @description 员工服务类
 * @date 2025/4/26
 */

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 查询员工总数
        Long total = empMapper.count();

        // 计算起始索引
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        return new PageResult<Emp>(total, rows);
    }

    @Override
    public PageResult<Emp> listPage(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<Emp> empList = empMapper.listPage(page, pageSize);

        // 解析数据，封装结果
        Page<Emp> emps = (Page<Emp>) empList;

        return new PageResult<>(emps.getTotal(), emps.getResult());
    }

    @Override
    public PageResult<Emp> searchEmp(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 执行查询
        List<Emp> empList = empMapper.searchEmp(empQueryParam);

        // 解析数据，封装结果
        Page<Emp> emps = (Page<Emp>) empList;

        return new PageResult<>(emps.getTotal(), emps.getResult());
    }

    // 事务管理（一般对数据库进行多次操作时需要）-- 默认出现运行时异常 RuntimeException 才会回滚
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) throws Exception{

        try {
            // 保存员工基本信息(操作数据库后会将主键返回)
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 保存员工工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                // 前端传参时是缺少员工 id 的，需要遍历进行赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                // 添加日志，查看数据
                log.info("员工工作经历数据: {}", exprList);
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 无论操作成功还是失败都需要写入日志（需关联新建事务）
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工信息：" + emp.toString());
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        // 批量删除员工
        empMapper.deleteByIds(ids);

        // 批量删除员工工作经历
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        // 根据 id 查询员工信息
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class) //事务管理
    @Override
    public void update(Emp emp) {
        // 1.根据 id 修改员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 2. 根据 id 修改员工工作经历信息--先删除再添加
        // 2.1 删除员工工作经历信息
        empExprMapper.deleteByEmpIds(Collections.singletonList(emp.getId()));
        // 2.2 添加员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public LoginInfo login(Emp emp) {
        // 1. 根据用户名查询员工信息
        Emp e = empMapper.selectByUsernameAndPwd(emp);
        // 2. 判断员工是否存在，如果存在组装登陆成功的信息
        if (e != null){
            log.info("员工登录成功:{}", e);

            // 生成JWT令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = jwtUtil.generateToken(claims);

            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }
        // 3. 如果员工不存在，返回登陆失败的信息
        return null;
    }
}
