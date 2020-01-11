package com.github.huotaihe.springboot.learn.refresh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class HotRefreshConfigApplication {

    @Value("${user1.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(HotRefreshConfigApplication.class, args);
    }

    @GetMapping("/name")
    public String getName(){
        return name;
    }

}
