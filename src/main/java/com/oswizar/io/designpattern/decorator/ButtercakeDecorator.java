package com.oswizar.io.designpattern.decorator;

public class ButtercakeDecorator extends Buttercake{

    Buttercake buttercake;

    public ButtercakeDecorator(Buttercake buttercake) {
        this.buttercake = buttercake;
    }

    @Override
    public String getDesc() {
        return this.buttercake.getDesc();
    }

    @Override
    public int getPrice() {
        return this.buttercake.getPrice();
    }
}
