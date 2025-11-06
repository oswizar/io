package com.oswizar.io.temp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncTest {

    private final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);

    }

    public static int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int j = 1; j < length - 1; j++) {
            leftMax[j] = Math.max(height[j - 1], leftMax[j - 1]);
        }
        for (int k = length - 2; k > 0; k--) {
            rightMax[k] = Math.max(height[k + 1], rightMax[k + 1]);
        }
        int res = 0, min;
        for (int i = 1; i < length - 1; i++) {
            min = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < min) {
                res = res + (min - height[i]);
            }
        }
        return res;
    }

}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                return;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}

