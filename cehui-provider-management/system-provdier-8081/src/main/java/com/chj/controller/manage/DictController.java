package com.chj.controller.manage;



import com.chj.base.BaseService;
import com.chj.base.CommonController;
import com.chj.model.manage.Dict;
import com.chj.service.manage.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：chj
 * @date ：Created in 2020/5/21 16:14
 * @params :
 */
@RestController
public class DictController extends CommonController<Dict>{

    @Autowired
    private DictService dictService;

    protected BaseService getBaseService() {
        return dictService;
    }
}
