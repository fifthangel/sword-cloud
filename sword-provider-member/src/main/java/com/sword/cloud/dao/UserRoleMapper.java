package com.sword.cloud.dao;


import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.UserRoleDto;
import com.sword.cloud.pojo.entity.UserRole;
import com.sword.cloud.pojo.view.UserRoleView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper extends IBaseDao<Long, UserRole, UserRoleDto, UserRoleView> {

    int deleteByPrimaryKey(UserRole entity);

    int insert(UserRole entity);

	/**
	 * 根据用户获取用户角色中间表数据
	 * @param userId
	 * @return
	 */
	List<UserRole> findByUserId(int userId);
}