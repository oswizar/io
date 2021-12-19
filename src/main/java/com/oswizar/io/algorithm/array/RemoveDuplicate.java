package com.oswizar.io.algorithm.array;

import org.junit.Test;

public class RemoveDuplicate {

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println("newlength: " + i);
        for (int item : nums) {
            System.out.println(item);

        }
    }

    /**
     * 比较 p 和 q 位置的元素是否相等
     * <p>
     * (1)如果相等，q 后移 1 位
     * (2)如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移1位，q 后移1位
     * 重复上述(1)(2)过程，直到 q 等于数组长度。
     * <p>
     * 返回 p + 1，即为新数组长度
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义双指针
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                /**
                 * 如:[0,1,2,3,4,5]
                 * 如果原数组本来就没有重复的元素,
                 * 那么q指针会每次都原地赋值一次,
                 * 故可加如下判断
                 */
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
