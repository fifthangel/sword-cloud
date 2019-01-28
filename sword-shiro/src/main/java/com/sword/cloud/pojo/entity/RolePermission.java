package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class RolePermission extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3096736268081409238L;

    private Integer permitId;

    private Integer roleId;

}