package com.example.spring_security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("within(com.example.spring_security.*.*)")
    public void methodsToBeProfiled() { }

    @Around("methodsToBeProfiled()")
    public void logTimeAndMethod(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        pjp.proceed();

        System.out.println(pjp.getSignature());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
