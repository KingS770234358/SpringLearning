package com.wq.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 * ·客户:访问代理对象的人(需要房子的人)
 */
public class Client {
    public static void main(String args[]){
        // 客户找一个房东
        // 房东要租房子
        Host host = new Host();
        host.rent();
        System.out.println("===================");
        // 但实际情况是 客户一般找不到房东 只能找到代理
        // 代理类要接收一个房东! 表示代理这个房东 帮房东出租房子
        Proxy proxy = new Proxy(host);
        // 这里面 中介一般会附加一些额外的操作
        // 不面对房东直接租房 而是面对中介租房
        proxy.rent();

    }
}