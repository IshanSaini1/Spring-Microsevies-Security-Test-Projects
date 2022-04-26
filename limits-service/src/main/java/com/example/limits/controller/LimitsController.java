package com.example.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.limits.config.Configuration;
import com.example.limits.entity.Limits;

@RestController
public class LimitsController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}

	@GetMapping("/limits/{min}/{max}")
	public Limits retrieveLimitsParams(@PathVariable(name = "min") Integer min1, @PathVariable(name = "max") Integer max1) {
		return new Limits(min1, max1);
	}
}
