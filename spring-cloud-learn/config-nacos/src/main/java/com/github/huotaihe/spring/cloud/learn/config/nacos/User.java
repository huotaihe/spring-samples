package com.github.huotaihe.spring.cloud.learn.config.nacos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * User
 *
 * @author: huotaihe
 * @Date: 20:52 2019-11-14
 **/
@ConfigurationProperties("user1")
@RefreshScope
@Data
@Component
public class User implements Serializable {

    private String name = "test";

    private int age = 1;

}
