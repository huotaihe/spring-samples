package com.huotaihe.sample.spring.boot.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒溪
 * @date 2021/07/14
 */
@RestController
public class DemoController {

    @GetMapping(value = "/helloworld")
    @Lock
    public String helloworld(){
        return "hello world!";
    }

}
