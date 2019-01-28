package com.sword.cloud.service.interfaces;

import com.sword.cloud.base.interfaces.IBaseService;
import com.sword.cloud.pojo.dto.MenuDto;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.pojo.view.MenuView;
import com.sword.cloud.utils.PageDataResult;

import java.util.List;

/**
 *@description:
 *
 *@author Sjh
 *@date 2019/1/25 16:43
 *@version 1.0.1
 */
    
public interface MenuService extends IBaseService<Long , Menu, MenuDto, MenuView> {
    public PageDataResult pageList(Menu entity);

    public List<Menu> selectAll();
}
