package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3096736268081409238L;
    private Integer id;

    private String roleName;

    private String descpt;

    private String code;

    private Integer insertUid;

    private Date insertTime;

    private Date updateTime;


}