package com.xiexing.algorithm.array;

import org.junit.Test;

public class MaxSubArray {



    /**
     * 53. 最大子序和
     * 第一印象解法(修改版)
     */
    /**
     * 执行用时：
     * 188 ms
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 64.89%
     * 的用户
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int length = nums.length;
//        if (length < 2) {
//            return nums[0];
//        }
//        // 全局最大值
//        int max = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            // 局部最大值(默认为当前元素值)
//            int tempMax = nums[i];
//            if (i == length - 1) {
//                return Math.max(max, nums[i]);
//            }
//            // 连续子数组的临时最大值
//            int temp = nums[i];
//            for (int j = i + 1; j < length; j++) {
//                temp += nums[j];
//                // 防止中途 tempMax 替换掉子数组的和
//                if (tempMax > temp && (j == length - 1)) {
//                    temp = tempMax;
//                }
//                if (temp > max) {
//                    max = temp;
//                }
//            }
//        }
//        return max;
//    }



    /**
     * 53. 最大子序和
     * 转化为求前i个元素中最大子序和与当前第i个元素的最大值
     */
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 95.93%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 5.30%
     * 的用户
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        // 全局最大值初始化
//        int maxAns = nums[0];
//        // 前i个元素中最大子序和
//        int tempMax = 0;
//        for (int x:nums) {
//            // 取前i个元素中最大子序和当前元素值的较大值
//            tempMax = Math.max(tempMax+x,x);
//            // 更新全局最大值
//            maxAns = Math.max(tempMax,maxAns);
//        }
//        return maxAns;
//    }


    @Test
    public void show() {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1};
//        int[] nums = {2, -1};
//        int[] nums = {-2, 1, -3, 4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        return 0;
    }

}
