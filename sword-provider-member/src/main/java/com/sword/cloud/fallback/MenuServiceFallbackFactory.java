package com.sword.cloud.fallback;


import com.github.pagehelper.PageInfo;
import com.sword.cloud.pojo.dto.MenuDto;
import com.sword.cloud.pojo.entity.Department;
import com.sword.cloud.pojo.entity.Menu;
import com.sword.cloud.pojo.view.MenuView;
import com.sword.cloud.service.DepartmentService;
import com.sword.cloud.service.MenuService;
import com.sword.cloud.utils.PageDataResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@description: 熔断降级
 *
 *@author Sjh
 *@date 2019/1/12 13:11
 *@version 1.0.1
 */

@Component // 不要忘记添加，不要忘记添加
public class MenuServiceFallbackFactory implements FallbackFactory<MenuService> {

    @Override
    public MenuService create(Throwable throwable) {
        return new MenuService() {
            @Override
            public PageDataResult pageList(Menu entity) {
                return null;
            }

            @Override
            public List<Menu> selectAll() {
                return null;
            }

            @Override
            public Integer insertSelective(Menu entity) {
                return null;
            }

            @Override
            public Integer insertSelectiveByDto(MenuDto dto) {
                return null;
            }

            @Override
            public Integer insertGotEntityId(Menu entity) {
                return null;
            }

            @Override
            public Integer insertGotEntityIdByDto(MenuDto dto) {
                return null;
            }

            @Override
            public Integer batchInsert(List<Menu> list) {
                return null;
            }

            @Override
            public Integer batchInsertByDto(List<MenuDto> list) {
                return null;
            }

            @Override
            public Integer updateSelective(Menu entity) {
                return null;
            }

            @Override
            public Integer updateSelectiveByDto(MenuDto dto) {
                return null;
            }

            @Override
            public Integer batchUpdate(List<Menu> list) {
                return null;
            }

            @Override
            public Integer batchUpdateByDto(List<MenuDto> list) {
                return null;
            }

            @Override
            public Integer deleteById(Long id) {
                return null;
            }

            @Override
            public Integer deleteByEntity(Menu entity) {
                return null;
            }

            @Override
            public Integer deleteByDto(MenuDto dto) {
                return null;
            }

            @Override
            public Integer batchDelete(List<Long> list) {
                return null;
            }

            @Override
            public Integer deleteFromTable(MenuDto dto) {
                return null;
            }

            @Override
            public Menu find(Long id) {
                return null;
            }

            @Override
            public MenuView findById(Long id) {
                return null;
            }

            @Override
            public Menu findByType(Menu entity) {
                return null;
            }

            @Override
            public Menu findEntityByDto(MenuDto dto) {
                return null;
            }

            @Override
            public MenuView findViewByEntity(Menu entity) {
                return null;
            }

            @Override
            public MenuView findViewByDto(MenuDto dto) {
                return null;
            }

            @Override
            public List<Menu> findList(Menu entity) {
                return null;
            }

            @Override
            public List<Menu> findListByDto(MenuDto dto) {
                return null;
            }

            @Override
            public List<Menu> findListByForeignKey(Long id) {
                return null;
            }

            @Override
            public List<MenuView> findViewListByEntity(Menu entity) {
                return null;
            }

            @Override
            public List<MenuView> findViewListByDto(MenuDto dto) {
                return null;
            }

            @Override
            public int count(Menu entity) {
                return 0;
            }

            @Override
            public List<Menu> like(Menu entity) {
                return null;
            }

            @Override
            public Integer selectMaxId() {
                return null;
            }
        };
    }
}
