package com.github.huotaihe.springboot.learn.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateDemo
 *
 * @author: huotaihe
 * @Date: 15:05 2019-09-27
 **/
@Service
public class RestTemplateDemo {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     * 通过RestTemplateBuilder 构建
     */
    public void byBuilder(){
        RestTemplate restTemplate = restTemplateBuilder.build();
    }

    /**
     * 通过 new 创建默认的RestTemplate
     */
    public void bynew(){
        RestTemplate restTemplate = new RestTemplate();
    }

}
