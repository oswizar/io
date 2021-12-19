package com.oswizar.io.designpattern.decorator;

public class BaseButtercake extends Buttercake{
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
