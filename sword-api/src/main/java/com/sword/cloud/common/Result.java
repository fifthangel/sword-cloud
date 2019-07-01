package com.sword.cloud.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *@description:公共返回类
 *
 *@author Sjh
 *@date 2019/1/22 16:58
 *@version 1.0.1
 */
    
@Data
@Accessors(chain = true) //链式操作 .set().set().set().....,可以一直打点调用
public class Result<T> {
    private com.sword.cloud.common.ResultCodeEnum code;
    private String message;
    private  T data;
}
