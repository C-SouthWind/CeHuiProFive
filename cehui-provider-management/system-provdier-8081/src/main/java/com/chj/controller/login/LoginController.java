package com.chj.controller.login;

import com.chj.model.login.User;
import com.chj.redis.RedisService;
import com.chj.service.login.LoginService;
import com.chj.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:33
 * @params :
 */
@RestController
public class LoginController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoginService loginService;

    /** 方法描述
    * @Description: 执行登录操作
     *                  八大数据类型 @RequestParam
     *                  其他类型     @RequestBody
    * @Param: [user]
    * @return: com.chj.vo.TokenVo
    * @Author: chj
    * @Date: 2020/5/15
    */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user){
       return loginService.doLogin(user,redisService);
    }
}
