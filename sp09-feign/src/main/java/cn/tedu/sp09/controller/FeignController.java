package cn.tedu.sp09.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp09.feign.ItemFeignClient;
import cn.tedu.sp09.feign.OrderFeignClient;
import cn.tedu.sp09.feign.UserFeignClient;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.jar.JarEntry;

/**
 * @Author XinP
 * @Date 2020/8/29 10:32
 */
@RestController
@Slf4j
public class FeignController {

    @Autowired
    private ItemFeignClient itemFeignClient;
    @Autowired
    private UserFeignClient userService;
    @Autowired
    private OrderFeignClient orderService;
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        log.info("远程调用商品服务 获得订单商品列表");
        return itemFeignClient.getItems(orderId);
    }

    @PostMapping("/item-service/{decreaseNumber}")
    public JsonResult decreaseNumber(@RequestBody List<Item> items){
        log.info("远程调用商品服务 减少商品库存");
        return itemFeignClient.decrease(items);
    }

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        log.info("远程调用用户服务 获取用户");
        return userService.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        log.info("远程调用用户服务 增加用户积分");
        return userService.addScore(userId, score);
    }



    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        log.info("远程调用订单服务 获得订单");
        return orderService.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        log.info("远程调用订单服务 增加订单");
        return orderService.addOrder();
    }
}
