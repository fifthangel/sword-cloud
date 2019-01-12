package com.sword.cloud.dao;

import com.sword.cloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao
{
	public boolean addDept(Department dept);

	public Department findById(Long id);

	public List<Department> findAll();
}
