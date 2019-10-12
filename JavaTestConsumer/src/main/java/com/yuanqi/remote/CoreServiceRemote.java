package com.yuanqi.remote;

import com.yuanqi.comm.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by fengqiang on 2019/7/22.
 */

@FeignClient(name = "yuanqi-service-provider")
public interface CoreServiceRemote {
    /*** 系统用户相关接口 start ***/
    //系统用户登录
    @RequestMapping(value = "/adminUser/v1/login",method = RequestMethod.POST)
    Response<Map<String,Object>> login(Map<String, Object> params);

    @RequestMapping(value = "/adminUser/v1/getShopList",method = RequestMethod.POST)
    Response<Map<String,Object>> getShopList(Map<String, Object> params);

    @RequestMapping(value = "/adminUser/v1/delShop",method = RequestMethod.POST)
    Response<Map<String,Object>> delShop(Map<String, Object> params);

    @RequestMapping(value = "/adminUser/v1/addShop",method = RequestMethod.POST)
    Response<Map<String,Object>> addShop(Map<String, Object> params);

    @RequestMapping(value = "/adminUser/v1/updateShop",method = RequestMethod.POST)
    Response<Map<String,Object>> updateShop(Map<String, Object> params);

    @RequestMapping(value = "/adminUser/v1/sortShopList",method = RequestMethod.POST)
    Response<Map<String,Object>> sortShopList(Map<String, Object> params);

}
