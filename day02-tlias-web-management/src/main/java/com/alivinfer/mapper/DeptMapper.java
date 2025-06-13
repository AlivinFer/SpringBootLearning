package com.alivinfer.mapper;

import com.alivinfer.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 部门 mapper
 * @date 2025/4/24
 */
@Mapper
public interface DeptMapper {

    @Select("select `id`, `name`, `create_time`, `update_time` from dept order by `id`")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(`name`, `create_time`, `update_time`) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    @Select("select `id`, `name`, `create_time`, `update_time` from dept where `id` = #{deptId}")
    Dept findById(Integer deptId);

    @Update("update dept set `name` = #{name}, `update_time` = #{updateTime} where `id` = #{id}")
    void update(Dept dept);
}
