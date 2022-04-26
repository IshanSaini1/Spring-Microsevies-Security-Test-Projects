package com.example.ccs.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ccs.Entity.CurrencyConversion;
import com.example.ccs.services.CurrencyExchangeProxy;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		RestTemplate template = new RestTemplate();
		String uri = "http://localhost:8000/currency-exchange/from/"+from+"/to/"+to;
		ResponseEntity<CurrencyConversion> obj = template.getForEntity(uri, CurrencyConversion.class);
		CurrencyConversion finalO = obj.getBody();
		finalO.setQuantity(quantity);
		finalO.setTotalCalculatedAmount(finalO.getQuantity().multiply(finalO.getConversionMultiple()));
		finalO.setEnvironment(finalO.getEnvironment()+"= Feign");
		return finalO;
	}
	
	@GetMapping("/currency-conversion-openfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValueOF(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversion finalO = proxy.retrieveExchangeValue(from, to);
		finalO.setQuantity(quantity);
		finalO.setTotalCalculatedAmount(finalO.getQuantity().multiply(finalO.getConversionMultiple()));
		finalO.setEnvironment(finalO.getEnvironment()+"= Feign");
		return finalO;
	}
}
