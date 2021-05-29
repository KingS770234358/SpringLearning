package com.wq.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.lang.Nullable;
// 是javax是属于扩展库中，手动下载 配置maven依赖
import javax.annotation.Resource;

public class People {
    private String name;
    /*
         1.beans.xml文件中已经有 dog 和 cat的话 就可以Autowired自动装配
         本质就是按照 【byName】【byType】 方式注入
         如果id没有符合条件的,就按照类型唯一注入,当类型也不唯一时报错
         2.点击行号可以跳转到beans.xml文件中对应的bean创建位置
         3.Autowired也可以放在dog和cat的set方法上
         使用Autowired方法后 可以不写dog cat的set方法
         4.(required = false)意味着传入的值允许为空 即使为空也不会错 默认是true
         @Autowired(required = false)
         5.当xml文件中Dog类型的bean不唯一(有多个)的时候 需要配合Qualifier来指定注入哪个bean
         否则会报错
    */
    // 使用javax的Resource注解进行对象注入
    // 当xml中的Dog bean有多个时要指明使用哪个bean
    // 否则报错 NoUniqueBeanDefinitionException
//    @Resource(name="dog2")
//    private Dog dog;
//    @Autowired
//    private Cat cat;

    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

//    // @Nullable允许传入的参数为空
//    public People(@Nullable String name){
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
