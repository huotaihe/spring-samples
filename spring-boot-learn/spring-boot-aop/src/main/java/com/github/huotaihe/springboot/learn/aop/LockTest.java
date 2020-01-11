package com.github.huotaihe.springboot.learn.aop;

import org.springframework.stereotype.Service;

/**
 * LockTest
 *
 * @author: huotaihe
 * @Date: 15:14 2019-09-24
 **/
@Service
public class LockTest {
    @Lock
    public void testLock(){
        System.out.println("Enter");
    }
}
