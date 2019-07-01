package com.sword.cloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sword.cloud.CacheExpire;
import com.sword.cloud.base.BaseServiceImpl;
import com.sword.cloud.constant.CacheConstant;
import com.sword.cloud.dao.MemberInfoMapper;
import com.sword.cloud.pojo.dto.MemberInfoDto;
import com.sword.cloud.pojo.entity.MemberInfo;
import com.sword.cloud.pojo.view.MemberInfoView;
import com.sword.cloud.service.IMemberInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Service
public class MemberInfoServiceImpl extends BaseServiceImpl<Long, MemberInfo, MemberInfoDto, MemberInfoView> implements IMemberInfoService  {

    @Resource
    private MemberInfoMapper memberInfoMapper;

    @Override
    //CachePut在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    @CachePut(value = CacheConstant.EHCACHE_A, key = "#memberInfo.id")//
    public boolean add(MemberInfo memberInfo) {
        return memberInfoMapper.insertSelective(memberInfo)>0;
    }

    @Override
    //Cacheable检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行方法并将返回结果存入指定的缓存中。
    @Cacheable(value = CacheConstant.EHCACHE_A, key = "#id")//缓存
    @CacheExpire(expire = 60)//失效时间
    public MemberInfo get(Long id) {
        return memberInfoMapper.find(id);
    }

    @Override
    @Cacheable(value = CacheConstant.REDIS_A, key = "'memberInfo-list'",unless = "#result == null or #result.empty")
    @CacheExpire(expire = 60)
    public List<MemberInfo> list() {
        return memberInfoMapper.findList(new MemberInfo());
    }

    @Override
    //CacheEvict清除缓存元素
    //allEntries 忽略指定的key,清除所有的元素
    //beforeInvocation 改变触发清除操作的时间， 该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
//    @CacheEvict(value = CacheConstant.EHCACHE_A, key = "#memberInfo.id", allEntries=true, beforeInvocation=true)
    public Integer del(MemberInfo memberInfo) {

        return memberInfoMapper.deleteByEntity(memberInfo);
    }

    @Override
    @Cacheable(value = CacheConstant.REDIS_A, key = "'memberInfo-page-list'",unless = "#result == null")
    @CacheExpire(expire = 60)
    public PageInfo<MemberInfo> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<MemberInfo> list = memberInfoMapper.findList(new MemberInfo());
        PageInfo<MemberInfo> result = new PageInfo<MemberInfo>(list);
        return result;
    }

}
