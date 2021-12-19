package com.oswizar.io.algorithm.number;

import org.junit.Test;

public class MaxProfit {


    /**
     * 第一印象枚举版
     * <p>
     * 惨不忍睹的结果：
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 365 ms
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 22.59%
     * 的用户
     */
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//        int result = 0;
//        int len = prices.length;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (prices[j] - prices[i] > result) {
//                    result = prices[j] - prices[i];
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 一遍for优化版
     * 找出买入卖出之间的最大差值
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.97%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 27.57%
     * 的用户
     */
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//        int minprice = prices[0];
//        int result = 0;
//        for (int price : prices) {
//            // 找出当前时间段内的股票最低价
//            if (price < minprice) {
//                minprice = price;
//            } else if (price - minprice > result) {
//                // 更新买入和卖出之间的差值
//                result = price - minprice;
//            }
//        }
//        return result;
//    }


    /**
     * Dynamic Programming
     * <p>
     * 1.状态 dp[i][j] 表示：在下标为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。
     * <p>
     * 说明：
     * j 只有 2 个值：
     * 0 表示不持股（*特指卖出股票以后的不持股状态*），
     * 1 表示持股。
     * 「用户手上不持股」不代表用户一定在下标为 i 的这一天把股票抛售了,也可能还没开始买股票;
     * <p>
     * 2.状态两种：
     * dp[i][0]:在第i天不持股所获得的最大利润
     * dp[i][1]:在第i天持股所获得的最大利润
     * <p>
     * 3.状态转移：
     * 1)dp[i][0]:
     * {
     * (1).dp[i-1][0]：昨天不持股，今天继续不持股
     * (2).dp[i-1][1] + prices[i]：昨天持股，今天卖出
     * }
     * <p>
     * 2)dp[i][1]:
     * {
     * (1).dp[i-1][1]:昨天持股，今天继续持股
     * (2).-prices[i]:今天才开始持股
     * }
     */
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//        int len = prices.length;
//        int[][] dp = new int[len][2];
//
//        // 定义初始值
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < len; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//
//        }
//        // 取最后一天不持股所获得的最大利润
//        return dp[len - 1][0];
//    }

    /**
     * 简洁代码最终版
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int result = 0;
        int minprice = Integer.MAX_VALUE;
        for (int price : prices) {
            minprice = Math.min(minprice, price);
            result = Math.max(result, price - minprice);
        }
        return result;
    }

    @Test
    public void show() {
        int[] parameter = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(parameter));
    }
}
