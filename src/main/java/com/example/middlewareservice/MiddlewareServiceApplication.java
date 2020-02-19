package com.example.middlewareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class MiddlewareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlewareServiceApplication.class, args);
    }

}
