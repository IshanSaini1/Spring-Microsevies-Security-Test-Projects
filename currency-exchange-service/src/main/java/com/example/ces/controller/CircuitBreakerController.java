package com.example.ces.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "fallback")
	public String sampleAPI() {
		log.info("Entered in Method");
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> resp = rest.getForEntity("http://localhost:8001/Temp", String.class);
		return resp.getBody();
	}
	
	public String fallback(Exception ex) {
		return "Some Error Has Occurred !!";
	}
}
