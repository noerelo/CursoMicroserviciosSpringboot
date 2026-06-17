package com.aleal.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/applications/apiHotel/**")
						.filters(f -> f.rewritePath("/applications/apiHotel/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://HOTELS"))
				.route(p -> p
						.path("/applications/apiRooms/**")
						.filters(f -> f.rewritePath("/applications/apiRooms/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://ROOMS"))
				.route(p -> p
						.path("/applications/apiReservations/**")
						.filters(f -> f.rewritePath("/applications/apiReservations/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://RESERVATIONS"))
				.build();
	}
}
