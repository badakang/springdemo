package com.acorp.springdemo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.acorp.springdemo.controller.UserController.*(..))")
    public Object setLog(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable {
        System.out.println("실행시작 : "
                        + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "."
                +proceedingJoinPoint.getSignature().getName());

        long startMillis = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long executionMillis = System.currentTimeMillis()- startMillis;
        System.out.println("실행 완료: " + executionMillis + "밀리초 소요됨 :"
                + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "."
                + proceedingJoinPoint.getSignature().getName());

        return result;
    }

    @Before("execution(* com.acorp.springdemo.service.*.get*(..))")
    public void logger() {
        System.out.println("logger test befor service methods");
    }
}
