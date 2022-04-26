package com.example.ccs.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ccs.Entity.CurrencyConversion;

//@FeignClient(url = "localhost:8000", name = "currency-exchange" )
//To allow dynamic Load Balancing with the Eureka Naming Server.
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	
}
