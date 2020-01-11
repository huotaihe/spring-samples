package com.github.huotaihe.spring.cloud.learn.hystrix.consul.consumer;

import com.github.huotaihe.spring.cloud.learn.hystrix.consul.consumer.intergation.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * DemoController
 *
 * @author: huotaihe
 * @Date: 21:54 2019-10-22
 **/
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    @GetMapping("/helloworld")
    @HystrixCommand(fallbackMethod = "fallback")
    public String helloworld() {


        String result = restTemplate.getForEntity("http://consul-service/helloworld", String.class).getBody();
        return result;

    }

    @GetMapping("/helloworld2")
    public String hellworldFeign() {
        return helloService.helloworld();
    }

    public String fallback() {
        return "abc";
    }

}
