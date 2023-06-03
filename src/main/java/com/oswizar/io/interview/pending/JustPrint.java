package com.oswizar.io.interview.pending;

import java.util.Arrays;

public class JustPrint extends Thread {

    public static void main(String[] args) {

//        double a = 2.0;
//        double b = a / 0;
//        System.out.println(b);
//        System.out.println("Hello World!");


        int[] binarySearch = {1, 3, 5, 6, 12, 23, 34, 45, 76, 98};
        int[] quickSort = {1, 2, 3, 4, 5, -100, -50, 0, 10, 20};
        int[] mergeSort = {1, 7, 5, 6, 2, 23, 4, 5, 16, 8};

//        int index = binarySearch(binarySearch, 0, binarySearch.length - 1, 349);
//        System.out.println(index);

        quickSort(quickSort, 0, quickSort.length - 1);
//        System.out.println(Arrays.toString(quickSort));

//        mergeSort(mergeSort, 0, mergeSort.length - 1);
        System.out.println(Arrays.toString(quickSort));


    }


    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int index = start + (end - start) / 2;
            if (target < arr[index]) {
                end = index - 1;
            } else if (target > arr[index]) {
                start = index + 1;
            } else {
                return index;
            }
        }
        return -1;
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
                left++;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
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
        int[] temp = new int[end - start + 1];
        int p = 0, p1 = start, p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] <= arr[p2]) {
                temp[p++] = arr[p1++];
            } else {
                temp[p++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= end) {
            temp[p++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }


}



