package com.github.huotaihe.springboot.learn.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author: huotaihe
 * @Date: 10:25 2019-12-05
 **/
@RestController
public class HelloController {

    @GetMapping(value = "/value")
    public HelloDomain hello(){
        return new HelloDomain("Nine", 10);
    }
}
