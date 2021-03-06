package com.sword.cloud.controller;

import com.github.pagehelper.PageInfo;
import com.sword.cloud.fallback.MemberInfoServiceFallbackFactory;
import com.sword.cloud.pojo.entity.MemberInfo;
import com.sword.cloud.service.IMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@description:hystrix 熔断降级
 *
 *
 *
 *@author Sjh
 *@date 2019/1/12 13:18
 *@version 1.0.1
 */

@RestController
//当前接口的hystrix 熔断注解，每个接口建立不同的 xxxxServiceFallbackFactory
@FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = MemberInfoServiceFallbackFactory.class)
public class MemberController {

    @Autowired
    private IMemberInfoService memberInfoService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/memberInfo/add", method = RequestMethod.POST)
    public boolean add(@RequestBody MemberInfo memberInfo) {
        return memberInfoService.add(memberInfo);
    }


    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //	@HystrixCommand(fallbackMethod = "processHystrix_Get")
    //一个个写太麻烦，用下面类注解
    // @FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = MemberInfoServiceFallbackFactory.class)//hystrix 熔断注解
    @RequestMapping(value = "/memberInfo/get/{id}", method = RequestMethod.GET)
    public MemberInfo get(@PathVariable("id") Long id) {
        return memberInfoService.get(id);
    }

    @RequestMapping(value = "/memberInfo/list", method = RequestMethod.GET)
    public List<MemberInfo> list() {
        return memberInfoService.list();
    }

    @RequestMapping(value = "/memberInfo/pageList", method = RequestMethod.GET)
    public PageInfo<MemberInfo> pageList(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                                 int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                                 int pageSize) {
        return memberInfoService.findAll(pageNum, pageSize);
    }


    //	@Autowired
    //	private DiscoveryClient client;
    @RequestMapping(value = "/memberInfo/discovery", method = RequestMethod.GET)
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
