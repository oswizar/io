package com.oswizar.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

public class PlusOne {


    @Test
    public void show() {
        /**
         * [9,8,7,6,5,4,3,2,1,0]
         * [1,2,8,6,6,0,8,6,1,9]
         * [9,8,7,6,5,4,3,2,1,1]
         */
        int[] array = {9, 8, 7, 6, 5, 4, 3, 9, 9, 9};
        System.out.println(Arrays.toString(array));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Arrays.toString(plusOne(array)));
    }

    /**
     * 从后往前遍历数组
     * (1)如果当前元素为 9，把当前元素置为 0，下一位进位(+1)
     * (2)如果当前元素小于9，直接加一并返回原数组
     * (3)如果每一位都进位，新建数组，长度为原数组长+1，把第一位置为1即可，后面的元素自动初始化为0
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }
}
