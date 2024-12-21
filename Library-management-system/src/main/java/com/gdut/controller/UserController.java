package com.gdut.controller;

import com.gdut.pojo.User;
import com.gdut.service.UserService;
import com.gdut.utils.R;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description: 用户控制层
 * @Author: 林锐涛
 * @Date: 2024/9/22 17:48
 */




@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("regist")
    public Object regist(@RequestBody User user){
        int a=userService.userRegist(user);
        if (a==1){
            return R.redirection("http://localhost:8080/static/addInformation.html");
        }else {
            return R.fail("账号可能已存在");
        }
    }




    @PostMapping("login")
    public Object findUser(@RequestBody User user, HttpServletResponse response) throws IOException {

          String s=userService.userLogin(user);

          Cookie cookie1 = new Cookie("userName", user.getUserName());
          cookie1.setMaxAge(60*60*24*1); // 示例：设置过期时间为1天
          cookie1.setPath("/"); //设置cookie的可使用路径
          response.addCookie(cookie1);  // 将Cookie添加到响应中


          Cookie cookie2;

          if (s.equals("student")){

              cookie2 = new Cookie("ofManager", "false");
              cookie2.setMaxAge(60*60*24*1);
              cookie2.setPath("/");
              response.addCookie(cookie2);

              return R.redirection("http://localhost:8080/static/Main.html");

          }else if (s.equals("manager")){

              cookie2 = new Cookie("ofManager", "true");
              cookie2.setMaxAge(60*60*24*1);
              cookie2.setPath("/");
              response.addCookie(cookie2);

              return R.redirection("http://localhost:8080/static/Root.html");


          }

          return null;
    }



}
