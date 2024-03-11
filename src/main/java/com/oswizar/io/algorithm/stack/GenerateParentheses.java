package com.oswizar.io.algorithm.stack;



import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    
    public void show() {
        System.out.println(generateParenthesis(3));
    }

    /**
     * 22. 括号生成(dfs做减法)
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", n, n, result);
//        dfs("", 0, 0, n, result);
        return result;

    }

    /**
     * 22. 括号生成(dfs做减法)
     * 可以生出左子树条件：左括号剩余数量大于 0
     * 可以生出右子树条件：左括号剩余数量小于右括号剩余数量
     *
     * @param curStr 中间拼接字符串结果
     * @param left   左括号剩余数量
     * @param right  右括号剩余数量
     * @param result 结果集
     */
    public void dfs(String curStr, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(curStr);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, result);
        }
    }


    /**
     * 22. 括号生成(dfs做加法)
     * 可以生出左子树条件：左括号使用数量小于 n
     * 可以生出右子树条件：左括号使用数量大于右括号使用数量
     *
     * @param curStr 中间拼接字符串结果
     * @param left   当前使用左括号数量
     * @param right  当前使用右括号数量
     * @param n      左(右)括号总数
     * @param result 结果集
     */
    public void dfs(String curStr, int left, int right, int n, List<String> result) {
        if (left == n && right == n) {
            result.add(curStr);
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, result);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, result);
        }
    }
}
