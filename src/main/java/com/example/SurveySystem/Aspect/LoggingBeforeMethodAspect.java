package com.example.SurveySystem.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingBeforeMethodAspect {
    @Pointcut("execution(public * com.example.SurveySystem.Service.*.*(..))")
    private void executeAllServiceMethods(){}

    @Before("executeAllServiceMethods()")
    public void beforeMethodAdvice(JoinPoint joinPoint){
        System.out.println("Logging before method:"+joinPoint.getSignature().getName());
    }

    @After("executeAllServiceMethods()")
    public void afterMethodAdvice(JoinPoint joinPoint){
        System.out.println("Logging after method:"+joinPoint.getSignature().getName());
    }
}
