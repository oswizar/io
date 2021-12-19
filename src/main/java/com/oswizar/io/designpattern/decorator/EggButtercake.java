package com.oswizar.io.designpattern.decorator;

public class EggButtercake extends ButtercakeDecorator{


    public EggButtercake(Buttercake buttercake) {
        super(buttercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "1个鸡蛋" ;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
