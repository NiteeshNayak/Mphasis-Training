package com.test.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudGateway {

	@Bean
	protected RouteLocator getRouteConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/product1/*")
						.uri("http://localhost:8899/*"))
				.route(r -> r.path("/product2/*")
						.uri("http://localhost:9988/*"))
				.build();
	}
}
