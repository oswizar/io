package com.oswizar.io.temp;

import java.util.*;

public class Practice {
}

class Solution1 {

    private int len;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums, res, path, used);
        return new ArrayList<>(res);

    }

    private void dfs(int[] nums, Set<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, res, path, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution1 solution1 = new Solution1();
        List<List<Integer>> lists = solution1.permute(nums);
        System.out.println(lists);
    }
}