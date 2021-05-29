package com.wq.mapper;

import com.wq.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 使用Spring注入的方式设置Mybatis变成面向对象
 * 写 *MapperImpl.java类来实现Sql语句
 * 原来所有操作,都是用sqlSession执行
 * 现在都是用sqlSessionTemplate执行
 * ============>写完这个类在通过注入的方式放到Spring容器里
 * */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    /***
     * 定义一组事务 我们希望它们要么都成功 要么都失败
     * 这样自定义一组事务,[也要在接口里定义!!!]
     */
    public List<User> transaction(){
        User user = new User(44, "下个", "2222111");
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        userMapper.addUser(user);
        userMapper.deleteUser(6);
        return userMapper.selectUsers();
    }

    @Override
    public List<User> selectUsers() {
        return getSqlSession().getMapper(UserMapper.class).selectUsers();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
