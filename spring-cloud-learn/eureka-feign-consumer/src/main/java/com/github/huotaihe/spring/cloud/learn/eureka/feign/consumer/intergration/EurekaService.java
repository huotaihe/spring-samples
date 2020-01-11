package com.github.huotaihe.spring.cloud.learn.eureka.feign.consumer.intergration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * EurekaService
 *
 * @author: huotaihe
 * @Date: 10:19 2019-10-15
 **/
@FeignClient(name = "eureka-service")
public interface EurekaService {

    @GetMapping("/helloworld")
    String helloworld();

}
