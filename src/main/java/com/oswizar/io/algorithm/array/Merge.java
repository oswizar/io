package com.oswizar.io.algorithm.array;

import java.util.Arrays;

public class Merge {

    public void show() {


        // [0,1,1,2,2,3]
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {0, 1, 2};
        int m = 0;
        int n = 3;
        System.out.println("合并前：" + Arrays.toString(nums1));
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);

//        merge(nums1, m, nums2, n);
        System.out.println("合并后：" + Arrays.toString(nums1));
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 90.56%
     * 的用户
     * <p>
     * 88. 合并两个有序数组
     *
     * @param nums1 [1, 2, 3, 0, 0, 0]
     * @param m     3
     * @param nums2 [0, 1, 2]
     * @param n     3
     * @result [0, 1, 1, 2, 2, 3]
     */
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p = m + n - 1;
//        int p1 = m - 1;
//        int p2 = n - 1;
//
//        while ((p1 >= 0) && (p2 >= 0)) {
//            /**
//             * 重新调整num1中的数据
//             *
//             * 从后向前依次从nums2中取出元素与nums1比较，
//             * 如果大于，复制nums2中当前元素到nums1的尾部，p2前移
//             * 如果不大于，复制nums1中当前元素到nums1的尾部，p1前移
//             */
//            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
//        }
//        /**
//         * 两个作用：
//         * 1.m==0,while没有执行，直接把nums2指定的元素复制到nums1中
//         * 2.m!=0,while执行之后，把nums2中还没有复制的元素复制到nums1中
//         */
//        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
//    }
    
    public void test() {


        // [0,1,1,2,2,3]
        int[] nums1 = {4, 2, 3, 2};
        int[] nums2 = {5, 0, 1, 2};

        int[] ints = mergeSort(nums1, nums2);
        System.out.println("合并后：" + Arrays.toString(ints));
    }

    public int[] mergeSort(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;

        int[] array = new int[len];

        System.arraycopy(nums1, 0, array, 0, len1);
        System.out.println(Arrays.toString(array));
        System.arraycopy(nums2, 0, array, len1, len2);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);


        return array;
    }


    /**
     * 面试题 10.01. 合并排序的数组
     *
     * @param A [1, 2, 3, 0, 0, 0]
     * @param m 3
     * @param B [0, 1, 2]
     * @param n 3
     * @result [0, 1, 1, 2, 2, 3]
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            /**
             * 重新调整num1中的数据
             *
             * 从后向前依次从nums2中取出元素与nums1比较，
             * 如果大于，复制nums2中当前元素到nums1的尾部，p2前移
             * 如果不大于，复制nums1中当前元素到nums1的尾部，p1前移
             */
            A[p--] = (A[p1] < B[p2]) ? B[p2--] : A[p1--];
        }
        /**
         * 两个作用：
         * 1.m==0,while没有执行，直接把nums2指定的元素复制到nums1中
         * 2.m!=0,while执行之后，把nums2中还没有复制的元素复制到nums1中
         */
        System.arraycopy(B, 0, A, 0, p2 + 1);
    }

    private static void mergeSortByRecursion(int[] arr, int left, int right) {
        // > 边界检查，= 递归终止条件
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSortByRecursion(arr, left, mid);
        mergeSortByRecursion(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void mergeSortByIteration(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 设置步长
        int step = 1;
        while (step <= right) {
            int low = left;
            // 依据步长合并每一组左[low, mid]、右[mid + 1, high]区间
            while (low <= right) {
                int mid = low + step - 1;
                // 左区间不足，提前结束
                if (mid > right) {
                    break;
                }
                int high = Math.min(mid + step, right);
                merge(arr, low, mid, high);
                // 更新下一组区间的起始位置
                low = high + 1;
            }
            // 1.步长翻倍前提前检查；2.额外防止溢出
            if (step > right / 2) {
                break;
            }
            // 步长翻倍
            step <<= 1;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        if (mid < left || mid > right) {
            return;
        }
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            temp[p++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[p++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }


}
