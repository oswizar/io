package com.oswizar.io.interview.leetcode;

public class Sqrt {
    public static void main(String[] args) {
        // 注意溢出和边界数据 0, 1
        int i = new Sqrt().mySqrt2(0);
        System.out.println(i);
    }

    // 暴力解法
    public int mySqrt(int x) {
        for (long i = 0; ; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return (int) i;
            }
        }
    }

    // 二分查找
    public int mySqrt1(int x) {
        int l = 0, r = x, mid, ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // 二分查找(消除long)
    public int mySqrt2(int x) {
        int l = 1, r = x, mid, ans = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
