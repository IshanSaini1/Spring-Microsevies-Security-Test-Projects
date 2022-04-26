package com.example.ces.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ces.Entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	public CurrencyExchange findByFromEqualsAndToEquals(String from, String to);
}
