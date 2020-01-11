package com.github.huotaihe.spring.cloud.learn.eureka.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignConsumerApplication.class, args);
    }

}
