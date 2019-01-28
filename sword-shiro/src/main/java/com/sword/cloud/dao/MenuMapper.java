package com.sword.cloud.dao;


import com.sword.cloud.base.interfaces.IBaseDao;
import com.sword.cloud.pojo.dto.MenuDto;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.pojo.view.MenuView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends IBaseDao<Long, Menu, MenuDto, MenuView> {


    /**
     *@description:查所有菜单
     *
     *@param
     *@author Sjh
     *@date 2019/1/25 16:52
     *@return
     *@version 1.0.1
     */
    public List<Menu> findAll();
}