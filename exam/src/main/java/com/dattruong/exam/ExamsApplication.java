package com.dattruong.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamsApplication.class, args);
    }
}