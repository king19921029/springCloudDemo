package com.yuanqi.controller;

import com.google.common.collect.Lists;
import com.yuanqi.comm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengqiang on 2019/9/6.
 * 系统用户相关接口
 */

@RestController
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{

    //定义日志对象
    Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    //定义jwt对象
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    //后台系统用户登录接口,通过账号及密码登录
    @PostMapping(value = "/v1/login")
    @ResponseBody
    public Response<Map<String,Object>> login(String username, String password) throws Exception {

        logger.info("调用/v1/login接口");

        //定义传递参数对象
        Map<String,Object> params = new HashMap<String,Object>();
        //登录账号
        params.put("username",username);
        //登录密码
        params.put("password",password);

        logger.info("---传递参数:{}---",params.toString());

        //判断用户是否登录成功
        Map<String, Object> user = coreServiceRemote.login(params).getData();

        //如果获取到用户信息,则生成token
        if (user != null) {

            //生产新token
            String token = createToken(user);
            user.put("token",token);

            //将token保存到redis
//            coreServiceRemote.saveTokenForUser(user);

            //返回用户信息
            return ResponseUtil.buildResponse(user);

        }
        //未获取到用户信息，登录失败
        else {
            return ResponseUtil.buildErrorResponse(ResponseCode.PHONE_OR_PASSWORD_ERROR);
        }
    }

    //创建用户Token
    private String createToken(Map<String, Object> user) {

        //定义返回token
        String token = null;
        TokenUserDTO userDTO = new TokenUserDTO();
        userDTO.setRoles(Lists.newArrayList("ROLE_USER"));
        userDTO.setId(user.get("id").toString());
        token = jwtTokenUtil.create(userDTO);

        return token;
    }


}
