package com.yuanqi.dao;
import java.util.List;
import java.util.Map;

public interface IShopMapper {
    List<Map<String,Object>> getShopList(Map<String, Object> params);
    Integer delShop(Map<String, Object> params);
    Integer addShop(Map<String, Object> params);
    Integer updateShop(Map<String, Object> params);
    List<Map<String,Object>> sortShopList(Map<String, Object> params);
}
