package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author XinP
 * @Date 2020/8/29 14:10
 */
@Component
public class ItemFeignClientFB implements ItemFeignClient{
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("获取订单商品列表失败");
    }

    @Override
    public JsonResult decrease(List<Item> items) {
        return JsonResult.err("修改商品库存失败");
    }
}
