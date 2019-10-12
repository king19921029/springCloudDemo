package com.yuanqi.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by fengqiang on 2019/9/6.
 */
public interface IAdminUserMapper {

    //通过用户名及密码查找用户信息
    Map<String,Object> getAdminUserInfoByUsernameAndPassword(Map<String, Object> params);


}
