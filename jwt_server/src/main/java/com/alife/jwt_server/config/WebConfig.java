package com.alife.jwt_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alife.jwt_server.security.SecurityConstants;

@EnableWebMvc
@Configuration
public class WebConfig  implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedHeaders("*")
		.exposedHeaders(SecurityConstants.HEADER_STRING)
		.allowCredentials(true)
		.allowedMethods("GET","POST","PUT","DELETE")
		.allowedOrigins("*");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
}
