package com.chj.controller.manage;

import com.chj.base.BaseService;
import com.chj.base.CommonController;
import com.chj.model.manage.Menu;
import com.chj.service.manage.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：chj
 * @date ：Created in 2020/5/21 18:34
 * @params :
 */
public class MenuController extends CommonController<Menu> {
    @Autowired
    private MenuService menuService;

    protected BaseService<Menu> getBaseService() {
        return menuService;
    }
}
