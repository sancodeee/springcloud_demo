package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//@EnableEurekaClient //只适用于eureka注册中心 作用：能够然让注册中心发现，扫描到该服务
@EnableDiscoveryClient //还可以适用其他注册中心，使该服务能够被注册中心发现
@RibbonClient(name = "query-service") //name属性的值是 服务提供者集群的名称
@SpringBootApplication
public class ConsumerApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication01.class, args);
    }
}
