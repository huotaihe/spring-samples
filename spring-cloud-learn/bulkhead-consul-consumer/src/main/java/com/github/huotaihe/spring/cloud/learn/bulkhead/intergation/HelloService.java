package com.github.huotaihe.spring.cloud.learn.bulkhead.intergation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * EurekaService
 *
 * @author: huotaihe
 * @Date: 10:19 2019-10-15
 **/
@FeignClient(name = "consul-service")
public interface HelloService {

    @GetMapping("/helloworld")
    String helloworld();

}
