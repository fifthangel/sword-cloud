package com.sword.cloud.entities;



import java.util.Date;


/**
 *@description:实体类基类
 *
 *@author Sjh
 *@date 2019/1/9 18:55
 *@version 1.0.1
 */

public class BaseEntity {

    private Long id;//pk id
    private Date createTime;//创建时间
    private String createUserName;//创建人姓名
    private Long createUserId;
    private Date updateTime;
    private String updateUserName;
    private Long updateUserId;
    private String dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

}
