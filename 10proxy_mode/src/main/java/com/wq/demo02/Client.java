package com.wq.demo02;

public class Client {
    public static void main(String[] args) {
        // 普通方式
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.add();
        System.out.println("以下通过代理模式实现");
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        // 通过这步 可以代理任务实现了服务接口的类
        userServiceProxy.setUserServiceImpl(userServiceImpl);
        userServiceProxy.select();
    }
}
