package com.wq.mapper;

import com.wq.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
/**
 * 使用Spring注入的方式设置Mybatis变成面向对象
 * 写 *MapperImpl.java类来实现Sql语句
 * 原来所有操作,都是用sqlSession执行
 * 现在都是用sqlSessionTemplate执行
 * ============>写完这个类在通过注入的方式放到Spring容器里
 * */
public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUsers();
        return userList;
    }
}
