package com.oswizar.io.sample;

import java.io.FileInputStream;

public class VarTest extends Parent {
    private String name = "Var";

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(0b11);
        System.out.println(0123);
        System.out.println(0xf34);

//        FileInputStream fi = new FileInputStream("/Users/oswizar/Temp/my.cnfff");
//        byte[] buffer = new byte[1024];

    }

}


class Parent {
    private String name = "Parent";

    public String getName() {
        return name;
    }
}