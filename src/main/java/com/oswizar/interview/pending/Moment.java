package com.oswizar.interview.pending;

import java.util.*;

public class Moment {


    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 2, 7, 12, 4, 3, 1, 11};
//        int[] arr = new int[]{0, 1, 1, 2, 3, 3};
//        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
//        final Set<Integer> set = handleDuplication(arr);
//        final int[] set = handleDuplication(null);
//        System.out.println(Arrays.toString(set));
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start, right = end;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left == right) {
                arr[right] = pivot;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }


    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= end) {
            tempArr[p++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tempArr[p++] = arr[p1++];
        }
        while (p2 <= end) {
            tempArr[p++] = arr[p2++];
        }
        System.arraycopy(tempArr, 0, arr, start, end - start + 1);
    }


}


