package com.fan.wang.springboot.controller;

import com.fan.wang.springboot.entity.Department;
import com.fan.wang.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private IDeptService iDeptService;
    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return iDeptService.getDeptById(id);
    }
}
