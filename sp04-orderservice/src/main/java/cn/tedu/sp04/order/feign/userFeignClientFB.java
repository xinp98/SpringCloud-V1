package cn.tedu.sp04.order.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @Author XinP
 * @Date 2020/8/31 10:49
 */
@Component
public class userFeignClientFB implements UserFeignClient {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        if (Math.random() < 0.5){
            if(Math.random()<0.4) {
                return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
            }
        }
        return JsonResult.err("获取用户列表失败");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("增加用户积分失败");
    }
}
