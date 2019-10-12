package com.yuanqi.contorller;

import com.yuanqi.comm.Response;
import com.yuanqi.comm.ResponseCode;
import com.yuanqi.comm.ResponseUtil;
import com.yuanqi.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/adminUser")
public class ShopController {
    //定义日志对象
    Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService showUserListService;

    @CrossOrigin
    @PostMapping("/v1/getShopList")
    @ResponseBody
    public Response<Map<String,Object>> getShopList(@RequestBody Map<String,Object> params) throws Exception {

        logger.info("调用/v1/getShopList,传递的参数为:{}",params.toString());
        //先判断用户是否登录成功
        Map<String,Object> userList = showUserListService.getShopList(params);
        if (userList == null){
            return ResponseUtil.buildErrorResponse(ResponseCode.SYSTEM_ERROR);
        }
        else{
            return ResponseUtil.buildResponse(userList);
        }

    }

    @CrossOrigin
    @PostMapping("/v1/delShop")
    @ResponseBody
    public Response<Map<String,Object>> delShop(@RequestBody Map<String,Object> params) throws Exception {
        logger.info("调用/v1/delShop,传递的参数为:{}",params.toString());
        //先判断用户是否登录成功
        return ResponseUtil.buildResponse(showUserListService.delShop(params));
    }
    @CrossOrigin
    @PostMapping("/v1/addShop")
    @ResponseBody
    public Response<Map<String,Object>> addShop(@RequestBody Map<String,Object> params) throws Exception {
        logger.info("调用/v1/addShop,传递的参数为:{}",params.toString());
        return ResponseUtil.buildResponse(showUserListService.addShop(params));
    }
    @CrossOrigin
    @PostMapping("/v1/updateShop")
    @ResponseBody
    public Response<Map<String,Object>> updateShop(@RequestBody Map<String,Object> params) throws Exception {
        logger.info("调用/v1/updateShop,传递的参数为:{}",params.toString());
        return ResponseUtil.buildResponse(showUserListService.updateShop(params));
    }
    @CrossOrigin
    @PostMapping("/v1/sortShopList")
    @ResponseBody
    public Response<Map<String,Object>> sortShopList(@RequestBody Map<String,Object> params) throws Exception {
        logger.info("调用/v1/sortShopList,传递的参数为:{}",params.toString());
        return ResponseUtil.buildResponse(showUserListService.sortShopList(params));
    }

}
