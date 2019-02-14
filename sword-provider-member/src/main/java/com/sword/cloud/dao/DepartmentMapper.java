package com.sword.cloud.dao;

import com.sword.cloud.base.BaseDto;
import com.sword.cloud.base.BaseView;
import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends IBaseDao<Long, Department,BaseDto, BaseView>
{

}
