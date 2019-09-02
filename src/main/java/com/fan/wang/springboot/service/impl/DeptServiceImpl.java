package com.fan.wang.springboot.service.impl;

import com.fan.wang.springboot.entity.Department;
import com.fan.wang.springboot.mapper.DepartmentMapper;
import com.fan.wang.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    @Cacheable(cacheNames = "getdept",key = "#id")
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }
}
