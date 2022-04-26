package com.example.agw.configs;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AGConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		Function<PredicateSpec, Buildable<Route>> var1 = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyName", "Name1")).uri("http://httpbin.org/get");

		Function<PredicateSpec, Buildable<Route>> var2 = p -> p.path("/currency-exchange/**")
				.uri("lb://currency-exchange");

		Function<PredicateSpec, Buildable<Route>> var3 = p -> p.path("/currency-conversion-feign/**")
				.uri("lb://currency-conversion");

		Function<PredicateSpec, Buildable<Route>> var4 = p -> p.path("/currency-conversion/**")
				.uri("lb://currency-conversion");

		return builder.routes().route(var1).route(var2).route(var3).route(var4).build();
	}
}
