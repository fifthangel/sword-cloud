package com.sword.cloud.dao;

import com.sword.cloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface DepartmentDao
{

	public boolean addDept(Department dept);

	public Department findById(Long id);

	public List<Department> findAll();

	public Integer delDept(Department dept);
}
