package com.wq.diy;

/***
 * 自定义的切面类
 * 包含切面
 * */
public class DiyPointCut {
    // 前置切面 前置切面设置时需要引用该方法名
    public void before_PointCut_Advice(){
        System.out.println("==方法(切入点)执行前==");
    }
    // 后置切面 后置切面设置时需要引用该方法名
    public void after_PointCut_Advice(){
        System.out.println("==方法(切入点)执行后==");
    }
}
