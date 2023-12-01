package com.oswizar.io.algorithm.bitoperation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2, 1, 2};
        int i = singleNumber1(nums);
        System.out.println(i);
    }


    /**
     * 137.给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (1 == map.get(key)) {
                return key;
            }
        }
        return 0;
    }

    public static int singleNumber1(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i <= 31; i++) {
                bits[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            if (bits[i] % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }


}
