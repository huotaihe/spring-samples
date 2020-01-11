package com.github.huotaihe.spring.cloud.learn.consul.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceController
 *
 * @author: huotaihe
 * @Date: 12:44 2019-10-11
 **/
@RestController
public class ServiceController {

    @GetMapping("/helloworld")
    public String helloworld() {
        return "Hello world!";
    }

}
