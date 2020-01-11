package com.github.huotaihe.springboot.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * LockAspect
 *
 * @author: huotaihe
 * @Date: 14:59 2019-09-24
 **/
@Aspect
@Configuration
public class LockAspect {

    @Around("execution(public * *(..)) && @annotation(com.github.huotaihe.springboot.learn.aop.Lock)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        return pjp.proceed();

    }

}
