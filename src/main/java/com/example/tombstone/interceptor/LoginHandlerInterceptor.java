package com.example.tombstone.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 登录拦截器
 * @email 2434017367@qq.com
 * @author: zhy
 * @date: 2019/12/17
 * @time: 10:15
 */

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String remoteAddr = request.getRemoteAddr();
        String requestURI = request.getRequestURI();
        System.out.println(remoteAddr + ":进入拦截器 拦截目标：" + requestURI);
        HttpSession session = request.getSession();
        Object ip = session.getAttribute("ip");
        if (ip == null){
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
