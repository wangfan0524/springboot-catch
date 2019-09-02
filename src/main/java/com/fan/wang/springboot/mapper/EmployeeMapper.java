package com.fan.wang.springboot.mapper;

import com.fan.wang.springboot.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM EMPLOYEE WHERE ID =#{id}")
    Employee getEmployeeById(Integer id);

    @Update("UPDATE EMPLOYEE SET lastName=#{lastName},email=#{email} where id=#{id}")
    void updateEmployee(Integer getdId);
}
