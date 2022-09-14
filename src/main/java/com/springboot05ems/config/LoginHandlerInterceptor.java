package com.springboot05ems.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author BoBooY
 * @date 2022/9/6 15:40
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser") == null) {
            //未登录，返回首页，并传入信息
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        } else {
            //登录了，放行
            return true;
        }
    }
}
