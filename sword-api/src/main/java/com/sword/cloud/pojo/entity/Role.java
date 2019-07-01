package com.sword.cloud.pojo.entity;


import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Role extends BaseEntity {

    private Long id;
}
