package com.yuanqi.controller;

import com.yuanqi.comm.Response;
import com.yuanqi.comm.ResponseCode;
import com.yuanqi.comm.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


@RestController
@RequestMapping("/adminUser")
public class ShopController extends BaseController{
    //定义日志对象
    Logger logger = LoggerFactory.getLogger(ShopController.class);
    //处理post请求
    @PostMapping(value = "/v1/getShopList")
    @ResponseBody
    public Response<Map<String,Object>> getShopList(String userId) throws Exception {
        logger.info("调用/v1/getShopList 接口");
        Map<String,Object> params = new HashMap<String,Object>();
        Map<String, Object> result = coreServiceRemote.getShopList(params).getData();
        return ResponseUtil.buildResponse(result);
    }
    @PostMapping(value="/v1/delShop")
    @ResponseBody
    public Response<Map<String,Object>> delShop(String shopId) throws Exception{
        logger.info("调用/v1/delShop 接口,shopId{}",shopId);

        if( shopId!=null ){
            Map<String,Object> params = new Hashtable<String, Object>();
            params.put("shopId",shopId);
            Map<String, Object> result = coreServiceRemote.delShop(params).getData();
            return ResponseUtil.buildResponse(result);
        }else{
            return ResponseUtil.buildErrorResponse(ResponseCode.SYSTEM_ERROR);
        }

    }
    @PostMapping(value="/v1/addShop")
    @ResponseBody
    public Response<Map<String,Object>> addShop(String shop,Integer pic) throws Exception{
        logger.info("调用/v1/addShop 接口");
        Map<String,Object> params = new Hashtable<String, Object>();
        params.put("name",shop);
        params.put("pic",pic);
        Map<String, Object> result = coreServiceRemote.addShop(params).getData();
        return ResponseUtil.buildResponse(result);
    }
    @PostMapping(value="/v1/updateShop")
    @ResponseBody
    public Response<Map<String,Object>> updateShop(String id,String name,Integer pic) throws Exception{
        logger.info("调用/v1/updateShop 接口");
        Map<String,Object> params = new Hashtable<String, Object>();
        params.put("id",id);
        params.put("name",name);
        params.put("pic",pic);
        Map<String, Object> result = coreServiceRemote.updateShop(params).getData();
        return ResponseUtil.buildResponse(result);
    }
    @PostMapping(value="/v1/sortShopList")
    @ResponseBody
    public Response<Map<String,Object>> sortShopList(Integer type) throws Exception{
        logger.info("调用/v1/sortShopList 接口,type{},",type);

        Map<String,Object> params = new Hashtable<String, Object>();
        params.put("type",type);

        Map<String, Object> result = coreServiceRemote.sortShopList(params).getData();
        return ResponseUtil.buildResponse(result);
    }

}

