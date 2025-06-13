package com.alivinfer.mapper;

import com.alivinfer.pojo.Emp;
import com.alivinfer.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Fer
 * @version 1.0
 * @description 员工信息
 * @date 2025/4/26
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return 总数
     */
    @Select("select count(*) from emp e left join dept d on e.`dept_id` = d.`id`")
    Long count();

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录
     * @return 员工分页数据信息
     */
    @Select("select e.*, d.name deptName from emp e left join dept d on " +
            "e.`dept_id` = d.`id` order by e.`update_time` desc limit #{page}, #{pageSize}")
    List<Emp> list(Integer page, Integer pageSize);

    /**
     * 基于 pageHelper 插件进行分页查询
     * @param page 页码
     * @param pageSize 每页大小
     * @return 每页数据信息
     */
    @Select("select e.*, d.name deptName from emp e left join dept d on " +
            "e.`dept_id` = d.`id` order by e.`update_time` desc")
    List<Emp> listPage(Integer page, Integer pageSize);

    /**
     * 封装参数查询员工信息
     * @param empQueryParam 查询参数
     * @return 员工信息
     */
    List<Emp> searchEmp(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     * @param emp 员工信息
     */
    void insert(Emp emp);

    /**
     * 批量根据 id 删除员工基本信息
     * @param ids 员工 id
     */
    void deleteByIds(List<Integer> ids);

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
    void updateById(Emp emp);

    /**
     * 统计员工信息
     * @return 员工职业信息及对应数量
     */
    @MapKey("job")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     * @return 性别数据集合信息
     */
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderDate();

    /**
     * 员工登录
     * @param emp 用户名和密码
     * @return 员工信息
     */
    Emp selectByUsernameAndPwd(Emp emp);
}
