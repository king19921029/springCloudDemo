package com.yuanqi.contorller;

import com.yuanqi.comm.Response;
import com.yuanqi.comm.ResponseCode;
import com.yuanqi.comm.ResponseUtil;
import com.yuanqi.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    //定义日志对象
    Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private AdminUserService adminUserService;

    //系统用户通过账户名及密码登录接口
    @CrossOrigin
    @PostMapping("/v1/login")
    @ResponseBody
    public Response<Map<String,Object>> login(@RequestBody Map<String,Object> params) throws Exception {

        logger.info("调用/v1/login服务,传递的参数为:{}",params.toString());
        //先判断用户是否登录成功
        Map<String,Object> adminUser = adminUserService.login(params);
        if (adminUser == null){
            return ResponseUtil.buildErrorResponse(ResponseCode.SYSTEM_ERROR);
        }
        else{
            return ResponseUtil.buildResponse(adminUser);
        }

    }
}
