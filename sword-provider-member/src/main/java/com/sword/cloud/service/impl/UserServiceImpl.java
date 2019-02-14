package com.sword.cloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sword.cloud.dao.RoleMapper;
import com.sword.cloud.dao.UserMapper;
import com.sword.cloud.dao.UserRoleMapper;
import com.sword.cloud.pojo.dto.UserDto;
import com.sword.cloud.pojo.dto.UserRoleDto;
import com.sword.cloud.pojo.dto.UserSearchDto;
import com.sword.cloud.pojo.entity.Role;
import com.sword.cloud.pojo.entity.User;
import com.sword.cloud.pojo.entity.UserRole;
import com.sword.cloud.pojo.view.UserRolesView;
import com.sword.cloud.service.UserService;

import com.sword.cloud.utils.DateUtil;
import com.sword.cloud.utils.PageDataResult;
import com.sword.cloud.utils.SendMsgServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class UserServiceImpl implements UserService {


}
