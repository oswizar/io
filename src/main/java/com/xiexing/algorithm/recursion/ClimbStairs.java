package com.xiexing.algorithm.recursion;

import org.junit.Test;

import java.util.List;

public class ClimbStairs {

    @Test
    public void show() {
        System.out.println(climbStairs(45));

        Integer a = new Integer(1456);
        int b = 1456;
        String aaa = "ddddd";
        char[] chars = aaa.toCharArray();
        int[] bbb = new int[] {1,3,6,5};
        System.out.println(bbb);
        System.out.println(chars);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    /**
     * 其实就是Fibonacci数列
     */
    public int climbStairs(int n) {
        int[] item = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < 3) {
                item[i] = i;
            } else {
                item[i] = item[i - 1] + item[i - 2];
            }
        }
        return item[n];
    }
}
