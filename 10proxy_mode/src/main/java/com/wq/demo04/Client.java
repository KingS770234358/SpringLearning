package com.wq.demo04;

import com.wq.demo02.UserService;
import com.wq.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 真实角色(房东) 接口实现类!一定得是实现类!
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        // 代理角色, 目前不存在, 使用InvocationHandler类去创建
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 传入要代理的接口实现类 设置要代理的接口实现类
        pih.setInterfaces_proxyed(userServiceImpl);
        // 动态创建生成代理类(跟接口的类型一样!!!)
        UserService proxy = (UserService)pih.getProxy();
        // 代理类代理实现被代理的真实角色的操作
        proxy.add();
        proxy.delete();

    }
}
