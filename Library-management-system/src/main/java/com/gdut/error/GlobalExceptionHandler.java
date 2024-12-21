package com.gdut.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  //代表当前类是处理异常且返回json的控制类
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        e.printStackTrace();//
        return "有异常,请联系管理员";
    }



}
