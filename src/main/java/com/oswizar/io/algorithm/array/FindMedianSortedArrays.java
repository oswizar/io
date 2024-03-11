package com.oswizar.io.algorithm.array;

public class FindMedianSortedArrays {


    /**
     * 当N为奇数时: m = X(N+1)/2
     * 当N为偶数时: m = X(N/2) + X(N/2+1)
     * <p>
     * JDK1.8 奇技淫巧直男版(LeetCode第一道困难题)
     * <p>
     * 执行用时：
     * 22 ms
     * , 在所有 Java 提交中击败了
     * 5.16%
     * 的用户
     * 内存消耗：
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 79.72%
     * 的用户
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
//        List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
//        list1.addAll(list2);
//        Collections.sort(list1);
//        if (list1.stream().allMatch(item -> item == 0)) {
//            return 0;
//        }
//        int len = list1.size();
//        if (len % 2 == 0) {
//            return (double) (list1.get(len / 2 - 1) + list1.get(len / 2 + 1 - 1)) / 2;
//
//        } else {
//            return (double) list1.get((len + 1) / 2 - 1);
//        }
//    }


    /**
     * 4. 寻找两个正序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 18.06%
     * 的用户
     * 内存消耗：
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 78.39%
     * 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int len = len1 + len2;
//
//        int[] array = new int[len];
//
//        System.arraycopy(nums1, 0, array, 0, len1);
//        System.arraycopy(nums2, 0, array, len1, len2);
//
//        Arrays.sort(array);
//        if (len % 2 == 0) {
//            return (double) (array[(len / 2 - 1)] + array[(len / 2 + 1 - 1)]) / 2;
//
//        } else {
//            return array[((len + 1) / 2 - 1)];
//        }
//    }


    /**
     * 4. 寻找两个正序数组的中位数
     * <p>
     * 不需要进行数组合并，直接从两个数组中找出中位数即可
     * 无论数组长度为奇或偶，找到中位数的次数最多为 len/2 + 1
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int len = m + n;
//        // 当数组长度为偶时，记录计算中位数所需的前一位
//        int pre = -1;
//        /**
//         * (1)当数组长度为偶时，记录计算中位数所需的后一位
//         * (2)当数组长度为奇时，记录中位数
//         */
//        int cur = -1;
//        // p1,p2分别为nums1和nums2的指针
//        int p1 = 0;
//        int p2 = 0;
//        for (int i = 0; i < len / 2 + 1; i++) {
//            // 每次循环之前先把上次的结果赋值给pre
//            pre = cur;
//            /**
//             * 判断条件可由下面的示例推导出
//             * (1)nums1[1,2]，nums2[3,4]
//             * (2)nums1[3,4]，nums2[1,2]
//             */
//            if (p2 < n && (p1 == m || nums1[p1] > nums2[p2])) {
//                cur = nums2[p2++];
//            } else {
//                cur = nums1[p1++];
//            }
//        }
//        // len为偶
//        if ((len & 1) == 0) {
//            return (pre + cur) / 2.0;
//        }
//        return cur;
//    }

    public void show() {
        int[] num1 = {1, 3, 4, 9};
        int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] num1 = {1};
//        int[] num2 = {2, 3, 4, 5, 6};

        System.out.println(findMedianSortedArrays(num1, num2));

    }


    /**
     * 4. 寻找两个正序数组的中位数
     * 转化成寻找两个有序数组中的第 k小的数，其中 k为 (m+n)/2 或 (m+n)/2+1
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if ((totalLength & 1) == 1) {
            // 数组总长度N为奇数，返回第 N/2+1 个元素的值即可
            int k = totalLength / 2 + 1;
            return getKthElement(nums1, nums2, k);
        } else {
            // 数组总长度N为偶数，返回第 N/2 和 N/2+1 个元素的平均值
            int k1 = totalLength / 2, k2 = totalLength / 2 + 1;
            return (getKthElement(nums1, nums2, k1) + getKthElement(nums1, nums2, k2)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        // 记录nums1和nums2的真正序号
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1) {
                // 如果nums1比较结束，返回nums2里的元素值
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                // 如果nums2比较结束，返回nums1里的元素值
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                // 如果 k==1,返回nums1和nums2中较小的元素值
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            // 记录nums1和nums2每次需要进行比较的当前序号
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            /**
             * 比较nums1[i]和nums2[i]大小，并排除较小数组中[...~i]的值
             * 重新调整 k 的值(k 的计算是核心)
             * 调整较小数组中的真正序号(更新为当前比较的序号的下一位即可)
             */
            if (nums1[newIndex1] > nums2[newIndex2]) {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            } else {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }


}


























