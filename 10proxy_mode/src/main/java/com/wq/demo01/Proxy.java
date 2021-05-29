package com.wq.demo01;

/***
 * ·代理角色:代理真实的角色,代理真实角色后,一般会做一些附属操作(中介)
 * 代理类也要实现 Rent接口
 */
public class Proxy implements Rent{
    // 代理去拿到房东
    private Host host;

    // Generate --> Constructor --> select None
    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        //System.out.println("代理直接租房子,不是我们要的效果");
        // 下面这种是代理帮房东租房子的思路
        System.out.println("代理除了房东的租房之外 还可以完成很多任务 比如看房 收中介费 签合约 等等等等");
        seeHouse();
        System.out.println("代理调用房东的rent 帮房东租房子");
        host.rent();
        sign_tenancyContract();
        fare();
    }
    // 代理除了房东的租房之外 还可以完成很多任务 比如看房 收中介费 签合约 等等等等
    public void seeHouse(){
        System.out.println("代理带客户看房");
    }
    public void fare(){
        System.out.println("代理收客户中介费");
    }
    public void sign_tenancyContract(){
        System.out.println("代理跟客户签合约");
    }


}
