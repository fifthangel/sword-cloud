package com.sword.cloud.dao;

import com.sword.cloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface DepartmentDao extends  BaseDao<Department>
{

}
