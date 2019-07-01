package com.sword.cloud.pojo.entity;


import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class UserRole extends BaseEntity {

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