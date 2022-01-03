package com.edu.tutor.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/login.html");
		registry.addViewController("/login.html");
//		registry.addViewController("/login.html");
	}
}
