package com.sword.cloud.server;

import com.sword.cloud.pojo.entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@description:服务降级熔断
 *
 *@author Sjh
 *@date 2019/1/12 13:21
 *@version 1.0.1
 */

@Component // 不要忘记添加，不要忘记添加
public class DepartmentClientServiceFallbackFactory implements FallbackFactory<DepartmentClientService> {
    @Override
    public DepartmentClientService create(Throwable throwable) {
        return new DepartmentClientService() {
            @Override
            public Department get(long id) {
                Department department = new Department().setId(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");

                return department;
            }

            @Override
            public List<Department> list() {
                return null;
            }

            @Override
            public boolean add(Department dept) {
                return false;
            }
        };
    }
}
