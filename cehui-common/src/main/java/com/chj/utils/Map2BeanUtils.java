package com.chj.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：chj
 * @date ：Created in 2020/5/12 18:22
 * @params : map和bean之间的转换
 */
public class Map2BeanUtils {

    private Map2BeanUtils(){

    }

    //使用高性能java实例化工具
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    //StringBuffer线程安全
    private final static StringBuffer STRING_BUFFER = new StringBuffer();
    //使用Map集合作为本地缓存池
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP = new ConcurrentHashMap<Class, MethodAccess>();
    
    /** 方法描述 
    * @Description: 把map转为bean对象
    * @Param: [map, clazz]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/12
    */
    public static <T> T map2Bean(Map<String,Object> map , Class<T> clazz){
        //获取泛型对象
        T instance = OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        if (null == methodAccess) {
            //MethodAccess.get(xx)      为指定的类型创建新的方法访问。
             methodAccess = MethodAccess.get(clazz);
             CONCURRENT_HASH_MAP.putIfAbsent(clazz,methodAccess);
        }
       for(Map.Entry<String,Object> entry: map.entrySet()){
           String setMethodName = setMethodName(entry.getKey());
           //MethodAccess.getIndex(xx) 返回具有指定名称的第一个方法的索引。
           int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
           // methodAccess.invoke(类，索引，值)   使用指定的名称和指定的参数数量调用第一个方法。
           methodAccess.invoke(instance,index,entry.getValue());
       }
       return instance;
    }
    /** 方法描述 
    * @Description: 把字段拼接成set方法
    * @Param: [fieldName]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/12
    */
    private static String setMethodName(String fieldName){
       return STRING_BUFFER.append("set").append( firstToUpperCase(fieldName)).toString();
    }
    
    /** 方法描述 
    * @Description: 把字段首字母转大写
     *             substring(x,x)保留x-x之间的
     *             substring（x） 保留x之后的
    * @Param: [field]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/12
    */
    private static String firstToUpperCase(String field){
        return field.substring(0,1).toUpperCase() + field.substring(1);
    }

}

