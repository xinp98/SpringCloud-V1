package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @Author XinP
 * @Date 2020/8/29 14:10
 */
@Component
public class UserFeignClientFB implements UserFeignClient{
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("获取用户信息失败");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("增加用户积分失败");
    }
}
