package com.github.huotaihe.spring.cloud.learn.console.terbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class ConsoleTerbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleTerbonApplication.class, args);
    }

}
