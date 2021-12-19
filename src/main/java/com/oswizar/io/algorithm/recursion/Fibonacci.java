package com.oswizar.io.algorithm.recursion;

import org.junit.Test;

public class Fibonacci {


    @Test
    public void show() {
//        int s = fib(54);
        int s = fibForDP(57);
        System.out.println(s);


    }


    /**
     * 1 1 2 3 5 8 13
     * 当n为50时，严重超时，计算所需大约(3m23s205ms)
     * leetcode 提交超时
     */

//    public int fib(int n) {
//        if (n < 0) {
//            return 0;
//        } else if (n == 0 || n == 1) {
//            return n;
//        } else {
//            return (fib(n - 1) + fib(n - 2)) % 1000000007;
//        }
//    }


    /**
     * 面试题10- I. 斐波那契数列(目前完美版本)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            int f1 = 0, f2 = 1;
            for (int i = 1; i < n; i++) {
                int temp = (f1 + f2) % 1000000007;
                f1 = f2;
                f2 = temp;
            }
            return f2;
        }
    }


    /**
     * 动态规划版本(现学现用)
     *
     * @param n
     * @return
     */
    public int fibForDP(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            int[] arrays = new int[n + 1];
            arrays[0] = 0;
            arrays[1] = 1;

            for (int i = 2; i <= n; i++) {
                arrays[i] = (arrays[i - 1] + arrays[i - 2]) % 1000000007;
            }
            return arrays[n];
        }
    }

}


