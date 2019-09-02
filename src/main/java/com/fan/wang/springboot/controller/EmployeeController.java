package com.fan.wang.springboot.controller;

import com.fan.wang.springboot.entity.Employee;
import com.fan.wang.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("/emp/query/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        return iEmployeeService.getEmployeeById(id);
    }

    @PostMapping("/emp/post")
    public Employee updateEmployee(@RequestBody Employee employeeList){
        return iEmployeeService.updateEmployee(employeeList);
    }
}
