package com.oswizar.designpattern.adapter;

public class PowerAdapter implements DC {

    private final AC220 ac220V;

    public PowerAdapter(AC220 ac220V) {
        this.ac220V = ac220V;
    }


    @Override
    public int output5V() {
        int ac220 = ac220V.output();
        int dc5 = ac220 / 44;
        System.out.println("使用Adapter输入AC：" + ac220 + "V, 输出DC：" + dc5 + "V");
        return dc5;
    }

    @Override
    public int output12V() {
        int ac220 = ac220V.output();
        int dc12 = ac220 / 18;
        System.out.println("使用Adapter输入AC：" + ac220 + "V, 输出DC：" + dc12 + "V");
        return dc12;
    }
}
