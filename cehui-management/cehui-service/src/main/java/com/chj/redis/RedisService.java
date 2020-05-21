package com.chj.redis;

import com.chj.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import static com.chj.staticstatus.RedisProperties.*;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:35
 * @params :
 */
@Service
public class RedisService<T> {
    @Autowired
    private JedisCluster jedisCluster;

    /** 方法描述
    * @Description: 向redis中保存数据(并设置时效时间)
     *              "nx":如果redis中key不存在，则可以存数据
     *              "xx":如果redis中的key存在，则才可以存储数据
     *
     *              "ex":  ex的失效时间单位为秒
     *               "px":   px的失效时间单位为毫秒
     *               seconds 失效时间(如果缺省则说明你不需要设置时间时间)
    * @Param: [key, value, nxxx, expx, seconds]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/15
    */
    public String set(String key,T value ,String nxxx,String expx ,Integer seconds){
        if (null != seconds && 0 < seconds && (NX.equals(nxxx) || XX.equals(nxxx)) && (EX.equals(expx) || PX.equals(expx))) {
            //全部都有值 需要设置失效时间
            return jedisCluster.set(key, JSONUtil.toJsonString(value),nxxx,expx,seconds);
        } else {
            //不需要设置失效时间
            if (NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key,JSONUtil.toJsonString(value)));
            }else if(XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtil.toJsonString(value));
            }
        }
        return NO;
    }
}
