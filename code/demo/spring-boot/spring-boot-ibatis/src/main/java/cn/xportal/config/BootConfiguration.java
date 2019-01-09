package cn.xportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.xportal.web.intercepter.BaseIntercepter;
@Configuration
public class BootConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BaseIntercepter()).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
