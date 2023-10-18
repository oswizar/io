package com.oswizar.io.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    public static void main(String[] args) {
        List<String> list = new Parentheses().generateParenthesis(2);
        System.out.println(list);
    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", n, n, ans);
        return ans;
    }

    /**
     * 执行深度优先遍历，搜索可能的结果
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号剩余数量
     * @param right  有括号剩余数量
     * @param ans    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> ans) {
        // 剪枝
        if (left > right) {
            return;
        }
        // 已到叶子节点，加入结果集
        if (left == 0 && right == 0) {
            ans.add(curStr);
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, ans);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, ans);
        }
    }


}
