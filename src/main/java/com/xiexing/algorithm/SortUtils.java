package com.xiexing.algorithm;

import org.junit.Test;

/**
 * @date: 2019/5/28 10:32
 * @author: oswizar
 * @description:
 */
public class SortUtils {


    private static final int[] arr = {23, 5, 1, 4, 2, 8, 16, 15, 28};

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        // 常规做法(未考虑溢出情况)
//        arr[a] = arr[a] + arr[b];
//        arr[b] = arr[a] - arr[b];
//        arr[a] = arr[a] - arr[b];

        // 大神操作,异或防止以上情况(arr[a] = arr[a] + arr[b])溢出
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }


    /**
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // 只需要进行 length-1 轮比较，因为经过 length-1 轮之后就已经完全排好序
        for (int i = 0; i < arr.length - 1; i++) {
            /**
             * 每一趟循环比较时，minIndex用于存放最值的数组下标
             * 这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标
             */
            int minIndex = i;
            // 把当前元素(最值)与之后的每个元素逐位比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 把最值下标变更为符合要求的元素下标
                    minIndex = j;
                }
            }
            // 如果minIndex发生变化，则进行元素交换
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }

    /**
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 只需要进行length-1轮比较，因为经过length-1轮之后就已经完全排好序
        for (int i = 0; i < arr.length - 1; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成
            Boolean flag = true;
            // 每轮都从头开始比较，每轮都能找到最值
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 只要发生交换，更改flag的状态
                    flag = false;
                }
            }
            // 如果flag无变化，表示排序已完成，结束比较
            if (flag) {
                break;
            }
        }
    }

    /**
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        // 为什么不是从[0]开始，[0]之前没有与[0]进行比较的元素
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 将要插入的新元素与之前的序列进行比较，确定新元素的位置
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }


    /**
     * @param arr
     */
    public static void shellSortBySwap(int[] arr) {
        // 增量gap,逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    // 插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }


    /**
     * @param arr
     */
    public static void shellSortByMove(int[] arr) {
        // 增量gap,逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[i - gap]) {
                    while (j >= gap && temp < arr[j - gap]) {
                        // 插入排序采用移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }


        @Test
        public void test() {
    //        selectSort(arr);
    //        bubbleSort(arr);
            insertionSort(arr);
    //        shellSortBySwap(arr);
    //        shellSortByMove(arr);
            for (int item : arr) {
                System.out.println(item);
            }
        }

}
