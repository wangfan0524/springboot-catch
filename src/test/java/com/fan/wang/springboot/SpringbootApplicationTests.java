package com.fan.wang.springboot;

import com.fan.wang.springboot.mapper.DepartmentMapper;
import com.fan.wang.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

/*
*
* 1:配置数据源
* */
public class SpringbootApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void contextLoads() {

        System.out.println(employeeMapper.getEmployeeById(1));
    }

}
