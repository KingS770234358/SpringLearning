package com.wq.demo03;

/**
 * ·真实的角色:被代理的角色(房东)
 * 实现租房接口
 */
public class Host implements Rent {

    public void rent() {
        System.out.println("房东要出租房子");
    }
}
