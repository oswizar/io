package com.oswizar.io.interview.nowcoder;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class SodaBottleExchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a == 0) {
                break;
            }
            int res = helper(a);
            System.out.println(res);
        }
    }

    private static int helper(int count) {
        int res = 0;
        int tmp = 0;
        while (count >= 3) {
            // 计算当前兑换汽水
            tmp = count / 3;
            // 统计总兑换汽水
            res = res + tmp;
            // 计算剩余空瓶
            count = tmp + count % 3;
        }
        if (count == 2) {
            // 2个空瓶可借1个空瓶兑换1瓶汽水
            res++;
        }
        return res;
    }
}
