package com.server.core.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.server.core.interceptor.BaseControllerInterceptor;

@Configuration
public class BaseConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BaseControllerInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//添加映射路径
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("*")
			.allowedHeaders("*");
		super.addCorsMappings(registry);
	}
}
