package com.github.huotaihe.spring.cloud.learn.resilience.consule.consumer;

import com.github.huotaihe.spring.cloud.learn.resilience.consule.consumer.intergation.HelloService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author: huotaihe
 * @Date: 13:03 2019-11-06
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    private CircuitBreaker circuitBreaker;

    public HelloController(CircuitBreakerRegistry registry) {

        circuitBreaker = registry.circuitBreaker("hello");
    }

    @GetMapping("/hello")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "hello")
    public String hello(){
        return helloService.helloworld();
    }

    @GetMapping("/hello2")
    public String hello2(){
        return Try.ofSupplier(CircuitBreaker.decorateSupplier(circuitBreaker, () -> helloService.helloworld()))
                .recover(CircuitBreakerOpenException.class, "fail").get();
    }
}
