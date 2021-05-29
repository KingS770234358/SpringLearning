package com.wq.demo02;

public class UserServiceProxy implements UserService{

    // 创建所代理的那个真实角色
    private UserServiceImpl userServiceImpl;
    // 用set方法注入对象
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void add() {
        log("add");
        userServiceImpl.add();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceImpl.delete();
    }

    @Override
    public void update() {
        log("update");
        userServiceImpl.update();
    }

    @Override
    public void select() {
        log("select");
        userServiceImpl.select();
    }

    // 实现需求:增加一个日志方法
    public void log(String msg){
        System.out.println("调用了"+msg+"方法");
    }
}
