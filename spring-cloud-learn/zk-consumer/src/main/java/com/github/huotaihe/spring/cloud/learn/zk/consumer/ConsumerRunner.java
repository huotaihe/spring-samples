package com.github.huotaihe.spring.cloud.learn.zk.consumer;

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
 * @Date: 10:30 2019-10-18
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

        discoveryClient.getInstances("zk-service").stream().forEach(
                e -> {
                    log.info(e.getHost());
                }
        );

        String helloworld = restTemplate.getForEntity("http://zk-service/helloworld", String.class).getBody();

        log.info("result: {}", helloworld);


    }
}
