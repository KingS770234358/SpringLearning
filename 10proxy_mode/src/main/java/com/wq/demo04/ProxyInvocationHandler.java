package com.wq.demo04;
// 要引对包
import com.wq.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用这个类自动生成 代理类
 */
// 1.要实现InvocationHandler接口
public class ProxyInvocationHandler implements InvocationHandler {

    // 第二个参数:被代理的接口(实现类)
    // private Rent rent; // 写死的 让它变成活的
    private Object interfacesImpl_proxyed; // interfaces_proxyed被代理的接口(实现类)

    public void setInterfaces_proxyed(Object interfaces_proxyed) {
        this.interfacesImpl_proxyed = interfaces_proxyed;
    }

    // Proxy类创建代理实例
    public Object getProxy(){
        // newProxyInstance 创建代理实例 需要三个参数
        // 第一个参数:实现InvocationHandler接口的类的ClassLoader
        // 第二个参数:被代理的接口实现类对应的接口(实现类)
        // 第三个参数:实现InvocationHandler接口的类
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), interfacesImpl_proxyed.getClass().getInterfaces(), this);
    }

    // 处理代理实例, 并返回结果
    // 动态创建代理实例的时候 传入了ProxyInvocationHandler
    // 因此动态代理实例底层能够使用 ProxyInvocationHandler的invoke方法
    @Override
    public Object invoke(Object Proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质,就是使用反射机制实现
        // 传入一个接口(实现类) 和 参数 执行真实角色(房东)的方法
        // method代表接口实现类里面的任意的方法 proxy.rent();
        Object result = method.invoke(interfacesImpl_proxyed, args);

        // 新增日志功能 通过method 获得 method的名字
        log(method.getName());
        return result;
    }

    // 代理附属操作
    // 增加日志功能
    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
//    public void fare(){
//        System.out.println("代理收客户中介费");
//    }
//    public void sign_tenancyContract(){
//        System.out.println("代理跟客户签合约");
//    }
}
