package com.wq.demo03;
// 要引对包
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用这个类自动生成 代理类
 */
// 1.要实现InvocationHandler接口
public class ProxyInvocationHandler implements InvocationHandler {

    // 第二个参数:被代理的接口(实现类)
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    // Proxy类创建代理实例
    public Object getProxy(){
        // newProxyInstance 创建代理实例 需要三个参数
        // 第一个参数:实现InvocationHandler接口的类的ClassLoader
        // 第二个参数:被代理的接口实现类对应的接口(实现类)
        // 第三个参数:实现InvocationHandler接口的类
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    // 处理代理实例, 并返回结果
    @Override
    public Object invoke(Object Proxy, Method method, Object[] args) throws Throwable {
        // 加入代理的附属操作
        seeHouse();

        // 动态代理的本质,就是使用反射机制实现
        // 传入一个接口实现类 和 参数 执行真实角色(房东)的方法
        // method代表接口(实现类)里面的任意的方法 proxy.rent();
        Object result = method.invoke(rent, args);

        // 加入代理的附属操作
        sign_tenancyContract();
        fare();

        return result;
    }

    // 代理附属操作
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void fare(){
        System.out.println("代理收客户中介费");
    }
    public void sign_tenancyContract(){
        System.out.println("代理跟客户签合约");
    }
}
