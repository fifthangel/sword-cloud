package com.sword.cloud.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用 【子类与父类需分别用自己类的属性的调用链】
public class Department extends BaseEntity  implements Serializable {

    private Long id;//pk id
    private String dname;//pk id

}
