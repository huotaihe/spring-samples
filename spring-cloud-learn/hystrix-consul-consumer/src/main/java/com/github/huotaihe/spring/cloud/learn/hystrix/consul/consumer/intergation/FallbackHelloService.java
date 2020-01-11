package com.github.huotaihe.spring.cloud.learn.hystrix.consul.consumer.intergation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * FallbackHelloService
 *
 * @author: huotaihe
 * @Date: 07:42 2019-10-23
 **/
@Slf4j
@Component
public class FallbackHelloService implements HelloService {
    @Override
    public String helloworld() {
        log.info("fallback hello world");
        return "fallback";
    }
}
