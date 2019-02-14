package com.sword.cloud.controller;


import com.sword.cloud.fallback.UserServiceFallbackFactory;
import com.sword.cloud.pojo.entity.User;
import com.sword.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@description:用户
 *
 *@author Sjh
 *@date 2019/2/12 17:42
 *@version 1.0.1
 */
@RestController
//当前接口的hystrix 熔断注解，每个接口建立不同的 xxxxServiceFallbackFactory
@FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = UserServiceFallbackFactory.class)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/getByName", method = RequestMethod.POST)
    public User getByName(@RequestParam(name = "name") String userName) {
        return new User().setPassword("123456");
    }


}
