package com.sword.cloud.pojo.entity;

import com.sword.cloud.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class MemberInfo extends BaseEntity {
    private Long id;

    private String memberName;

    private String account;

    private String openId;

    private String unionId;

    private String nickName;

    private String email;

    private Integer gender;

    private Date birthday;

    private Long channelId;

    private Long registerStoreId;

    private Integer enable;

    private String mobile;

    private String hobby;

    private Integer totalScore;

}