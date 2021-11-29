package com.oswizar.algorithm.number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    @Test
    public void show() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 15. 三数之和
     * [-1, 0, 1, 2, -1, -4]
     * [-4, -1, -1, 0, 1, 2]
     * [[-1, -1, 2], [-1, 0, 1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int len = nums.length;

        Arrays.sort(nums);
        //
        for (int i = 0; i < len; i++) {
            // 如果当前元素大于 0 ，sum也大于 0 ，直接结束
            if (nums[i] > 0) {
                break;
            }
            // 当前元素去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义左右指针
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 添加到结果集
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 左指针去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 右指针去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }


}
