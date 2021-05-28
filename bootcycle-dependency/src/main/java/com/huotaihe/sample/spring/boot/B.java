package com.huotaihe.sample.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 寒溪
 * @date 2021/05/28
 */
@Component
public class B {

    @Autowired
    private A a;
}
