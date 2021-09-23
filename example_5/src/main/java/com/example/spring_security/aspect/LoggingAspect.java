package com.example.spring_security.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(com.example.spring_security.controllers..*)")
    public void methodsToBeProfiled() { }

    @After("methodsToBeProfiled()")
    public void logTimeAndMethod(JoinPoint jp) {
        System.out.println(jp.getSignature().toString());
    }
}
