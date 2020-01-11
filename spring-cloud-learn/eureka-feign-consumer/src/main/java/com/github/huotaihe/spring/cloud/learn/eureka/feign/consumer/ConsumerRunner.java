package com.github.huotaihe.spring.cloud.learn.eureka.feign.consumer;

import com.github.huotaihe.spring.cloud.learn.eureka.feign.consumer.intergration.EurekaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ConsumerRunner
 *
 * @author: huotaihe
 * @Date: 10:23 2019-10-15
 **/
@Component
@Slf4j
public class ConsumerRunner implements ApplicationRunner {

    @Autowired
    private EurekaService eurekaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String result = eurekaService.helloworld();

        log.info(result);
    }
}
