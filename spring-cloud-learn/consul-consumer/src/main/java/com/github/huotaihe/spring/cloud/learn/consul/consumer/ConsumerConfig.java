package com.github.huotaihe.spring.cloud.learn.consul.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerConfig
 *
 * @author: huotaihe
 * @Date: 12:57 2019-10-11
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
