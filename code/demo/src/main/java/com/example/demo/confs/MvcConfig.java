package com.example.demo.confs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptors.CurrentUserHandlerInterceptor;

@Configuration
@EnableAsync
public class MvcConfig implements WebMvcConfigurer {
	@Bean
	HandlerInterceptor createCurrentUserHandlerInterceptor() {
		return new CurrentUserHandlerInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(createCurrentUserHandlerInterceptor());
	}
}
