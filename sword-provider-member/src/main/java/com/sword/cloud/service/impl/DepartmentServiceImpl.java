package com.sword.cloud.service.impl;

import com.sword.cloud.dao.DepartmentDao;
import com.sword.cloud.entities.Department;
import com.sword.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentDao dao;
	
	@Override
	public boolean add(Department dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Department get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Department> list()
	{
		return dao.findAll();
	}

}
