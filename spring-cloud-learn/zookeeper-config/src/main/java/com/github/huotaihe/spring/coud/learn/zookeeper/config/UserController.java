package com.github.huotaihe.spring.coud.learn.zookeeper.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author: huotaihe
 * @Date: 13:09 2019-11-19
 **/
@RestController
@Slf4j
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/user")
    public String user(){

        log.info("username:{}", user.getName());

        return user.getName();

    }

}
