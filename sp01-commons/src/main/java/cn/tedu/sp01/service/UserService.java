package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.User;

/**
 * @Author XinP
 * @Date 2020/8/25 9:59
 */
public interface UserService {
    //获取用户数据
    User getUser(Integer userId);

    //增加用户积分
    void addScore(Integer userId, Integer score);
}
