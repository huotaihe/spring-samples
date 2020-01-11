package com.github.huotaihe.spring.boot.learn.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.java2d.cmm.Profile;

@SpringBootApplication
public class SpringBootProfileApplication implements ApplicationRunner {

    @Autowired
    private ProfileService profileService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProfileApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        args.containsOption("");

    }
}
