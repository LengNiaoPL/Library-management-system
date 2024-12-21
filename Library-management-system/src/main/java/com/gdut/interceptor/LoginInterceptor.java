package com.gdut.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdut.utils.R;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * @Description: 检测学生登入状态的拦截器
 * @Author: 林锐涛
 * @Date: 2024/9/26 15:54
 */

public class LoginInterceptor implements HandlerInterceptor {

    // 在处理请求的目标 handler 方法前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userName=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 检查Cookie的名称是否是你想要的
                if ("userName".equals(cookie.getName())) {
                    // 获取Cookie的值
                      userName = cookie.getValue();
                }
            }
        }

        if (userName==null){
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(R.redirection("Login"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            // 将JSON字符串写入响应体
            try (PrintWriter out = response.getWriter()) {
                out.write(jsonString);
            }

            return false;
        }

        return true;
    }
}
