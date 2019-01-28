package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3096736268081409238L;
    private Integer id;

    private String username;

    private String mobile;

    private String email;

    private String password;

    private Integer insertUid;

    private Date insertTime;

    private Date updateTime;

    private Boolean isDel;

    private Boolean isJob;

    private String mcode;

    private Date sendTime;

    private Integer version;


}