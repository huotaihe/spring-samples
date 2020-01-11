package com.github.huotaihe.springboot.learn.swagger2;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class SpringBootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger2Application.class, args);
	}
}
