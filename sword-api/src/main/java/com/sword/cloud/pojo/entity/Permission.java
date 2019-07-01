package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Permission extends BaseEntity {

    private static final long serialVersionUID = -2783081162690878303L;

}
