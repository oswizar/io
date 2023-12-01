package com.oswizar.io.algorithm.bitoperation;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE / -67);
        System.out.println("=======================");
        int ans = divide(Integer.MIN_VALUE, -67);
        System.out.println(ans);

    }

    private static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    private static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    private static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    private static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            } else {
                int q = div(add(a, 1), b);
                return add(q, div(minus(a, multiply(b, q)), b));
            }
        } else {
            return div(a, b);
        }
    }

    private static int div(int a, int b) {
        int x = a > 0 ? a : add(~a, 1);
        int y = b > 0 ? b : add(~b, 1);
        int q = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                q |= 1 << i;
                x = minus(x, y << i);
            }
        }
        if ((a ^ b) < 0) {
            q = add(~q, 1);
        }
        return q;
    }
}
