package com.sword.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *@description:部门类
 *
 *@author Sjh
 *@date 2019/1/9 19:01
 *@version 1.0.1
 */

@NoArgsConstructor //无参构造
@AllArgsConstructor//有参构造
@Data                //不用再写getter() setter() toString()
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class Department implements Serializable {

    private Long id;//pk id
    private String dname; // 部门名称
    private Date createTime;//创建时间
    private String createUserName;//创建人姓名
    private Long createUserId;
    private Date updateTime;
    private String updateUserName;
    private Long updateUserId;
    private String dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

}
