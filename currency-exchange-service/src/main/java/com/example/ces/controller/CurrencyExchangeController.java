package com.example.ces.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ces.Entity.CurrencyExchange;
import com.example.ces.repo.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange exgRepo = repository.findByFromEqualsAndToEquals(from, to);
		//CurrencyExchange exg = new CurrencyExchange(1001l, from, to, BigDecimal.valueOf(65.30), env.getProperty("local.server.port")+" Currency Exchange");
		exgRepo.setEnvironment(env.getProperty("local.server.port")+" - CurrencyExchange ");
		return exgRepo;
	}
}
