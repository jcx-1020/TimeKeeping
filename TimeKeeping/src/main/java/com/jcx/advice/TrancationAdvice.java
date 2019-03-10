package com.jcx.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TrancationAdvice {

    private static double start;
    private static double end;

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void before() {
        start = System.nanoTime();
    }

    @After("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void after() {
        end = System.nanoTime();
        System.out.println(end - start);
    }

    @Around("within(com.jcx.service.TestServiceTarget)")
    public Object transaction(ProceedingJoinPoint pjp) {
        System.out.println("事务开始");
        Object obj= null;
        try {

            obj = pjp.proceed();

            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }
        return obj;
    }
}
