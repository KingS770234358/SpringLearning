package com.wq.dao;

/**
 *  定义了一个接口 就要有其对应的实现类
 *  这是 UserDao 接口的实现类
 */
public class UserDaoImpl implements UserDao{
    public void getUser(){
        System.out.println("默认获取用户的数据");
    }
}
