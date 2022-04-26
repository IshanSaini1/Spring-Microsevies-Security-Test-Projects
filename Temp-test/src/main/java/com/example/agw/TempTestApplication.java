package com.example.agw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.agw.config.Config1;
import com.example.agw.controller.Controller1;

@SpringBootApplication
public class TempTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TempTestApplication.class, args);
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Config1.class);
		Controller1 controller = ctx2.getBean("getController",Controller1.class);
		System.out.println(controller.returnName());
	}

}
