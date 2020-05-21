package com.chj.status;

/**
 * @author ：chj
 * @date ：Created in 2020/5/12 19:44
 * @params :
 */
public enum  Status {

    LOGIN_SUCCESS("20001","登录成功"),
    DELETE_SUCCESS("20002","删除成功"),
    INSERT_SUCCESS("20003","新增成功"),
    UPDATE_SUCCESS("20004","修改成功"),
    SELECT_SUCCESS("20005","查询成功"),

    LOGIN_FAILED("10001","登录失败"),
    USER_EXIST("10002","用户不存在"),
    PASSWORD_WRONG("10003","密码错误"),
    USER_LOCKED("10004","账号被锁定"),
    LOGOUT_WRONG("10005","用户异常退出"),
    DELETE_FAILED("10006","删除失败"),
    INSERT_FAILED("10007","新增失败"),
    UPDATE_FAILED("10008","修改失败"),
    SELECT_FAILED("10009","查询失败");


    Status(String code,String msg){
        this.code = code;
        this.msg = msg;
    }


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
