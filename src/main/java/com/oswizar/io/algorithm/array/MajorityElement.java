package com.oswizar.io.algorithm.array;

import java.util.Arrays;

public class MajorityElement {


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int i = majorityElement(nums);
        System.out.println(i);


    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int key = -1;
        for (int i = 0; i < length; i++) {

        }

        return 0;
    }
}

