package com.sword.cloud.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 *@description:实体类基类
 *
 *@author Sjh
 *@date 2019/1/9 18:55
 *@version 1.0.1
 */
@Getter
@Setter
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class BaseEntity implements Serializable {

    private int pageNum;
    private int pageSize;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    private String createUserName;//创建人姓名
    private Long createUserId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private String updateUserName;
    private Long updateUserId;
    private String dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}
