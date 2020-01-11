package com.github.huotaihe.spring.cloud.learn.git.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author: huotaihe
 * @Date: 17:26 2019-11-15
 **/
@RestController
@Slf4j
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/user")
    public String user(){

        log.info("user info {}", user);

        return "";

    }

}
