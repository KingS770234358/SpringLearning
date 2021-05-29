package com.wq.mapper;

import com.wq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> selectUsers();
    // 查询不需要提交事务

    // 添加一个用户
    public int addUser(User user);

    // 删除一个用户
    public int deleteUser(@Param("id") int id);

    // 自定义的一组业(事务)
    public List<User> transaction();

}
