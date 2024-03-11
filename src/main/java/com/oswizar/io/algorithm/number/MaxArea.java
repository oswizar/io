package com.oswizar.io.algorithm.number;



public class MaxArea {

    
    public void show() {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7,9};
        System.out.println(maxArea(array));
    }


    /**
     * 11. 盛最多水的容器
     * 解题思路：
     * 两个指针指向的数字中较小值∗指针之间的距离
     */
    public int maxArea(int[] height) {
        int len = height.length;
        // 定义双指针
        int left = 0;
        int right = len - 1;
        int result = 0;
        // i 为所计算面积的 长
        for (int i = len - 1; i > 0; i--) {
            // 取双指针指向数字中的最小值作为面积的 宽
            int hei = Math.min(height[left], height[right]);
            result = Math.max(result, hei * i);
            // 移动指向较小值的指针
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}



