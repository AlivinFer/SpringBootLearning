package com.alivinfer.service.impl;

import com.alivinfer.mapper.ClazzMapper;
import com.alivinfer.pojo.Clazz;
import com.alivinfer.pojo.ClazzQueryParam;
import com.alivinfer.pojo.PageResult;
import com.alivinfer.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 班级业务实现类
 * @date 2025/5/12
 */

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> list(ClazzQueryParam clazzQueryParam) {
        // 设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        // 查询班级信息
        List<Clazz> clazzPageResult = clazzMapper.list(clazzQueryParam);

        // 封装结果并返回
        Page<Clazz> pageResult = (Page<Clazz>) clazzPageResult;
        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.updateClazz(clazz);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.addClazz(clazz);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.deleteClazz(id);
    }
}
