package com.yuanqi.controller;

import com.yuanqi.comm.Response;
import com.yuanqi.comm.TokenUserDTO;
import com.yuanqi.remote.CoreServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;
import java.util.Objects;

/**
 * Created by fengqiang on 2019/7/18.
 * 基类接口
 */

public class BaseController {

    //protected私有
    //核心远程服务调用service
    @Autowired
    protected CoreServiceRemote coreServiceRemote;

    //通过该方法获取登录用户信息
    protected String getUserId() {

        //获取上下文对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //如果未获取到信息则直接返回
        if (Objects.isNull(authentication)) {
            return null;
        }
        //获取到信息后判断是否是登录信息
        Object obj = authentication.getDetails();
        if (obj instanceof TokenUserDTO) {
            TokenUserDTO user = (TokenUserDTO) obj;
            //通过登录信息获取用户ID
//            Response<Map<String,Object>> response = coreServiceRemote.getUserInfoForToken(user.getToken());
//            if (response.getCode() == 0) {
//                return response.getData().get("id").toString();
//            }
        }
        return null;
    }

    //通过该方法获取登录token信息
    protected String getUserToken() {

        //获取上下文对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //如果未获取到信息则直接返回
        if (Objects.isNull(authentication)) {
            return null;
        }
        //获取到信息后判断是否是登录信息
        Object obj = authentication.getDetails();
        if (obj instanceof TokenUserDTO) {
            TokenUserDTO user = (TokenUserDTO) obj;
            return user.getToken();
        }
        return null;
    }
}
