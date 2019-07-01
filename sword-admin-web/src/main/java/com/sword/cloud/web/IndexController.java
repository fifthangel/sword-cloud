package com.sword.cloud.web;

import com.sword.cloud.pojo.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {


    private static final String REST_URL_PREFIX = "http://SWORD-PROVIDER-MEMBER";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequiresUser
    @RequestMapping("/index")
    public String index(Model model) {
        log.debug("-------------index------------");
        List<Menu> menus = restTemplate.getForObject(REST_URL_PREFIX + "/menu/list", List.class);
//        menus.sort(new Comparator<Menu>() {
//            @Override
//            public int compare(Menu o1, Menu o2) {
//                return o1.getSort()-o2.getSort();
//            }
//        });
        model.addAttribute("menus", menus);
        return "index";
    }

}
