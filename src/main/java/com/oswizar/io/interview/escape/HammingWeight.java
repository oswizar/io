package com.oswizar.io.interview.escape;

public class HammingWeight {

    // 00000000000000000000000000001011
    // 11111111111111111111111111111101
    public static void main(String[] args) {

        int i = new HammingWeight().hammingWeight(128);
        System.out.println(i);

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            // n & (n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0
            // 如:6(110) & (6 - 1) = 4(100),运算结果 4 即为把 6 的二进制位中的最低位的 1 变为 0
            n &= n - 1;
            result++;
        }
        return result;
    }

//    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((n & 1) == 1) {
//                result++;
//            }
//            n >>>= 1;
//        }
//        return result;
//    }


}

