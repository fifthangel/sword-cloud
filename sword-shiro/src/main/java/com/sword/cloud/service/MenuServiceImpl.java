package com.sword.cloud.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sword.cloud.CacheExpire;
import com.sword.cloud.base.BaseServiceImpl;
import com.sword.cloud.constant.CacheConstant;
import com.sword.cloud.dao.MenuMapper;
import com.sword.cloud.pojo.dto.MenuDto;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.pojo.view.MenuView;
import com.sword.cloud.service.interfaces.MenuService;
import com.sword.cloud.utils.PageDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl extends BaseServiceImpl<Long, Menu, MenuDto, MenuView> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public PageDataResult pageList(Menu entity) {
        PageDataResult result = new PageDataResult();
        PageHelper.startPage(entity.getStartIndex(), entity.getPageSize());
        List<Menu> urList = menuMapper.findList(entity);
        // 获取分页查询后的数据
        PageInfo<Menu> pageInfo = new PageInfo<>(urList);
        // 设置获取到的总记录数total：
        result.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
        return result;
    }

    @Override
    @Cacheable(value = CacheConstant.REDIS_Menu, key = "'menu-list'",unless = "#result == null")
    @CacheExpire(expire = 60)
    public List<Menu> selectAll() {
        return menuMapper.findAll();
    }

}
