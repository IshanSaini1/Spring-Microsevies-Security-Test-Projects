package com.example.sst.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c1")
public class BasicController1 {

	@RequestMapping("/home-page")
	public String sendHomePage(Model model) {
		return "home";
	}
	
	@RequestMapping("/hello")
	public String sendHelloPage(Model model) {
		return "hello";
	}

}
