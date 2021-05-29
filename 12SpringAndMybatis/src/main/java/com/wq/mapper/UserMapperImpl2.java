package com.wq.mapper;

import com.wq.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/***
 * 上一个方法是通过将SqlSessionTemplate注入UserMapperImpl中得到的SqlSessionTemplate
 *
 * SqlSessionDaoSupport抽象支持类
 * SqlSessionDaoSupport类可以提供SqlSession,调用getSession()方法返回一个SqlSessionTemplate
 * extends要写在implements前面啊...
 * 继承SqlSessionDaoSupport类 直接getSession()就可以得到一个SqlSessionTemplate
 * 这样就不需要注入了SqlSessionTemplate了,但是SqlSessionDaoSupport类需要注入[sqlSessionFactory]
 *
 * 更简化的使用插件: Mybatis-plus  通用mapper
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUsers() {
        SqlSession sqlSession =  getSqlSession();
        UserMapper umapper = sqlSession.getMapper(UserMapper.class);
        return umapper.selectUsers();
    }
}
