package com.github.huotaihe.springboot.learn.prsl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 本地所注解
 *
 * @ClassName LocalLock
 * @Author huotaihe
 * @Date 2018/9/12 10:16
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {


  String key() default "";

  /**
   * 过期时间 TODO 由于用的 guava 暂时就忽略这属性吧 集成 redis 需要用到
   *
   */
  int expire() default 5;

}
