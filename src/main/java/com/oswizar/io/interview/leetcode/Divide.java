package com.oswizar.io.interview.leetcode;

public class Divide {

    public static void main(String[] args) {
        int divide = new Divide().divide(-2147483648, -1);
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        int flag = 0;
        long dividend1 = dividend, divisor1 = divisor;
        if (dividend < 0) {
            flag++;
            dividend1 = Math.abs(dividend1);
        }
        if (divisor < 0) {
            flag++;
            divisor1 = Math.abs(divisor1);
        }
        long ans = 0, tmp = dividend1;
        while (tmp >= divisor1) {
            tmp = tmp - divisor1;
            ans++;
        }
        if (flag == 1) {
            ans = -ans;
        }
        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        if (ans < Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        }
        return (int) ans;
    }
}
