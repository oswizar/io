package com.oswizar.io.algorithm.bitoperation;

import java.util.Arrays;

public class SingleNumber3 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    /**
     * 260.给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
     *
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rightOne = xor & -xor;
        int temp = xor;
        for (int num : nums) {
            if ((num & rightOne) == rightOne) {
                temp ^= num;
            }
        }
        return new int[]{temp, temp ^ xor};
    }
}
