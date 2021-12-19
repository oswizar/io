package com.oswizar.io.designpattern.proxy.dynamicProxy;

public class LiSi implements IUser{

    @Override
    public void findLove() {
        System.out.println("LiSi要求：有车有房学历高");
    }

    @Override
    public void buyInsurance() {
        System.out.println("LiSi买保险100万");
    }
}
