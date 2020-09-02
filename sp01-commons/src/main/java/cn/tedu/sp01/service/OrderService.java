package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Order;

/**
 * @Author XinP
 * @Date 2020/8/25 10:00
 */
public interface OrderService {
    //获取订单
    Order getOrder(String orderId);

    //保存订单
    void addOrder(Order order);
}
