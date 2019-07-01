package com.sword.cloud.pojo.entity;


import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


@Data
@Accessors(chain = true)
public class UserRoles extends BaseEntity {

	private static final long serialVersionUID = -3991564810576131883L;

	private Integer id;

	private String username;

	private String mobile;

	private String email;

	private String password;

	private Integer insertUid;


	private boolean isDel;

	private boolean isJob;

	private List<UserRole> userRoles;

	private Integer version;


}