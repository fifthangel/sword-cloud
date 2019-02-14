package com.sword.cloud.pojo.dto;


import com.sword.cloud.base.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class UserRoleDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = -2783081162690878303L;

    private Integer id;

    private String username;

    private String mobile;

    private String email;

    private String password;

    private Integer insertUid;

    private String insertTime;

    private boolean isDel;

    private boolean isJob;

    private String roleNames;

    private Integer version;

}