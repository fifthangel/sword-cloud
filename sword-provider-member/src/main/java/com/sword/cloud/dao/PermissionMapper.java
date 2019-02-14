package com.sword.cloud.dao;


import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.PermissionDto;
import com.sword.cloud.pojo.entity.Permission;
import com.sword.cloud.pojo.view.PermissionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends IBaseDao<Long, Permission, PermissionDto, PermissionView> {

    List<Permission> findAll();


    Permission  selectByPrimaryKey(int id);
    /**
     * 查询权限树列表
     * @return
     */
    List<Permission> findPerms();


    /**
     * 根据角色id获取权限数据
     * @param roleId
     * @return
     */
    List<Permission> findPermsByRole(Integer roleId);

    List<Permission> getUserPerms(Integer userId);

    List<Permission> findChildPerm(int id);
}
