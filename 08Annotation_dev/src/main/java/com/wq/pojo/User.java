package com.wq.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于:在beans.xml中<bean id="user" class="com.wq.pojo.User"/>
// @Component 组件 左边的叶子说明已经被装配
//////////////////////////////////////////////
// 因为没有指明 id 所以 id默认是类名的全小写
//////////////////////////////////////////////
@Component
@Scope(scopeName="singleton")
public class User {
    // 这个为属性显式注入
    // public String name = "琴江";

    // 隐式注入
    // Value("属性值")
    // 相当于:在beans.xml中<property name="name" value="kuangshen"/>
    public String name;
    public String getName() {
        return name;
    }
    @Value("kuangshen_setName")
    public void setName(String name) {
        this.name = name;
    }
}
