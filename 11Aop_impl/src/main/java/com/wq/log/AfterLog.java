package com.wq.log;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;
/***
 * 实现切入点的后置切面Advice
 * 在切入点返回值之后执行
 */
public class AfterLog implements AfterReturningAdvice {
    @Override
    /**
     * returnValue 返回值
     * */
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了"+target.getClass().getName()+"的"+method.getName()+"方法");
        // 这里是一个返回类型为空的方法 所以输出null
        System.out.println("返回值:"+returnValue);

    }
}
