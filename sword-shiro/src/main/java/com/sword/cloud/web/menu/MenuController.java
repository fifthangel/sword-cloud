package com.sword.cloud.web.menu;

import com.sword.cloud.pojo.dto.UserSearchDto;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.service.interfaces.AuthService;
import com.sword.cloud.service.interfaces.MenuService;
import com.sword.cloud.utils.PageDataResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

    //private static final Pattern MOBILE_PATTERN = Pattern.compile("^1\\d{10}$");

    @RequestMapping("/pageList")
    public String toUserList() {
        return "/menu/pageList";
    }

    @RequestMapping("/list")
    public String toList() {
        return "/menu/list";
    }

    /**
     * 分页查询用户列表
     * @return ok/fail
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getPageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        logger.debug("分页查询用户列表！搜索条件：userSearch：" + pageNum + ",page:" + pageSize);

        Menu menu = new Menu();
        menu.setStartIndex(pageNum == null ? 1 : pageNum).setPageSize(pageSize == null ? 10 : pageSize);

        try {

            // 获取用户和角色列表
            PageDataResult pageDataResult = menuService.pageList(menu);
            logger.debug("用户列表查询=pdr:" + pageDataResult);
            return pageDataResult;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return null;
    }

    /**
     * 分页查询用户列表
     * @return ok/fail
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Menu> getList() {

        logger.debug("分页查询用户列表！getList：");

        return menuService.selectAll();
    }


}
