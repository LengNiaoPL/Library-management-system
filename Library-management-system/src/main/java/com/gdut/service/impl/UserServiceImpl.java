package com.gdut.service.impl;

import com.gdut.mapper.UserMapper;
import com.gdut.pojo.User;
import com.gdut.service.UserService;
import com.gdut.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户服务层实现类
 * @Author: 林锐涛
 * @Date: 2024/9/22 17:49
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//允许为空了,不然idea识别不到会报错,虽然也不影响.
    private UserMapper userMapper;


    @Override
    public int userRegist(User user) {
        String pass=user.getPassWord();
        user.setPassWord(MD5Util.encrypt(pass));
        return userMapper.addUser(user);
    }

    @Override
     public String userLogin(User user) {
        User userBase= userMapper.findUser(user.getUserName());
        //找不到账号
        if (userBase==null) return "noName";

        String mdPassWord= MD5Util.encrypt(user.getPassWord());

        //如果是学生返回student;
        if (mdPassWord.equals(userBase.getPassWord()) &&  !user.isOfManager() ){
            return "student";
        }

        //如果说是管理员返回manager
        if (mdPassWord.equals(userBase.getPassWord()) && user.isOfManager() && userBase.isOfManager()){
            return "manager";
        }

        //密码或身份不对
        return "noPass";
    }















}
