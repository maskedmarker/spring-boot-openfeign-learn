package com.example.learn.spring.boot.openfeign.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HelloBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

}