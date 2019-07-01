package com.sword.cloud.fallback;


import com.github.pagehelper.PageInfo;
import com.sword.cloud.pojo.entity.MemberInfo;
import com.sword.cloud.service.IMemberInfoService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@description: 熔断降级
 *
 *@author Sjh
 *@date 2019/1/12 13:11
 *@version 1.0.1
 */

@Component // 不要忘记添加，不要忘记添加
public class MemberInfoServiceFallbackFactory implements FallbackFactory<IMemberInfoService> {
    @Override
    public IMemberInfoService create(Throwable throwable) {
        return new IMemberInfoService() {

            @Override
            public boolean add(MemberInfo dept) {
                return false;
            }

            @Override
            public MemberInfo get(Long id){
                return new MemberInfo().setId(id).setMemberName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
            }

            @Override
            public List<MemberInfo> list() {
                return null;
            }

            @Override
            public Integer del(MemberInfo dept) {
                return null;
            }

            @Override
            public PageInfo<MemberInfo> findAll(int pageNum, int pageSize) {
                return new PageInfo<MemberInfo>();
            }
        };
    }
}
