package com.wq.config;

import com.wq.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 原来只是一个普通的java类 === > 配置类
 Configuration点进去看 本质上也是一种Component 被Spring容器托管 注册到容器中
 @Configuration代表该类是一个配置类,相当于beans.xml
 可以做beans.xml能做的所有事情 1 2 3 4
*/
@Configuration
// 1.扫描指定包下的所有组件(点击左侧行号上的放大镜可见)
@ComponentScan("com.wq")
// 3.合并两个配置文件
@Import(MyConfig2.class)
public class MyConfig {

    /**
     * 2.注册一个bean,相当于
     * <bean id="返回类的方法名" class="方法的返回值">
     *     <property name="属性" value="属性值"/>
     * </bean>
     * <bean id="getUser" class="com.wq.pojo.User">
     *     <property name="name" value="王强啊"/>
     * </bean>
     * */
    @Bean
    // 方法名:bean的id
    public User getUser(){
        // 要注入到bean的对象
        return new User();
    }
}
