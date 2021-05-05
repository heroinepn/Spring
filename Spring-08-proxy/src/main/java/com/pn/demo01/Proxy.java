package com.pn.demo01;

public class Proxy implements Rent{
    //组合
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
        seeHouse();
        sign();
        fee();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带着看房子！");
    }

    //签合同
    public void sign(){
        System.out.println("和中介签署租赁合同！");
    }

    //收费用
    public void fee(){
        System.out.println("中介收取费用！");
    }
}

