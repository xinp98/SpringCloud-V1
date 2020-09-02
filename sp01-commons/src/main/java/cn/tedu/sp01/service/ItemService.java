package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Item;

import java.util.List;

/**
 * @Author XinP
 * @Date 2020/8/25 9:59
 */
public interface ItemService {
    //获取订单中的商品列表
    List<Item> getItems(String orderId);

    //减少这组商品的库存
    void decreaseNumbers(List<Item> list);
}
