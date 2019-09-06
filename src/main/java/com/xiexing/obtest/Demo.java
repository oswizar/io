package com.xiexing.obtest;

import org.junit.Test;

/**
 * @date: 2019/4/1 18:05
 * @author: oswizar
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }


    @Test
    public void  rnTest() {
        System.out.print("--------------");
        System.out.print("\r");
//        System.out.print("\r");
        System.out.print("--------------");
        System.out.print("\n\n");
        System.out.print("\n\n");
//        System.out.print("--------------");
//        System.out.print("\r\n");
//        System.out.print("--------------");
    }
}