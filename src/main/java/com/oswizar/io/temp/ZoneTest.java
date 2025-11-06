package com.oswizar.io.temp;

import com.oswizar.io.algorithm.tree.TreeNode;
import com.oswizar.io.sample.entity.Person;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Slf4j
public class ZoneTest {

    private static final Object lock = new Object();
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        int[] nums = {1,1,2};
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums, result, path, visited);

        System.out.println(result);

    }

    public static void permute(int[] nums, List<List<Integer>> result, Deque<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                visited[i] = true;
                permute(nums, result, path, visited);
                visited[i] = false;
                path.removeLast();
            }
        }

    }




    public void helper(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                data.add(root.val);
                prev = root;
                stack.pop();
                root = null;
            } else {
                root = root.right;
            }
        }

    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > maxLen && validPalindromic(arr, i, j)) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static boolean validPalindromic(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }
        int count = len;
        char[] arr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (validPalindromic(arr, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

}
