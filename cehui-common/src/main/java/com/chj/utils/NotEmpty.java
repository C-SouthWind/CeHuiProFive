package com.chj.utils;

import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/21 15:57
 * @params :  非空反true
 */
public class NotEmpty {
    private NotEmpty(){}

    public static Boolean stringNotEmpty(String s){
      return   null != s && !"".equals(s)? true : false;
    }

    public static Boolean listNotEmpty(List<?> list){
        return  list.size()>0 && null != list ? true : false;
    }

    public static Boolean mapNotEmpty(Map<?,?> map){
        return map.size()>0 && null != map ? true : false;
    }

    public static Boolean objectNotEmpty(Object o){
        return null != o && !"".equals(o) ? true : false;
    }

    public static Boolean integerNotEmpty(Integer integer){
        return integer > 0 && null != integer ? true : false;
    }
}
