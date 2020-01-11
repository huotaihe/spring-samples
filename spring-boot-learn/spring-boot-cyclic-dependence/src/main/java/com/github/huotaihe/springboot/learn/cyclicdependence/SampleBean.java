package com.github.huotaihe.springboot.learn.cyclicdependence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SampleBean
 *
 * @author: huotaihe
 * @Date: 18:49 2019-09-11
 **/
@Service
public class SampleBean {

    private final static Logger log = LoggerFactory.getLogger(SampleBean.class);

    @Autowired
    private SampleBean sampleBean;

    public void test(){

        log.info("test...");
    }

    public void test2(){
        log.info("test2 ....");

        sampleBean.test();
    }

}
