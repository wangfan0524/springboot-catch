package com.fan.wang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching


/*
*开启基于注解的缓存@EnableCaching
* 标注缓存注解
*      1： @Cacheable(cacheNames = "getemployee", key = "#id")
*
*
*
*
* */
public class SpringbootApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
