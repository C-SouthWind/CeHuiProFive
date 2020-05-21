package com.chj.service.login;

import com.chj.mapper.login.UserMapper;
import com.chj.model.login.User;
import com.chj.redis.RedisService;
import com.chj.utils.IDUtils;
import com.chj.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chj.staticstatus.RedisProperties.NX;
import static com.chj.staticstatus.RedisProperties.XX;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:48
 * @params :
 */
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    /** 方法描述 
    * @Description: 执行登录操作
    * @Param: [user, redisService]
    * @return: com.chj.vo.TokenVo
    * @Author: chj
    * @Date: 2020/5/15
    */
    public TokenVo doLogin(User user, RedisService redisService) {
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);
        //判断user是否为空
        if (null != user) {
            //验证密码是否正确
            User u = userMapper.selectOne(user);
            if (null != u) {
                //登录成功 调用自定义UUID工具类
                String token = IDUtils.getUUID();
                //设置token
                u.setToken(token);
                //存入数据库
                int updateResult = userMapper.updateByPrimaryKey(u);
                //判断是否更新成功
                if (updateResult > 0) {
                    //更新成功  UUID设置redis失效时间
                    String setResult = redisService.set(String.valueOf(u.getId()), token, XX, NX, 1800);
                    if ("OK".equals(setResult.toUpperCase()) || "1".equals(setResult)) {
                        return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(u.getId()));
                    }
                }
            }
        }
        return tokenVo;
    }
}
