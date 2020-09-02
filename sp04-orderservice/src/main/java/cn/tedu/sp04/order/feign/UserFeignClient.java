package cn.tedu.sp04.order.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author XinP
 * @Date 2020/8/31 10:33
 */
@FeignClient(name = "user-service",fallback = userFeignClientFB.class)
public interface UserFeignClient {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId,@RequestParam Integer score);
}
