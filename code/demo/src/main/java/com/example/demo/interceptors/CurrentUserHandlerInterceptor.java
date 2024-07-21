package com.example.demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.util.CurrentUserHelper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CurrentUserHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		CurrentUserHelper.setCurrent_user_id(request.getHeader("UserId"));
		CurrentUserHelper.setCurrent_user_name(request.getHeader("UserName"));
		return true;
	}
}
