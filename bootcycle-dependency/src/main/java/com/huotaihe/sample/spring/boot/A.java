package com.huotaihe.sample.spring.boot;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @author 寒溪
 * @date 2021/05/28
 */
@Component
public class A {

    @Resource
    private B b;

}
