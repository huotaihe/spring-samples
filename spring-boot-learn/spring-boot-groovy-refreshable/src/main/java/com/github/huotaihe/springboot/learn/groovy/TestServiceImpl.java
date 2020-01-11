package com.github.huotaihe.springboot.learn.groovy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestServiceImpl
 * @Author huotaihe
 * @Date 2018/9/14 16:20
 * @Version 1.0
 **/
@Slf4j
@Service
public class TestServiceImpl implements TestService {

  @Override
  public void test() {
    log.info("=============haha");
  }
}
