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
    @CachePut(value = CacheConstant.EHCACHE_A, key = "#dept.id")
    public boolean add(Department dept) {
        return departmentDao.addDept(dept);
    }

    @Override
    @Cacheable(value = CacheConstant.EHCACHE_A, key = "#id")
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
    @CacheEvict(value = CacheConstant.EHCACHE_A, key = "#dept.id")
    public Integer del(Department dept) {
        return departmentDao.delDept(dept);
    }

}
