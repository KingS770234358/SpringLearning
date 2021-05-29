package com.wq.demo03;

public class Client {
    public static void main(String[] args) {
        // 真实角色(房东)接口的实现
        Host host = new Host();

        // 代理角色 目前没有
        // 要使用InvocationHandler生成
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用处理程序来处理要调用的接口对象！
        pih.setRent(host);
        // InvocationHandler动态生成host对象的代理实例
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();

    }
}
