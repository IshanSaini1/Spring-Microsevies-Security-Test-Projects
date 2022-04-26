package com.example.agw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.agw.controller.Controller1;

@Configuration
public class Config1 {
	
	@Bean
	public Controller1 getController() {
		return new Controller1();
	}
	
}
