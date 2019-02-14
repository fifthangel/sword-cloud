package com.sword.cloud.controller;

import com.sword.cloud.fallback.MenuServiceFallbackFactory;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.service.MenuService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//当前接口的hystrix 熔断注解，每个接口建立不同的 xxxxServiceFallbackFactory
@FeignClient(value = "SWORD-PROVIDER-MEMBER", fallbackFactory = MenuServiceFallbackFactory.class)
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
    public List<Menu> list() {
        return menuService.selectAll();
    }

}
