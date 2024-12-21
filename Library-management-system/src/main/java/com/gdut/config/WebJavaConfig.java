package com.gdut.config;

import com.gdut.interceptor.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * projectName: com.atguigu.config
 * 
 * 1.实现Springmvc组件声明标准化接口WebMvcConfigurer 提供了各种组件对应的方法
 * 2.添加配置类注解@Configuration
 * 3.添加mvc复合功能开关@EnableWebMvc
 * 4.添加controller层扫描注解
 * 5.开启默认处理器,支持静态资源处理
 */
@Configuration
@EnableWebMvc   //自动创建handlermapping和handleradepter
@ComponentScan({"com.gdut.controller","com.gdut.error"})
public class WebJavaConfig implements WebMvcConfigurer {

    //开启静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); 
    }


    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将拦截器添加到Springmvc环境,默认拦截所有Springmvc分发的请求
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/card/add").excludePathPatterns("/user/**");
        // 排除有关用户的请求//排除完善信息的请求
    }

}
