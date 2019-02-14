package com.sword.cloud.pojo.dto;

import com.sword.cloud.base.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class MenuDto extends BaseDto implements Serializable {
	private static final long serialVersionUID = -2783081162690878303L;

    /** */
    private Long id;

    /** 客户id*/
    private Long cid;

    /** 创建时间*/
    private Date createTime;

    /** 创建人id*/
    private Long createUserId;

    /** 创建人姓名*/
    private String createUserName;

    /** 更新时间*/
    private Date updateTime;

    /** 更新人id*/
    private Long updateUserId;

    /** 更新者姓名*/
    private String updateUserName;

    /** 删除标记: 0删除|1未删除*/
    private Integer deleteFlag;

    /** 菜单名称*/
    private String name;

    /** url*/
    private String url;

    /** 上一级id*/
    private Long parentid;

    /** 排序号*/
    private Integer sort;

    /** 是否启用 0停用 1启用*/
    private Boolean enable;


}