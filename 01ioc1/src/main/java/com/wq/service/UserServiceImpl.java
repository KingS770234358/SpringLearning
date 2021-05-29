package com.wq.service;

import com.wq.dao.UserDao;
import com.wq.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
/*
    // 【DAO层】接口类型声明 = new 【DAO层】接口具体的接口实现类构造函数
    private UserDao userDao = new UserDaoImpl();
*/
    // 先声明要使用的DAO层接口
    private UserDao userDao;
    // 利用set方法动态传入DAO层的接口实现类来实现这个接口[注入！！！]
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void getUser() {
        userDao.getUser();
    }
}
