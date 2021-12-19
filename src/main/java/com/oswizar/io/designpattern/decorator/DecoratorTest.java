package com.oswizar.io.designpattern.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Buttercake buttercake = new BaseButtercake();
        System.out.println(buttercake.getDesc() + " 总价：" + buttercake.getPrice());

        buttercake = new EggButtercake(buttercake);
        buttercake = new EggButtercake(buttercake);
        buttercake = new SausageButtercake(buttercake);

        System.out.println(buttercake.getDesc() + " 总价：" + buttercake.getPrice());

    }
}
