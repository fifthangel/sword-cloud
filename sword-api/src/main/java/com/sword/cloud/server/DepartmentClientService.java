package com.sword.cloud.server;


import com.sword.cloud.pojo.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *@description: 修改api工程，根据已经有的DeptClientService接口
 *
 * 新建
 *
 * 一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 *
 *@author Sjh
 *@date 2019/1/12 13:03
 *@version 1.0.1
 */
@FeignClient(value = "SWORD-PROVIDER-MEMBER",fallbackFactory=DepartmentClientServiceFallbackFactory.class)
public interface DepartmentClientService
{
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Department get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Department> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Department dept);
}
