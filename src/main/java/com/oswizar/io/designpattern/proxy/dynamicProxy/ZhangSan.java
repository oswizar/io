package com.oswizar.io.designpattern.proxy.dynamicProxy;

public class ZhangSan implements IUser{

    @Override
    public void findLove() {
        System.out.println("ZhangSan要求：肤白貌美大长腿");
    }

    @Override
    public void buyInsurance() {
        System.out.println("ZhangSan买保险200万");
    }

}
