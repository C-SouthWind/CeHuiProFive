package com.chj.base;



import com.chj.utils.NotEmpty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/12 19:41
 * @params :
 */
public abstract class CommonController<T> extends BaseController {


    /** 方法描述 
    * @Description: 钩子函数，在新增之前所执行的内容
    * @Param: [map]
    * @return: void
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected void beforeAdd(Map map){
        //TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }
    /** 方法描述 
    * @Description: 钩子函数，在新增之后所执行的内容
    * @Param: [map]
    * @return: void
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected void afterAdd(Map map) {
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }

    protected abstract BaseService<T> getBaseService();

    /** 方法描述 
    * @Description: 新增数据
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    @PostMapping("/add")
    public ResultData add(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer add = getBaseService().add(instance);
            if (add > 0) {
                afterAdd(map);
                return loginSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginFailed();
    }

    /** 方法描述 
    * @Description: 通过主键删除
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    @GetMapping("/delete")
    public ResultData delete(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        try {
            Integer delete = getBaseService().delete(instance);
            if (delete > 0) {
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }
    
    /** 方法描述 
    * @Description: 批量删除
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData batchDelete(@RequestBody Map map){
        //TODO
       return null;
    }

    @GetMapping("/selectAll")
    public ResultData selectAll(){
        List<T> ts = getBaseService().selectAll();
       return NotEmpty.listNotEmpty(ts) ? selectSuccess(ts) : selectFailed();
    }



    /** 方法描述 
    * @Description: 修改
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    @PostMapping("/update")
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        try {
            Integer update = getBaseService().update(instance);
            if (update > 0) {
                return updateSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFailed();
    }

    /** 方法描述 
    * @Description: 批量修改
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData batchUpdate(@RequestBody Map map){
        //TODO
        return null;
    }
    
    /** 方法描述 
    * @Description: 获取一条数据
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    @PostMapping("/selectOne")
    public ResultData selectOne(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        try {
            T t = getBaseService().queryOne(instance);
            if (null != t && "".equals(t)) {
                return selectFailed(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }

    /** 方法描述
    * @Description:  通过指定字段查询一条数据
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData queryByField(@RequestBody Map map){
        //TODO
        return null;
    }

    /** 方法描述
    * @Description: 条件查询集合
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData queryListByFields(@RequestBody Map map){
        //TODO
        return null;
    }

    /** 方法描述
    * @Description: 条件查询分页
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData queryListByPageAndFields(@RequestBody Map map){
        //TODO
        return null;
    }

    /** 方法描述
    * @Description: 条件查询
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    @PostMapping("/queryList")
    public ResultData queryList(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        try {
            List<T> ts = getBaseService().queryList(instance);
            if (ts.size()>0) {
                return selectSuccess(ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }

    /** 方法描述
    * @Description: 分页查询
    * @Param: [map]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    public ResultData queryListByPage(@RequestBody Map map){
        //TODO
        return null;
    }











    /** 方法描述
    * @Description: 防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     *               必须要从本地当前线程中获取对象
    * @Param: []
    * @return: javax.servlet.http.HttpServletRequest
    * @Author: chj
    * @Date: 2020/5/12
    */
    public HttpServletRequest getServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
    /** 方法描述 
    * @Description: 获取当前客户端的session对象(如果不存在，则会重新创建一个)
    * @Param: []
    * @return: javax.servlet.http.HttpSession
    * @Author: chj
    * @Date: 2020/5/12
    */
    public HttpSession getSession(){
        return getServletRequest().getSession();
    }
    /** 方法描述
    * @Description: 获取当前客户端的session对象(如果不存在，则直接返回为null)
    * @Param: []
    * @return: javax.servlet.http.HttpSession
    * @Author: chj
    * @Date: 2020/5/12
    */
    public HttpSession getExistSession(){
        return getServletRequest().getSession(false);
    }
}
