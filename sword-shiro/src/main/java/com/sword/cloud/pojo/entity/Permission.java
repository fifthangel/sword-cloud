package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class Permission extends BaseEntity implements Serializable{
	private static final long serialVersionUID = -2783081162690878303L;

	private String id;

	private String name;

	private String pId;

	private String istype;

	private String code;

	private String page;

	private String icon;

	private String zindex;

	private boolean checked;

	private boolean open;

	private String descpt;

	private Date insertTime;

	private Date updateTime;

}