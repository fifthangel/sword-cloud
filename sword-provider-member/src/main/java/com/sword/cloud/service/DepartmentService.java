package com.sword.cloud.service;

import com.sword.cloud.entities.*;

import java.util.List;

public interface DepartmentService
{
	public boolean add(Department dept);

	public Department get(Long id);

	public List<Department> list();
}
