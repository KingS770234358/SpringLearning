package com.wq.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 方式三:使用注解实现AOP
 *
 */
@Aspect // 注解标注他是一个切面类
public class AnnotationPointCut {
/*
     标注他是前置advice方法
     注意不要导包导成junit中的before
     before的参数就是切入点表达式 "execution(* com.wq.service.UserServiceImpl.*(..))"
 */
    @Before("execution(* com.wq.service.UserServiceImpl.*(..))")
    public void before_pointcut_advice(){
        /**
         * 执行顺序第2位
         */
        System.out.println("==方法(切入点)执行前AnnotationPointCut==");
    }
    @After("execution(* com.wq.service.UserServiceImpl.*(..))")
    public void after_pointcut_advice(){
        /**
         * 执行顺序第5位
         */
        System.out.println("==方法(切入点)执行后AnnotationPointCut==");
    }

    // 在环绕增强中, 可以给定一个advice的参数, 代表获取处理的切入点
    @Around("execution(* com.wq.service.UserServiceImpl.*(..))")
    public void around_pointcut_advice(ProceedingJoinPoint jp) throws Throwable {
        /**
         * 执行顺序第1位
         */
        System.out.println("==AnnotationPointCut : 环绕前==");



        /**
         * 执行顺序第3位
         */
        // 切入点执行(这里需要抛出异常)
        Object process = jp.proceed();
        /**
         * 执行顺序第4位
         */
        System.out.println("==AnnotationPointCut : 环绕后==");

        // 切入点执行返回的结果
        System.out.println("切入点执行返回的结果"+process);
        // 获得签名
        Signature signature = jp.getSignature();
        // 就是调用的抽象接口的方法的信息
        System.out.println("连接点的签名"+signature);

    }
}
