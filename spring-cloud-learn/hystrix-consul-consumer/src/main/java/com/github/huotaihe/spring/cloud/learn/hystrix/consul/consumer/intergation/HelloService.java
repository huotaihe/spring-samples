package com.github.huotaihe.spring.cloud.learn.hystrix.consul.consumer.intergation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * EurekaService
 *
 * @author: huotaihe
 * @Date: 10:19 2019-10-15
 **/
@FeignClient(name = "consul-service", fallback = FallbackHelloService.class)
public interface HelloService {

    @GetMapping("/helloworld")
    String helloworld();

}
