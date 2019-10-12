package com.yuanqi.service.impl;

import com.yuanqi.dao.IShopMapper;
import com.yuanqi.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
//public class ShowUserListServiceImpl implements ShowUserListService
public class ShopServiceImpl implements ShopService {
    //定义日志对象
    Logger logger = LoggerFactory.getLogger(ShopService.class);
    @Autowired
    private IShopMapper shopMapper;
    //查询系统用户列表信息
    public Map<String, Object> getShopList(Map<String, Object> params){
        //定义返回对象
        Map<String,Object> result = new HashMap<String,Object>();
        List<Map<String, Object>> shopList = shopMapper.getShopList(params);
        result.put("shopList",shopList);
        logger.info("28,{}",shopList);
        //返回取得的结果
        return result;
    }
    //删除
    public Map<String, Object> delShop(Map<String, Object> params){
        //定义返回对象
        Map<String,Object> result = new HashMap<String,Object>();
        Integer success = 0;
        success =  shopMapper.delShop(params);
        result.put("success",success);
        return result;
    }
    //新增
    public Map<String, Object> addShop(Map<String, Object> params){
        //定义返回对象
        Map<String,Object> result = new HashMap<String,Object>();
        Integer success = 0;

        String id = UUID.randomUUID().toString();
        params.put("id",id);
        success = shopMapper.addShop(params);
        result.put("success",success);
        return result;
    }
    //修改
    public Map<String, Object> updateShop(Map<String, Object> params){
        //定义返回对象
        Map<String,Object> result = new HashMap<String,Object>();
        Integer success = 0;
        success = shopMapper.updateShop(params);
        result.put("success",success);
        return result;
    }

    //降序
    public Map<String, Object> sortShopList(Map<String, Object> params){
        //定义返回对象
        Map<String,Object> result = new HashMap<String,Object>();
        List <Map<String, Object>> sortList = shopMapper.sortShopList(params);
        result.put("sortList",sortList);
        logger.info("28,{}",sortList);
        //返回取得的结果
        return result;
    }

}
