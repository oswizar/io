package com.oswizar.io.algorithm.array;

import com.oswizar.io.util.RandomUtils;

import java.util.*;

public class SurroundPrint {

    public static void main(String[] args) {
        int[][] matrix = RandomUtils.generateRandom2DArray(6, 6);
//        int[][] matrix = {{41, 63, 97, 32, 94}, {40, 75, 33, 34, 99}, {58, 83, 95, 59, 51}, {69, 95, 84, 90, 61}, {67, 61, 93, 73, 13}};
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(Arrays.toString(surroundPrint(matrix)));
    }

    private static int[] surroundPrint(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int rows = array.length, cols = array[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int[] ans = new int[rows * cols];
        int k = 0;
        while (true) {
            // 从上左到上右
            for (int i = top, j = left; j <= right; j++) {
                ans[k++] = array[i][j];
            }
            // 收紧上边界
            top++;
            if (top > bottom) break;

            // 从右上到右下
            for (int i = top, j = right; i <= bottom; i++) {
                ans[k++] = array[i][j];
            }
            // 收紧右边界
            right--;
            if (right < left) break;

            // 从右下到左下
            for (int i = bottom, j = right; j >= left; j--) {
                ans[k++] = array[i][j];
            }
            // 收紧下边界
            bottom--;
            if (bottom < top) break;

            // 从左下到左上
            for (int i = bottom, j = left; i >= top; i--) {
                ans[k++] = array[i][j];
            }
            // 收紧左边界
            left++;
            if (left > right) break;
        }
        return ans;
    }



}
