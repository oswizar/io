package com.oswizar.io.algorithm.bitoperation;

public class BinaryNumber {

    public static void main(String[] args) {
        printBinaryString(-10);
        System.out.println();
        System.out.println(Integer.toBinaryString(-10));
    }

    public static void printBinaryString(int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            System.out.print(bit);
        }
    }
}
