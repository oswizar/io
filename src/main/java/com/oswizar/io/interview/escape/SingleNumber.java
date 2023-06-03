package com.oswizar.io.interview.escape;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    // [4,1,2,1,2]
    public static void main(String[] args) {

        int[] nums = new int[]{3,4,3,3};
        int i = new Solution().singleNumber(nums);
        System.out.println(i);
    }

}

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 3);
            } else {
                map.put(num, 1);
                new String();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

//    public int singleNumber(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            // (^)异或,0 ^ 1 = 1;1 ^ 1 = 0
//            result ^= num;
//        }
//        return result;
//    }

//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> a = new HashMap<>();
//        for (int num : nums) {
//            if (a.containsKey(num)) {
//                a.put(num, a.get(num) + 1);
//            } else {
//                a.put(num, 1);
//            }
//        }
//        for (Map.Entry entry : a.entrySet()) {
//            if (1 == (int) entry.getValue()) {
//                return (int) entry.getKey();
//            }
//        }
//        return 0;
//    }
}
