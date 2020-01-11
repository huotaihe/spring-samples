package com.github.huotaihe.springboot.learn.prsd;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName CacheParam
 * @Author huotaihe
 * @Date 2018/9/20 10:38
 * @Version 1.0
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParam {

  /**
   * 字段名称
   *
   * @return String
   */
  String name() default "";
}

