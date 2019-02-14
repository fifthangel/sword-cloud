package com.sword.cloud.dao;

import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.RolePermissionDto;
import com.sword.cloud.pojo.entity.RolePermission;
import com.sword.cloud.pojo.view.RolePermissionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends IBaseDao<Long, RolePermission, RolePermissionDto, RolePermissionView> {

	List<RolePermission> findByRole(int roleId);
}