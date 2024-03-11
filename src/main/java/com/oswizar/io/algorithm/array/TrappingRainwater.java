package com.oswizar.io.algorithm.array;

import java.util.Arrays;

public class TrappingRainwater {

    public static void main(String[] args) {
//        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] array = null;
        int ans = trappingRainwater(array);
        System.out.println(ans);

    }

    private static int trappingRainwater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        for (int i = 1; i < length - 1; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        for (int i = length - 2; i > 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));
        int ans = 0;
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }

}
