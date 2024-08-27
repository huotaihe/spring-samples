package com.github.huotaihe.spring.cloud.learn.bulkhead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAspectJAutoProxy
public class BulkheadConsulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulkheadConsulConsumerApplication.class, args);
    }

}