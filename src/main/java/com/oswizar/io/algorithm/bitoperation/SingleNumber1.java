package com.oswizar.io.algorithm.bitoperation;

public class SingleNumber1 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
        System.out.println(singleNumber(arr));
    }


    /**
     * 136.给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
