package com.dattruong.host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HostApplication {
    public static void main(String[] args) {
        SpringApplication.run(HostApplication.class, args);
    }
}
