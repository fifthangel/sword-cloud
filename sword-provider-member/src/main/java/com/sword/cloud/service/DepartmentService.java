package com.sword.cloud.service;

import com.github.pagehelper.PageInfo;
import com.sword.cloud.entities.*;

import java.util.List;

public interface DepartmentService
{
	public boolean add(Department dept);

	public Department get(Long id);

	public List<Department> list();

	public  Integer del(Department dept);

	public PageInfo<Department> findAll(int pageNum, int pageSize);
}
