package com.github.huotaihe.spring.cloud.learn.bulkhead;

import com.github.huotaihe.spring.cloud.learn.bulkhead.intergation.HelloService;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
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

    private Bulkhead bulkhead;

    public HelloController(CircuitBreakerRegistry registry, BulkheadRegistry bulkheadRegistry) {

        circuitBreaker = registry.circuitBreaker("hello");
        this.bulkhead = bulkheadRegistry.bulkhead("hello");
    }

    @GetMapping("/hello")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "hello")
    @io.github.resilience4j.bulkhead.annotation.Bulkhead(name = "hello2")
    public String hello(){
        return helloService.helloworld();
    }

    @GetMapping("/hello2")
    public String hello2(){
        return Try.ofSupplier(Bulkhead.decorateSupplier(bulkhead, CircuitBreaker.decorateSupplier(circuitBreaker, () -> helloService.helloworld())))
                .recover(CircuitBreakerOpenException.class, "fail")
                .recover(BulkheadFullException.class, "full")
                .get();
    }
}
