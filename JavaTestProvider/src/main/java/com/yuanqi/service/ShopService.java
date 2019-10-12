package com.yuanqi.service;

import java.util.List;
import java.util.Map;

public interface ShopService {
    //查询系统用户列表信息
    Map<String, Object> getShopList(Map<String, Object> params);

    Map<String, Object> delShop(Map<String, Object> params);

    Map<String, Object> addShop(Map<String, Object> params);

    Map<String, Object> updateShop(Map<String, Object> params);

    Map<String, Object> sortShopList(Map<String, Object> params);
}
