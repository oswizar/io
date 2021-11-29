package com.oswizar.designpattern.decorator;

public class SausageButtercake extends ButtercakeDecorator{


    public SausageButtercake(Buttercake buttercake) {
        super(buttercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
