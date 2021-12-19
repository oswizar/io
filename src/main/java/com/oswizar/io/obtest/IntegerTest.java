package com.oswizar.io.obtest;

import org.junit.Test;

/**
 * @date: 2019/5/20 11:32
 * @author: oswizar
 * @description:
 */
public class IntegerTest {

    @Test
    public void printInt() {
        System.out.println("int的最大值为: " + Integer.MAX_VALUE);
        System.out.println("2的30次方等于: " + (int)Math.pow(2,30));
        System.out.println("2的31次方等于: " + (int)Math.pow(2,31));
        System.out.println("2的32次方等于: " + (int)Math.pow(2,32));
        System.out.println("2的33次方等于: " + (int)Math.pow(2,33));
        System.out.println("1<<30: " + (1<<30));
        System.out.println("1<<31: " + (1<<31));

    }



    @Test
    public void tableSizeFor() {
        int n = 16 - 1;
        System.out.println(n |= n >>> 1);
        System.out.println(n |= n >>> 2);
        System.out.println(n |= n >>> 4);
        System.out.println(n |= n >>> 8);
        System.out.println(n |= n >>> 16);
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }






}
