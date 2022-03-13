package com.huotaihe.sample.spring.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @author 寒溪
 * @date 2021/07/14
 */
@Aspect
@Configuration
@Slf4j
public class Aop {

    @Around(value = "@annotation(com.huotaihe.sample.spring.boot.aop.Lock)")
    public void around(){

        log.info("around");

    }

}
