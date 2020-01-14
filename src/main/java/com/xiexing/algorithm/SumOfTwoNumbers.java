package com.xiexing.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbers {

    @Test
    public void show() {
        int[] arr = solution();
        System.out.println(Arrays.toString(arr));
    }

    public int[] solution() {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> record = new HashMap<>();
        for (int j = 0; j < arr.length; j++) {
            record.put(arr[j], j);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (record.containsKey(complement) && record.get(complement) != i) {
                return new int[]{i, record.get(complement)};

            }

        }

        return null;
    }
}