package com.xiexing.algorithm;

import org.junit.Test;

/**
 * @date: 2019/5/29 16:46
 * @author: oswizar
 * @description:
 */
public class ShowTest {

    public static void exchange(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    /**
     * 1selectSort
     */
    public void select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 与之后的每个元素都要比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(arr, minIndex, i);
            }

        }
    }

    /**
     * //{23, 5, 1, 4, 2, 8, 16, 15, 28}
     * 2bubbleSort
     */
    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 设置标志位
            Boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                    flag = false;
                }
            }
            // 如果没有发生交换，排序提前完成，结束循环
            if (flag) {
                break;
            }
        }
    }

    /**
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     * {5, 23, 1, 4, 2, 8, 16, 15, 28}
     * {5, 1, 23, 4, 2, 8, 16, 15, 28}
     * {1, 5, 23, 4, 2, 8, 16, 15, 28}
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    /**
     * { 0, 1, 2, 3, 4, 5,  6,  7,  8}
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     * {2, 5, 1, 4, 23, 8, 16, 15, 28}
     *
     * @param arr
     */
    public void shellExchange(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    exchange(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }


    /**
     * { 0, 1, 2, 3, 4, 5,  6,  7,  8}
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     *
     * @param arr
     */
    public void shellMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j >= gap && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }


    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    //如想从小到大排只需修改这里
                    if (temp < data[j - increment]) {
                        data[j] = data[j - increment];
                    } else {
                        break;
                    }
                }
                data[j] = temp;
            }
        }
    }

    /**
     * { 0, 1, 2, 3, 4, 5,  6,  7,  8}
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     * {23, 5, 1, 4, 2, 8, 16, 15, 28}
     *
     * @param a
     */
    private static void shellSortBasic(int[] a) {
        for (int increment = a.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < a.length; i++) {
                for (int j = i; j >= increment; j -= increment) {
                    if (a[j] < a[j - increment]) {
                        // 进行交换
                        exchange(a, j, j - increment);
                    }
                }
            }
        }
    }


    @Test
    public void test() {
        int[] arr = {23, 5, 1, 4, 2, 8, 16, 15, 28};

//        select(arr);
//        bubble(arr);
        insertionSort(arr);
//        shellExchange(arr);
//        shellMove(arr);
//        shellSort(arr);
//        shellSortBasic(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }
}
