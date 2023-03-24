package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeleteBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeleteBookApplication.class,args);
    }
}
