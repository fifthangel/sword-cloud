package com.sword.cloud.service;

import com.github.pagehelper.PageInfo;
import com.sword.cloud.base.interfaces.IBaseService;
import com.sword.cloud.pojo.dto.MemberInfoDto;
import com.sword.cloud.pojo.entity.MemberInfo;
import com.sword.cloud.pojo.view.MemberInfoView;

import java.util.List;


/**
 *@description:
 *
 *@author Sjh
 *@date 2019/6/29 14:42
 *@version 1.0.1
 */
    
public interface IMemberInfoService  {

    public boolean add(MemberInfo dept);

    public MemberInfo get(Long id);

    public List<MemberInfo> list();

    public  Integer del(MemberInfo dept);

    public PageInfo<MemberInfo> findAll(int pageNum, int pageSize);
}
