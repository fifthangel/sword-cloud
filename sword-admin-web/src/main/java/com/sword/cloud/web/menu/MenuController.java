package com.sword.cloud.web.menu;

import com.sword.cloud.pojo.entity.Menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 分页查询用户列表
     * @return ok/fail
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Menu> getList() {

        log.debug("分页查询用户列表！getList：");

        return restTemplate.getForObject(REST_URL_PREFIX + "/menu/list", List.class);
    }




}
