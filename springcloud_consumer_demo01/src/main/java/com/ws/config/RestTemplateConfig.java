package com.ws.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //ribbon客户端负载均衡注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //自定义负载均衡策略
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();  //轮询访问规则（默认规则）
//        return new RandomRule();  //随机访问规则
    }

}
