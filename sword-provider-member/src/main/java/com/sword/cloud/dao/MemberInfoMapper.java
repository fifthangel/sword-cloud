package com.sword.cloud.dao;

import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.MemberInfoDto;
import com.sword.cloud.pojo.entity.MemberInfo;
import com.sword.cloud.pojo.view.MemberInfoView;

public interface MemberInfoMapper  extends IBaseDao<Long, MemberInfo, MemberInfoDto, MemberInfoView>  {

}