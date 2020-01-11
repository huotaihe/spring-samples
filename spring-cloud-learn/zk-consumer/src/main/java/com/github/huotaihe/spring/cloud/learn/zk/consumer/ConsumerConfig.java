package com.github.huotaihe.spring.cloud.learn.zk.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerConfig
 *
 * @author: huotaihe
 * @Date: 10:32 2019-10-18
 **/
@Configuration
public class ConsumerConfig {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        return restTemplateBuilder.build();

    }

}
