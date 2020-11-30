package com.xiexing.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

public class MoveZero {

    @Test
    public void show() {
        int[] nums = {0, 1, 0, 3, 12};
        // 1,3,12,0,0
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283. 移动零(快速排序双指针思想)
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // 定义双指针
        int i = 0, j = 0;
        for (; i < len; i++) {
            // 不等于 0 就进行交换
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                // 交换完成j++是关键
                nums[j++] = temp;
            }
        }
    }


}
