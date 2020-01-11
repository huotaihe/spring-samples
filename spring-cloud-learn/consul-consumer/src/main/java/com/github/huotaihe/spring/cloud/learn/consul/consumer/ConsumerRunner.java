package com.github.huotaihe.spring.cloud.learn.consul.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerRunner
 *
 * @author: huotaihe
 * @Date: 12:55 2019-10-11
 **/
@Component
@Slf4j
public class ConsumerRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("DiscoveryClient: {}", discoveryClient.getClass().getClasses());


        discoveryClient.getInstances("consul-service").stream().forEach(a -> {
            log.info("Host: {}, Port: {}", a.getHost(), a.getPort());
        });

        String result = restTemplate.getForEntity("http://consul-service/helloworld", String.class).getBody();

        log.info("Service result: {}", result);

    }
}
