package com.EcommerceProject.myBussiness.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
	            "/users/login", 
	            "/users" 
	    };
}
