package com.alivinfer.mapper;

import com.alivinfer.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 员工工作经历
 * @date 2025/4/26
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历
     * @param exprList 员工经历
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 批量根据 id 删除员工工作经历
     * @param empIds 员工 id
     */
    void deleteByEmpIds(List<Integer> empIds);
}
