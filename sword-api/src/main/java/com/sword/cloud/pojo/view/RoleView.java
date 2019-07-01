package com.sword.cloud.pojo.view;


import com.sword.cloud.base.BaseView;
import com.sword.cloud.pojo.entity.RolePermission;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class RoleView  extends BaseView implements Serializable {

	private static final long serialVersionUID = -2783081162690878303L;
	private Integer id;

	private String roleName;

	private String descpt;

	private String code;

	private Integer insertUid;

	private String insertTime;

	//角色下的权限ids
	private List<RolePermission> rolePerms;

}
