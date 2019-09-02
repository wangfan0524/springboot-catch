package com.fan.wang.springboot.mapper;

import com.fan.wang.springboot.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM DEPARTMENT WHERE ID =#{id}")
    Department getDeptById(Integer id);
}
