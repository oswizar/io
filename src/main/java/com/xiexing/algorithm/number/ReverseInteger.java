package com.xiexing.algorithm.number;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test() {
        System.out.println(reverse(-1299999999));
    }


    /**
     * 7. 整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            // 取余并计算反转后的新数
            rev = rev * 10 + x % 10;
            // 边界控制
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) rev;
    }

}
