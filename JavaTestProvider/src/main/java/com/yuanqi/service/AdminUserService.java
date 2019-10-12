package com.yuanqi.service;

import java.util.List;
import java.util.Map;

/**
 * Created by fengqiang on 2019/9/6.
 */
public interface AdminUserService {

    //系统用户登录,通过账户名及密码
    Map<String,Object> login(Map<String, Object> params);

    //通过Token获取用户可访问的页面权限
    List<Map<String,Object>> getUserRoleList(Map<String, Object> params);

    //查询系统用户列表信息
    Map<String, Object> queryAdminUserList(Map<String, Object> params);

    //查询系统用户详情信息
    Map<String, Object> queryAdminUserInfoById(Map<String, Object> params);

    //新增系统用户信息
    Map<String, Object> addAdminUser(Map<String, Object> params);


    //插入用户操作信息
    boolean insertAdminUserActionLog(String adminUserId, String action, Map<String, Object> params);


}
