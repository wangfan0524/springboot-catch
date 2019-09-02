package com.fan.wang.springboot.service;

import com.fan.wang.springboot.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee getEmployeeById(Integer id);

    Employee updateEmployee(Employee employeeList);
}
