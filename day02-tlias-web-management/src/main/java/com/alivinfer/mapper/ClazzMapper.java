package com.alivinfer.mapper;

import com.alivinfer.pojo.Clazz;
import com.alivinfer.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 班级数据接口层
 * @date 2025/5/12
 */
@Mapper
public interface ClazzMapper {

    /**
     * 分页查询班级信息
     * @param clazzQueryParam 查询参数
     * @return 班级数据
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 新增班级
     * @param clazz 班级信息
     */
    void addClazz(Clazz clazz);

    /**
     * 根据 id 查询班级信息
     * @param id id
     * @return 班级信息
     */
    Clazz selectById(Integer id);

    /**
     * 班级管理 - 更新班级信息
     * @param clazz 班级信息
     */
    void updateClazz(Clazz clazz);

    /**
     * 班级管理 - 根据 id 删除班级
     * @param id id
     */
    void deleteClazz(Integer id);
}
