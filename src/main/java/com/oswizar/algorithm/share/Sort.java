package com.oswizar.algorithm.share;

import org.junit.Test;

import java.util.Arrays;

public class Sort {

    @Test
    public void print() {

//        int gcd = gcd(105, 252);
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        int[] arr = {1, 65, 55, 545, 5, 67, 4, 78, 3, 2, 11};
//        int[] arr = {1, 4, 3, 3, 2, 2, 3};
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        selectSort(arr);
        System.out.println("-------------------------------------");
        System.out.println(Arrays.toString(arr));
    }

    void bubbleSort(int[] arr) {
        for (int i = 0 ; i < arr.length - 1; i++) {
            boolean flag = true;

            for(int j = 0; j < arr.length - 1 -i; j++) {

                if (arr[j] < arr[j + 1]) {

                    swap(arr , j ,j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;

            }
            System.out.println(Arrays.toString(arr));
        }
    }

    void swap(int[] arr, int a, int b) {
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }

    /**
     * @param arr
     */
    public void selectSort(int[] arr) {
        // 只需要进行length-1轮比较，因为经过length-1轮之后就已经完全排好序
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
            System.out.println(Arrays.toString(arr));
        }
    }






}
