package com.sword.cloud.fallback;


import com.sword.cloud.entities.Department;
import com.sword.cloud.service.DepartmentService;
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
public class DepartmentServiceFallbackFactory implements FallbackFactory<DepartmentService> {
    @Override
    public DepartmentService create(Throwable throwable) {
        return new DepartmentService() {

            @Override
            public boolean add(Department dept) {
                return false;
            }

            @Override
            public Department get(Long id){
                return new Department().setId(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDbSource("no this database in MySQL");
            }

            @Override
            public List<Department> list() {
                return null;
            }
        };
    }
}
