package com.edexsoft.webmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.edexsoft.framework.security.User;
import com.edexsoft.framework.security.UserService;

public class WebAuthorizeInteceptor extends HandlerInterceptorAdapter {
	@Autowired
	UserService userService;

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        HandlerMethod methodHandler=(HandlerMethod) handler;
        WebAuthorizeAnnotation auth=methodHandler.getMethodAnnotation(WebAuthorizeAnnotation.class);
//　　　　　	// 如果方法中添加了@AuthCheckAnnotation 这里的auth不为null
//　　　　　	// 如果@AuthCheckAnnotation(check=false) 这里的auth为false,即不用进行拦截验证，@AuthCheckAnnotation默认为前面定义的true　　
//        if(auth!=null&&!auth.check()){
//           return true;  
//        }
//        User user=(User)request.getSession().getAttribute(Constants.SESSION_USER);
//        try {
//        	//userService.login(request, user);
//            return true;
//        } catch (Exception e) {
//            request.getRequestDispatcher("login.do").forward(request, response);
//            return false;
//        }
        return true;
    }

}