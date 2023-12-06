package com.oswizar.io.util;

public class RandomUtils {

    /**
     * 生成随机数组
     *
     * @param limit  限制
     * @param length 长度
     * @return {@link int[]}
     */
    private static int[] generateRandomArray(int limit, int length) {
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
        }
        return ans;
    }
}
