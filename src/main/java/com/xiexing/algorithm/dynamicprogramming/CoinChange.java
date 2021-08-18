package com.xiexing.algorithm.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;

public class CoinChange {


    /**
     * 322. 零钱兑换(动态规划：自底向上)
     * 设：dp[n]为凑出金额为n需要的最小硬币数
     *
     * @param coins  硬币类型
     * @param amount 金额
     */
//    public int coinChange(int[] coins, int amount) {
//
//        // 最后需要返回 dp[amount],防止越界,需定义长度为 amount + 1
//        int[] dp = new int[amount + 1];
//
//        // 初始化数组都为 amount + 1,因为dp[amount]最多返回 amount(全是1元的硬币),所以初始化为 amount + 1
//        // 相当于初始化为正无穷，便于结果取最小值
//        Arrays.fill(dp, amount + 1);
//
//        // 定义 base case(当金额为 0 时，需要 0 个硬币凑成)
//        dp[0] = 0;
//
//        // 外层for循环遍历所有状态的所有取值(dp[1]-dp[amount])
//        for (int i = 1; i <= amount; i++) {
//            // 内层for循环求所有选择的最小值
//            for (int coin : coins) {
//                // 只有当前金额大于等于硬币最小面值时才进行状态转换
//                if (i >= coin) {
//                    dp[i] = Math.min(dp[i], (dp[i - coin]) + 1);
//                }
//            }
//        }
//        // 如果 dp[amount] 不为初始值，则为结果返回
//        return (dp[amount] == amount + 1) ? -1 : dp[amount];
//    }


    /**
     * 322. 零钱兑换(动态规划：自顶向下)
     * 设：dp[n]为凑出金额为n需要的最小硬币数
     *
     * @param coins  硬币类型
     * @param amount 金额
     */
    public int coinChange(int[] coins, int amount) {
        // 参数检查
        if (amount < 1) {
            return 0;
        }
        // 最后需要返回 dp[amount],防止越界,需定义长度为 amount + 1
        int[] dp = new int[amount + 1];
        return coinChoose(coins, amount, dp);
    }

    public int coinChoose(int[] coins, int amount, int[] dp) {

        // 递归终止条件
        if (amount == 0) {
            return 0;
        }

        // 剪枝操作(防止重复计算，如果之前已经计算过则直接返回)
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        // 循环求所有选择的最小值
        for (int coin : coins) {
            // 只有当前金额大于等于硬币最小面值时才进行状态转换
            if (amount >= coin) {
                int temp = coinChoose(coins, amount - coin, dp);
                // 更新当前金额所需硬币最小值
                if (temp >= 0 && temp < min) {
                    min = temp + 1;
                }
            }
        }
        return dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
    }

    @Test
    public void show() {
//        int a = 6;
        System.out.println(6/6);
        System.out.println(6/6/6);
        System.out.println(6/6/6/6);
        int[] coins = {5};
        int amount = 5;
//        System.out.println(coinChange(coins, amount));
    }
}
