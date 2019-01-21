package com.sword.cloud.service.impl;

import com.sword.cloud.CacheExpire;
import com.sword.cloud.constant.CacheConstant;
import com.sword.cloud.dao.DepartmentDao;
import com.sword.cloud.entities.Department;
import com.sword.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    //CachePut在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    @CachePut(value = CacheConstant.EHCACHE_A, key = "#dept.id")//
    public boolean add(Department dept) {
        return departmentDao.add(dept)>0;
    }

    @Override
    //Cacheable检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行方法并将返回结果存入指定的缓存中。
    @Cacheable(value = CacheConstant.EHCACHE_A, key = "#id")//缓存
    @CacheExpire(expire = 60)//失效时间
    public Department get(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    @Cacheable(value = CacheConstant.REDIS_A, key = "'dept-list'",unless = "#result == null or #result.empty")
    @CacheExpire(expire = 60)
    public List<Department> list() {
        return departmentDao.findAll();
    }

    @Override
    //CacheEvict清除缓存元素
    //allEntries 忽略指定的key,清除所有的元素
    //beforeInvocation 改变触发清除操作的时间， 该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
//    @CacheEvict(value = CacheConstant.EHCACHE_A, key = "#dept.id", allEntries=true, beforeInvocation=true)
    public Integer del(Department dept) {
        return departmentDao.del(dept);
    }

}
