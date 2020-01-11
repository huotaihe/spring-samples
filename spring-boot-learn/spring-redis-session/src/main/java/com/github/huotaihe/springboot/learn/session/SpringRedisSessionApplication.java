package com.github.huotaihe.springboot.learn.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableRedisHttpSession
@SpringBootApplication
public class SpringRedisSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisSessionApplication.class, args);
    }

}
