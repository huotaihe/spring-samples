package com.github.huotaihe.springboot.learn.prsd;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName CacheKeyGenerator
 * @Author huotaihe
 * @Date 2018/9/20 10:38
 * @Version 1.0
 **/
public interface CacheKeyGenerator {

  /**
   * 获取AOP参数,生成指定缓存Key
   *
   * @param pjp PJP
   * @return 缓存KEY
   */
  String getLockKey(ProceedingJoinPoint pjp);
}