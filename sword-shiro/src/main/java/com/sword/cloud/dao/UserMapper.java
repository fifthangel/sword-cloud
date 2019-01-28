package com.sword.cloud.dao;

import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.UserDto;
import com.sword.cloud.pojo.dto.UserRoleDto;
import com.sword.cloud.pojo.dto.UserSearchDto;
import com.sword.cloud.pojo.entity.User;
import com.sword.cloud.pojo.view.UserRolesView;
import com.sword.cloud.pojo.view.UserView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface UserMapper extends IBaseDao<Long, User, UserDto, UserView> {


	/**
	 * 分页查询用户数据
	 * @return
	 */
	List<UserRoleDto> getUsers(@Param("userSearch") UserSearchDto userSearch);

	/**
	 * 删除用户
	 * @param id
	 * @param isDel
	 * @return
	 */
	int setDelUser(@Param("id") Integer id, @Param("isDel") Integer isDel,
                   @Param("insertUid") Integer insertUid);

	/**
	 * 设置用户是否离职
	 * @param id
	 * @param isJob
	 * @return
	 */
	int setJobUser(@Param("id") Integer id, @Param("isJob") Integer isJob,
                   @Param("insertUid") Integer insertUid);

	/**
	 * 查询用户及对应的角色
	 * @param id
	 * @return
	 */
	UserRolesView getUserAndRoles(Integer id);

	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(@Param("username") String username,
									 @Param("password") String password);

	/**
	 *	根据手机号获取用户数据
	 * @param mobile
	 * @return
	 */
	User findUserByMobile(String mobile);

	/**
	 * 根据用户名获取用户数据
	 * @param username
	 * @return
	 */
	 User findUserByName(String username);

	/**
	 * 修改用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	int updatePwd(@Param("id") Integer id, @Param("password") String password);

	/**
	 * 是否锁定用户
	 * @param id
	 * @param isLock
	 * @return
	 */
	int setUserLockNum(@Param("id") Integer id, @Param("isLock") int isLock);

	User selectByPrimaryKey(Integer id);
}