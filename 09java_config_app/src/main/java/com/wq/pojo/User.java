package com.wq.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
* 实体类
* */
// @Component 这个类被Spring接管了 注册到了IoC容器中
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }
    // 属性注入值
    @Value("王强啊")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
