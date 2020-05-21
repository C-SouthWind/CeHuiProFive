package com.chj.controller.manage;

import com.chj.base.BaseService;
import com.chj.base.CommonController;
import com.chj.model.manage.Dept;
import com.chj.service.manage.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chj
 * @date ：Created in 2020/5/21 18:32
 * @params :
 */
@RestController
public class DeptController extends CommonController<Dept> {
    @Autowired
    private DeptService deptService;

    protected BaseService<Dept> getBaseService() {
        return deptService;
    }
}
