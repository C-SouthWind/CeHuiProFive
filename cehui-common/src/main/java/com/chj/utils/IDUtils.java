package com.chj.utils;

import java.util.UUID;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:53
 * @params :
 */
public class IDUtils {

    private IDUtils(){}

    /** 方法描述
    * @Description: 获取uuid
    * @Param: []
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/15
    */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
