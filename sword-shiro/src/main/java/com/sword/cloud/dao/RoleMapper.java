package com.sword.cloud.dao;


import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.RoleDto;
import com.sword.cloud.pojo.entity.Role;
import com.sword.cloud.pojo.view.RoleView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends IBaseDao<Long, Role, RoleDto, RoleView> {


	/**
	 * 获取角色相关的数据
	 * @param id
	 * @return
	 */
	RoleView findRoleAndPerms(Integer id);

	/**
	 * 根据用户id获取角色数据
	 * @param userId
	 * @return
	 */
	List<Role> getRoleByUserId(Integer userId);

	List<Role> getRoles();

    List<Role> findAll();
}