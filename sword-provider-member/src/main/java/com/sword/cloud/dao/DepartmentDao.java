package com.sword.cloud.dao;

import com.sword.cloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface DepartmentDao
{

	public boolean addDept(Department dept);

	//ehcache缓存--cacheName不用"redis"开头 (ehcache.xml需要配置)
	@Cacheable(cacheNames="sword-department", key="'department' + #dept.id", unless="#result==null")
	public Department findById(Long id);

	//redis缓存
	@Cacheable(cacheNames="redis-sword-department", key="'department' + #dept.id", unless="#result==null")
	public List<Department> findAll();
}
