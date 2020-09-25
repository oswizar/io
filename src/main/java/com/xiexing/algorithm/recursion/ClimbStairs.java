package com.xiexing.algorithm.recursion;

import org.junit.Test;

public class ClimbStairs {

    @Test
    public void show() {
        System.out.println(climbStairs(45));
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
