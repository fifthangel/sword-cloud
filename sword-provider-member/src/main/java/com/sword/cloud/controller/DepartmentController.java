package com.sword.cloud.controller;

import com.github.pagehelper.PageInfo;
import com.sword.cloud.entities.Department;
import com.sword.cloud.fallback.DepartmentServiceFallbackFactory;
import com.sword.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@description:hystrix 熔断降级
 *
 *@author Sjh
 *@date 2019/1/12 13:18
 *@version 1.0.1
 */

@RestController
//当前接口的hystrix 熔断注解，每个接口建立不同的 xxxxServiceFallbackFactory
@FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = DepartmentServiceFallbackFactory.class)
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department dept) {
        return service.add(dept);
    }


    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //	@HystrixCommand(fallbackMethod = "processHystrix_Get")
    //一个个写太麻烦，用下面类注解
    // @FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = DepartmentServiceFallbackFactory.class)//hystrix 熔断注解
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Department> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/pageList", method = RequestMethod.GET)
    public PageInfo<Department> pageList(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                                 int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                                 int pageSize) {
        return service.findAll(pageNum, pageSize);
    }


    //	@Autowired
    //	private DiscoveryClient client;
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("SWORD-PROVIDER-MEMBER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }



}
