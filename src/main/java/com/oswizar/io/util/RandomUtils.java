package com.oswizar.io.util;

import java.util.Random;

public class RandomUtils {

    /**
     * 生成随机数组
     *
     * @param limit  限制
     * @param length 长度
     * @return {@link int[]}
     */
    public static int[] generateRandomArray(int limit, int length) {
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
        }
        return ans;
    }

    /**
     * 随机生成一个指定行数和列数的二维数组
     * @param rows  行数
     * @param cols  列数
     * @return      二维数组
     */

    public static int[][] generateRandom2DArray(int rows, int cols) {
        Random random = new Random();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(100); // 生成0到99之间的随机整数
            }
        }
        return array;
    }
}
