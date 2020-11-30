package com.xiexing.algorithm.string;

import org.junit.Test;

import java.util.Arrays;

public class MyAtoi {


    /**
     *
     * @param str
     * @return
     */
    /**
     * 执行用时：
     * 31 ms
     * , 在所有 Java 提交中击败了
     * 5.33%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 10.54%
     * 的用户
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        // 边界情况
        if (str == null || "".equals(str) || "-".equals(str) || "+".equals(str)) {
            return 0;
        }
        // 去除前后空格
        str = str.trim();
        char[] array = str.toCharArray();
        if (array.length < 1) {
            return 0;
        }
        System.out.println("原数组为：" + Arrays.toString(array));
        // 正负号标识
        boolean plusSign = true;
        boolean subtractSign = true;
        int len = array.length;
        char[] result = new char[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == ' ') {
                continue;
            }
            if (i > len - 2 && (array[i] >= '0' && array[i] <= '9')) {
                result[j++] = array[i];
            } else {
                boolean numberFlag =
                        ((array[i] >= '0' && array[i] <= '9') || ((array[i] == '-') && subtractSign) || ((array[i] == '+') && plusSign)) && (array[i + 1] >= '0' && array[i + 1] <= '9');
                if (numberFlag) {
                    result[j++] = array[i];
                } else {
                    if ((array[i] >= '0' && array[i] <= '9')) {
                        result[j++] = array[i];
                        break;
                    } else {
                        return 0;
                    }
                }
                if (result[0] == '-') {
                    plusSign = false;
                }
                if (result[0] == '+') {
                    subtractSign = false;
                }
            }
        }
        System.out.println("筛选后的数组为：" + Arrays.toString(result));
        char[] temp = new char[j];
        System.arraycopy(result, 0, temp, 0, j);
        System.out.println("复制后的数组为：" + Arrays.toString(temp));

        String s = new String(temp);

        System.out.println("过滤后转换字符串为：" + s);
        int last = 0;
        try {
            last = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if (temp[0] == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        System.out.println(last);


        return last;
    }


    @Test
    public void show() {
//        String s = "words and 987";
//        String s = "-41939997kl999998-- ---234 with words";
//        String s = "   -42--";
//        String s = "4 2 -3sdfsdfsdf6768";
//        String s = "-91283472332";
//        String s = "214748364844";
        String s = "";
//        String s = "  ";
//        String s = "";
//        String s = "--------";
//        String s = "8";
//        String s = "20000000000000000000";
//        s = s.replace(" ","");
//        System.out.println(s);
        // 2147483647
//        System.out.println(Integer.MAX_VALUE);

        // -2147483648
//        System.out.println(Integer.MIN_VALUE);

        System.out.println(myAtoi1(s));
    }

    /**
     * 官方优化版
     * @param str
     * @return
     */
    public int myAtoi1(String str) {
        // 边界情况
        if (str == null) {
            return 0;
        }
        int len = str.length();
        char[] array = str.toCharArray();
        int index = 0;
        // 去除前导空格
        while (index < len && array[index] == ' ') {
            index++;
        }
        // 处理全是空格的情况("  ...  ")和空串("")
        if (index == len) {
            return 0;
        }
        // 定义正负号标识
        int sign = 1;
        char firstChar = array[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        int result = 0;
        while (index < len) {
            char c = array[index];
            // 符号位后的非数字位直接结束返回
            if (c < '0' || c > '9') {
                break;
            }
            // 取出当前数字位
            int number = c - 48;
            /**
             * 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
             * Integer.MIN_VALUE(-2147483648)
             * Integer.MAX_VALUE(2147483647)
             */
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && number > 8)) {
                return Integer.MIN_VALUE;
            } else if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number > 7)) {
                return Integer.MAX_VALUE;
            }
            // 转换成数字，每一步都需要把符号位乘进去
            result = result * 10 + number * sign;
            index++;
        }
        return result;
    }
}
