package com.huotaihe.springboot.learn.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringBootOauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauthServerApplication.class, args);
    }

}
