package com.oswizar.io.interview.escape;

import java.util.Arrays;

public class SimpleSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{9, 5, 2, 7, 12, 4, 3, 1, 11, 9};
//        int[] arr = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 2};
        int[] arr = new int[]{110, 100, 0};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
//            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
//            if (!flag) {
//                break;
//            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(arr, index, i);
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] > arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }


    // {1, 3, 4, 5, 6, 7, 8, 9, 10, 2}
    public static void quickSort(int[] arr, int start, int end) {
        // 定义左、右两个指针
        int left = start, right = end;
        if (left >= right) {
            return;
        }
        // 每次取序列最左边的元素为基准值
        int pivot = arr[left];
        // 只要左、右指针还未重合，此趟排序还未结束
        while (left < right) {
            // 1.先从右边开始，直到找到比基准值小的元素才停下
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 1.1.把从右边找到的比基准值小的元素放到左边
            if (left < right) {
                arr[left] = arr[right];
            }

            // 2.再从左边开始，直到找到比基准值大的元素才停下
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 2.1.把从左边找到的比基准值大的元素放到右边
            if (left < right) {
                arr[right] = arr[left];
            }

            // 3.当左、右指针重合时，将基准值填入，此时完成一趟排序
            if (left == right) {
                arr[left] = pivot;
            }
        }
        // 递归调用处理左序列
        quickSort(arr, start, right - 1);
        // 递归调用处理右序列
        quickSort(arr, right + 1, end);
    }


    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    // 合并两个子序列(左:[start...mid],右:[mid + 1...end])
    private static void merge(int[] arr, int start, int mid, int end) {
        // 创建临时序列
        int[] tempArr = new int[end - start + 1];
        // 设置左序列的起点指针
        int p1 = start;
        // 设置右序列的起点指针
        int p2 = mid + 1;
        // 设置临时序列的起点指针
        int p = 0;
        // 将两个子序列合并到临时序列
        while (p1 <= mid && p2 <= end) {
            tempArr[p++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 如果左序列还有剩余，依次放入临时序列
        while (p1 <= mid) {
            tempArr[p++] = arr[p1++];
        }

        // 如果右序列还有剩余，依次放入临时序列
        while (p2 <= end) {
            tempArr[p++] = arr[p2++];
        }

        // 把临时序列元素复制到原序列对应的位置上
        System.arraycopy(tempArr, 0, arr, start, end - start + 1);

    }
}

























