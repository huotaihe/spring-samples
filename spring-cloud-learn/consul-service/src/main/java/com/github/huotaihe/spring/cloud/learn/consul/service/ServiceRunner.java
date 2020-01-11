package com.github.huotaihe.spring.cloud.learn.consul.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Component;

/**
 * ServiceRunner
 *
 * @author: huotaihe
 * @Date: 22:01 2019-10-19
 **/
@Component
@Slf4j
public class ServiceRunner implements ApplicationRunner {

    @Autowired
    private Registration registration;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("instanceId {}", registration.getInstanceId());

    }
}
