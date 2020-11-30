package com.xiexing.algorithm.number;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumber {


    @Test
    public void show() {
        int[] arrays = {2, 5, 7, 8, 11};
        int target = 12;
        System.out.println(Arrays.toString(twoSumByDoublePointer(arrays, target)));
    }

    /**
     * 1. 两数之和(双指针法，前提：升序数组)
     */
    public int[] twoSumByDoublePointer (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }

//    @Test
//    public void show() {
//        int[] arr = solution();
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public int[] solution() {
//        int[] arr = new int[]{2, 7, 11, 15};
//        int target = 9;
//        Map<Integer, Integer> record = new HashMap<>();
//        for (int j = 0; j < arr.length; j++) {
//            record.put(arr[j], j);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            int complement = target - arr[i];
//            if (record.containsKey(complement) && record.get(complement) != i) {
//                return new int[]{i, record.get(complement)};
//
//            }
//
//        }
//
//        return null;
//    }


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> mapNums = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                mapNums.put(nums[i], i);
            }
            for (int j = 0; j < nums.length; j++) {
                int temp = target - nums[j];
                if (mapNums.containsKey(temp) && mapNums.get(temp) != j) {
                    return new int[]{j, mapNums.get(temp)};
                }

            }
            return null;

        }
    }


    /**
     * 1. 两数之和(两遍Hash)
     * @param arrays
     * @param target
     * @return
     */
    public int[] sumOfTwoNumbers(int[] arrays, int target) {
        Map<Integer, Integer> arrayMap = new HashMap<>();
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            arrayMap.put(arrays[i], i);
        }

        for (int j = 0; j < length; j++) {
            int complement = target - arrays[j];
            // 防止特殊用例[3,3] 或 [3,2,4],target:6,不能为本身
            if (arrayMap.containsKey(complement) && arrayMap.get(complement) != j) {
                return new int[]{j, arrayMap.get(complement)};
            }

        }
        return null;

    }

    /**
     * 1. 两数之和(一遍Hash)
     * int[] arrays = {2, 7, 5, 8, 11};
     * int target = 12;
     * 特殊用例[3,3] 或 [3,2,4],target:6
     * @param nums
     * @param target
     * @return
     */
    public int[] sumOfTwo(int[] nums, int target) {
        Map<Integer,Integer> arrayMap = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (arrayMap.containsKey(complement)) {
                return new int[] {arrayMap.get(complement),i};
            }
            arrayMap.put(nums[i],i);
        }
        return null;
    }
}
