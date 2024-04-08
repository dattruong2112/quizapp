package com.dattruong.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;

@SpringBootApplication
public class GateWayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayServerApplication.class, args);
    }

    @Bean
    public RouteLocator quizRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/exam/**")
                        .filters( f -> f.rewritePath("/exam/?(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("examCircuitBreaker"))
                        )
                        .uri("lb://EXAM"))
                .route(p -> p
                        .path("/user/**")
                        .filters( f -> f.rewritePath("/user/?(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")))
                        .uri("lb://USER"))
                .build();
    }
}
