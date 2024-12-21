package com.gdut.service;

import com.gdut.pojo.User;

/**
 * @Description: 用户服务层接口
 * @Author: 林锐涛
 * @Date: 2024/9/22 17:48
 */

public interface UserService {

    int userRegist(User user);
    //注册入口,返回影响行数


    String userLogin(User user);
    //该接口为登入验证,学生返回"student",管理员返回"manager",
    // 找不到账号返回"noName",密码和身份错误返回"noPass"


}
