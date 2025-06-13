package com.alivinfer.mapper;

import com.alivinfer.pojo.Student;
import com.alivinfer.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Fer
 * @version 1.0
 * @description 学员数据接口层
 * @date 2025/5/14
 */

@Mapper
public interface StudentMapper {

    /**
     * 分页查询学生数据
     * @return 学生列表数据
     */
    List<Student> list(StudentQueryParam studentQueryParam);

    /**
     * 新增学员
     * @param student 学员信息
     */
    void insertStu(Student student);

    /**
     * 根据 id 查询学员信息
     * @param id id
     * @return 学员信息
     */
    Student getById(Integer id);

    /**
     * 更新学员信息
     * @param student 学员信息
     */
    void updateStu(Student student);

    /**
     * 批量删除学员
     * @param ids 学员 id 列表
     */
    void deleteStu(List<Integer> ids);

    /**
     * 违纪处理
     * @param id id
     * @param score 扣分
     */
    void violation(Integer id, Integer score);

    /**
     * 统计学员数量
     * @return 学员数量信息
     */
    List<Map<String, Object>> countStuNumData();

    /**
     * 统计学员学历信息
     * @return 学员学历信息
     */
    List<Map<String, Object>> countStuEduData();
}
