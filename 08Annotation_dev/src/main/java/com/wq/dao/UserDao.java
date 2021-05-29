package com.wq.dao;

import org.springframework.stereotype.Repository;

// beans.xml文件设置没扫描这个包 所以没产生叶子
// 扫描就能产生叶子
@Repository
public class UserDao {
}
