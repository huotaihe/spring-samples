package com.github.huotaihe.springboot.learn.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopApplication implements ApplicationRunner {

    @Autowired
    private LockTest lockTest;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        lockTest.testLock();
    }
}
