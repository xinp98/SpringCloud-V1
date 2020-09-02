package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author XinP
 * @Date 2020/8/29 10:25
 * 远程调用
 * 声明式客户端
 */
@FeignClient(name = "item-service",fallback = ItemFeignClientFB.class)
public interface ItemFeignClient {
    @GetMapping("/{orderId}")       //远程调用获取商品列表
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @PostMapping("/decreaseNumber") //远程调用修改商品数量
    JsonResult   decrease(@RequestBody List<Item> items);
}
