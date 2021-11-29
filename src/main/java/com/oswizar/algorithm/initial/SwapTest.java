package com.oswizar.algorithm.initial;

public class SwapTest {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        String j = "a";
        String k = "b";


        // 可能会溢出
//        a = a + b;
//        b = a - b;
//        a = a - b;



        // 不用担心溢出
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);




    }
}
