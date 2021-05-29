package com.wq.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/***
 * 实现切入点的前置切面Advice
 * 在切入点执行之前执行
 */
public class Log implements MethodBeforeAdvice {
    @Override
    /**
     * method:要执行的目标对象的方法
     * object:参数
     * target:目标对象 被通知对象(就是一个接口 一个方法(房东))
     * */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"开始执行");
    }
}
