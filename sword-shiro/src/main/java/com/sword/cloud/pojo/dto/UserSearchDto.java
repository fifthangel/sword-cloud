package com.sword.cloud.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class UserSearchDto implements Serializable {
	private static final long serialVersionUID = -2783081162690878303L;


	private Integer page;

	private Integer limit;

	private String uname;

	private String umobile;

	private String insertTimeStart;

	private String insertTimeEnd;


}
