package com.fan.wang.springboot.service.impl;

import com.fan.wang.springboot.entity.Employee;
import com.fan.wang.springboot.mapper.EmployeeMapper;
import com.fan.wang.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate<Object,Employee> employeeRedisTemplate;

    /*
     *
     * cacheNames/values:指定缓存的名字
     * key:缓存数据使用的key;可以用它来指定。默认是使用方法参数的值
     *           编写SpEL表达式 #id去除参数ID的值
     * keyGenerator：key的生成器：可以自己指定key的生成器  和key二选一
     * cacheManager：指定缓存管理器(REDIS/ConcurrentHashMap)
     * condition: 指定符合条件的情况下才缓存：同样可以借助SpEL表达式  例如:@Cacheable(cacheNames = "getemployee", key = "#id"，condition="#id>0")
     * unless: 否定缓存，当unless指定的条件为true，方法返回值不会被缓存，可以获取结果进行缓存  例如:@CachePut(cacheNames = "getemployee", key = "#employee.id",unless="#result==null")
     * sync: 是否异步,默认false，为true不支持unless属性
     * */

    //缓存原理  CacheAutoConfiguration
    //通过Import导入了CacheConfigurationImportSelector，通过CacheConfigurationImportSelector的selectImports方法导入缓存的配置类
    //默认org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration生效，
    // 通过@Bean在IOC容器中放入了一个ConcurrentMapCacheManager(缓存管理器）它实现了CacheManage接口，接口中有一个名为getCache的方法
    //如果缓存为空，加锁再次获取，还是获取不到，就创建一个缓存
    //@Nullable
    //    public Cache getCache(String name) {
    //        Cache cache = (Cache)this.cacheMap.get(name);
    //        if (cache == null && this.dynamic) {
    //            synchronized(this.cacheMap) {
    //                cache = (Cache)this.cacheMap.get(name);
    //                if (cache == null) {
    //                    cache = this.createConcurrentMapCache(name);
    //                    this.cacheMap.put(name, cache);
    //                }
    //            }
    //        }
    //
    //        return cache;
    //    }
    @Override
    @Cacheable(cacheNames = "getemployee", key = "#id")
    // 将方法的执行结果进行缓存，以后有相同的数据，直接从缓存中获取
    //方法运行之前先去拿缓存
    public Employee getEmployeeById(Integer id) {
        System.out.println(employeeRedisTemplate);
        return employeeMapper.getEmployeeById(id);
    }

    //即调用方法，又更新缓存
    //修改了数据库的数据，同时又更新缓存
    //运行时机
    //1：先调用方法
    //2：将目标方法结果缓存
    @CachePut(cacheNames = "getemployee", key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee.getdId());
        return employee;
    }
}
