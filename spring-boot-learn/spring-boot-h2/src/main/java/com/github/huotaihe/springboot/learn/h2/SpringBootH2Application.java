package com.github.huotaihe.springboot.learn.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class SpringBootH2Application {


    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootH2Application.class, args);
    }

}
