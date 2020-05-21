package com.chj.base;

import static com.chj.status.Status.*;

/**
 * @author ：chj
 * @date ：Created in 2020/5/12 19:42
 * @params :
 */
public class BaseController {


    /** 方法描述
     * @Description: 自定义成功
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customSuccess(String code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
    /** 方法描述
     * @Description: 自定义成功  自定义详情
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customSuccess(String code,String msg,String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 自定义成功  自定义详情、自定义数据
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customSuccess(String code,String msg,String detail,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }



    /** 方法描述
     * @Description: 自定义失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customFailed(String code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
    /** 方法描述
     * @Description: 自定义失败  自定义详情
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customFailed(String code,String msg,String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 自定义失败  自定义详情、自定义数据
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData customFailed(String code,String msg,String detail,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }







    /** 方法描述 
    * @Description: 登录成功
    * @Param: []
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }
    /** 方法描述
    * @Description: 登录成功 自定义详情
    * @Param: [detail]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected ResultData loginSuccess(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述 
    * @Description: 登录成功 自定义数据
    * @Param: [data]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述 
    * @Description: 登录成功 自定义详情、数据
    * @Param: [detail, data]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/12
    */
    protected ResultData loginSuccess(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }


    /** 方法描述
     * @Description: 删除成功
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 删除成功 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteSuccess(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 删除成功 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 删除成功 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteSuccess(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }




    /** 方法描述
     * @Description: 新增成功
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 新增成功 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertSuccess(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 新增成功 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 新增成功 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertSuccess(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }




    /** 方法描述
     * @Description: 修改成功
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 修改成功 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateSuccess(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 修改成功 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 修改成功 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateSuccess(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }




    /** 方法描述
     * @Description: 查询成功
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 查询成功 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectSuccess(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 查询成功 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 查询成功 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectSuccess(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }





    /** 方法描述
     * @Description: 登录失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 登录失败 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 登录失败 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 登录失败 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginFailed(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }




    /** 方法描述
     * @Description: 用户不存在
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 用户不存在 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userExist(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 用户不存在 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userExist(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 用户不存在 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userExist(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }





    /** 方法描述
     * @Description: 密码错误
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 密码错误 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData passwordWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 密码错误 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData passwordWrong(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 密码错误 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData passwordWrong(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }







    /** 方法描述
     * @Description: 账号被锁定
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userLocked(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 账号被锁定 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userLocked(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 账号被锁定 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userLocked(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 账号被锁定 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData userLocked(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }







    /** 方法描述
     * @Description: 用户异常退出
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 用户异常退出 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 用户异常退出 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginWrong(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 用户异常退出 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData loginWrong(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }







    /** 方法描述
     * @Description: 删除失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 删除失败 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 删除失败 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 删除失败 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData deleteFailed(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }







    /** 方法描述
     * @Description: 新增失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 新增失败 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 新增失败 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 新增失败 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData insertFailed(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }






    /** 方法描述
     * @Description: 修改失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 修改失败 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 修改失败 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 修改失败 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData updateFailed(String detail, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }





    /** 方法描述
     * @Description: 查询失败
     * @Param: []
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }
    /** 方法描述
     * @Description: 查询失败 自定义详情
     * @Param: [detail]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /** 方法描述
     * @Description: 查询失败 自定义数据
     * @Param: [data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /** 方法描述
     * @Description: 查询失败 自定义详情、数据
     * @Param: [detail, data]
     * @return: com.chj.base.ResultData
     * @Author: chj
     * @Date: 2020/5/12
     */
    protected ResultData selectFailed(String detail, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }
}
