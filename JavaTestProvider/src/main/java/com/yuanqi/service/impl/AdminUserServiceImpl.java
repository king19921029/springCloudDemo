package com.yuanqi.service.impl;

import com.yuanqi.comm.Base64PasswordEncoder;
import com.yuanqi.dao.IAdminUserMapper;
import com.yuanqi.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private IAdminUserMapper adminUserMapper;

    //系统用户登录,通过账户名及密码
    public Map<String, Object> login(Map<String, Object> params) {
        System.out.println("2222--------------");
        //加密用户密码
        String pwd = Base64PasswordEncoder.encode(params.get("password").toString());
        //重新赋值
        Map<String, Object> newParam = new HashMap<>();
        newParam.put("username", params.get("username").toString());
        newParam.put("password", pwd);

        //获取用户信息
        Map<String,Object> result = adminUserMapper.getAdminUserInfoByUsernameAndPassword(newParam);
        //登录成功后插入登录信息
        if (result!=null){
            this.insertAdminUserActionLog(result.get("id").toString(),"登录系统",null);
        }
        else{
            //add
            //String adminUserId = UUID.randomUUID().toString();
            //newParam.put("adminUserId",adminUserId);
            //adminUserMapper.insertAdminUser(newParam);
            //result = adminUserMapper.getAdminUserInfoByUsernameAndPassword(newParam);
        }

        return result;

    }

    @Override
    public List<Map<String, Object>> getUserRoleList(Map<String, Object> params) {
        return null;
    }

    @Override
    public Map<String, Object> queryAdminUserList(Map<String, Object> params) {
        return null;
    }

    @Override
    public Map<String, Object> queryAdminUserInfoById(Map<String, Object> params) {
        return null;
    }

    @Override
    public Map<String, Object> addAdminUser(Map<String, Object> params) {
        return null;
    }

    @Override
    public boolean insertAdminUserActionLog(String adminUserId, String action, Map<String, Object> params) {
        return false;
    }
}
