package com.github.huotaihe.springboot.learn.spring.boot.redis.sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootRedisSentinelApplication implements ApplicationRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisSentinelApplication.class, args);


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisTemplate.opsForValue().set("hello1", "world!");
    }
}
