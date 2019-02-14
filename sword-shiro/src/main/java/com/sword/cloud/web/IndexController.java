package com.sword.cloud.web;

import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.service.interfaces.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index(Model model) {
        logger.debug("-------------index------------");
        List<Menu> menus = menuService.selectAll();
//        menus.sort(new Comparator<Menu>() {
//            @Override
//            public int compare(Menu o1, Menu o2) {
//                return o1.getSort()-o2.getSort();
//            }
//        });
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/home")
    public String toHome() {
        logger.debug("===111-------------home------------");
        return "home";
    }

    @RequestMapping("/login")
    public String toLogin() {
        logger.debug("===111-------------login------------");
        return "login";
    }

    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page) {
        logger.debug("-------------toindex------------" + page);
        return page;
    }
}
