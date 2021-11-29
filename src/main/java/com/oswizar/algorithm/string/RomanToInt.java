package com.oswizar.algorithm.string;

import org.junit.Test;

public class RomanToInt {

    @Test
    public void print() {
        String s = "MCMXCIV";
        int sum = romanToInt(s);
        System.out.println(sum);
    }


    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 99.94%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 91.59%
     * 的用户
     */


    /**
     * 输入: "M CM XC IV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * 可以看成:1000-100+1000-10+100-1+5 = 1994
     * <p>
     * 每次进行后一位与前一位比较,决定前一位是sum+=还是sum-+,知道最后一位变成preNum,直接sum+=
     */
    public int romanToInt(String s) {
        int sum = 0;
        int num;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            num = getValue(s.charAt(i));
            if (num > preNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        // 最后以为直接相加
        return sum + preNum;
    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
