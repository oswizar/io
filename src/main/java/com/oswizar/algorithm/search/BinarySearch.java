package com.oswizar.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = new int[]{9, 5, 2, 7, 12, 4, 3, 1, 11};
//        int[] arr = new int[]{0, 1, 1, 2, 3, 3};
//        int[] arr = new int[]{0, 1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9};
        int[] arr = new int[]{2, 2, 2, 2, 2};
//        final int index = binarySearch(arr, 2);
        final int index = boundWithLeftAndRight(arr, 0);
        System.out.println(index);


    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    // {2, 2, 2, 2, 2}
    public static int boundWithLeftAndRight(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else if (nums[mid] == target) {
//                // 不返回，缩小左区间
//                right = mid - 1;
//            }
//        }
//        return left >= nums.length || nums[left] != target ? -1 : left;


        // {2, 2, 2, 2, 2}
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 不返回，缩小右区间
                left = mid + 1;
            }
        }
        return right < 0 || nums[right] != target ? -1 : right;
    }

}
