package com.oswizar.io.algorithm.backtrack;

import java.util.*;

public class PermuteUnique {

    private static int len;
    private static final Deque<Integer> row = new LinkedList<>();

    
    public static void main(String[] args) {

        int[] array = {1, 1, 1, 4};
        System.out.println(Arrays.toString(array));
        List<List<Integer>> permuted = permuteUnique(array);
        System.out.println(permuted);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        helper(nums, ans, used);
        return ans;

    }

    /**
     * @param nums
     * @param ans
     * @param used
     */
    private static void helper(int[] nums, List<List<Integer>> ans, boolean[] used) {
        if (row.size() == len) {
            ans.add((new ArrayList<>(row)));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 1.!used[i-1],想要填入i,则要求i-1已经填入(a1b1c1)
                // 2.used[i-1],想要填入i,则要求i-1未填入(c1b1a1)
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                row.addLast(nums[i]);
                used[i] = true;
                helper(nums, ans, used);
                used[i] = false;
                row.removeLast();
            }
        }
    }
}
