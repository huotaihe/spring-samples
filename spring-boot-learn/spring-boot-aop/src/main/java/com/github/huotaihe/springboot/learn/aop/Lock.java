package com.github.huotaihe.springboot.learn.aop;

import java.lang.annotation.*;

/**
 * Lock
 *
 * @author: huotaihe
 * @Date: 15:11 2019-09-24
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Lock {
}
