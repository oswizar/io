package com.xiexing.algorithm;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Palindrome {


    @Test
    public void show() {

        String s = "qwre,tewrtw,erywery,3464546";
        String[] split = s.split("");
        System.out.println(split[5]);
        char[] chars = s.toCharArray();
        System.out.println(chars[5]);
//        System.out.println(chars);


//        System.out.println(validPalindrome("asabaa"));

//        System.out.println(isPalindrome(121));
    }


    /**
     * 9. 回文数
     * 第一印象版本,也是最糟糕版本,时间和内存都只超过百分之几
     * @param x
     * @return
     */
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        String s = String.valueOf(x);
//        if (s.length() == 1) {
//            return true;
//        }
//        String[] split = s.split("");
//        for (int i = 0, j = split.length - 1; i <= j; i++, j--) {
//            if (split[i].equals(split[j])) {
//                continue;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 9. 回文数
     * 官方解答版本，执行时间超过99.26%，但内存消耗过大(超过百分之几)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == x || x == reverse / 10;
    }


    /**
     * 5. 最长回文子串(暴力解法)
     * <p>
     * 执行结果：
     * 超出时间限制
     * 显示详情
     * 最后执行的输入：
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa..."
     *
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//        // 最长回文子串
//        String ans = "";
//        // 最长回文子串长度
//        int maxLen = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                String temp = s.substring(i, j);
//                if (isPalindromic(temp) && temp.length() > maxLen) {
//                    if (temp.length() == len) {
//                        return temp;
//                    }
//                    ans = temp;
//                    maxLen = temp.length();
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 判断字符串是否是回文串
     *
     * @param s
     * @return
     */
    Boolean isPalindromic(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////官方版本//////////////////////////////////////////////////

    public Boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 118 ms
     * , 在所有 Java 提交中击败了
     * 34.79%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 90.22%
     * 的用户
     *
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        // 例如："ac"，结果应该为a,故maxLen初始值为1不能0
//        int maxLen = 1;
//        int begin = 0;
//
//        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
//        char[] charArray = s.toCharArray();
//        // 枚举所有长度大于 1 的子串 charArray[i..j]
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }


    /////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 32 ms
     * , 在所有 Java 提交中击败了
     * 85.16%
     * 的用户
     * 内存消耗：
     * 37.6 MB
     * , 在所有 Java 提交中击败了
     * 98.92%
     * 的用户
     *
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        if (s.length() < 2) {
//            return s;
//        }
//        // 定义最长回文子串的长度
//        int maxLen = 1;
//        // 定义最长回文子串的左边界
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            // 返回假定字符串长度为奇数时，从中心扩散得到的回文子串的长度
//            int len1 = expandAroundCenter(s, i, i);
//            // 返回假定字符串长度为偶数时，从间隙扩散得到的回文子串的长度
//            int len2 = expandAroundCenter(s, i, i + 1);
//            // 记录当前回文子串的长度
//            int len = Math.max(len1, len2);
//            // >和>=都可以，>取第一个最长回文子串，>=取最后一个最长回文子串
//            if (len >= maxLen) {
//                // 更新最长回文子串的左边界(左边界公式需要推导得到)
//                start = i - (len - 1) / 2;
//                // 更新最长回文子串的长度
//                maxLen = len;
//            }
//        }
//        return s.substring(start, start + maxLen);
//    }
    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 返回中心扩散后回文子串的长度
        return r - l - 1;
    }

    ////////////////////////////////////////////////////////////////////////////


    /**
     * Dynamic Programming(代码简洁版)
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 106 ms
     * , 在所有 Java 提交中击败了
     * 42.35%
     * 的用户
     * 内存消耗：
     * 42.3 MB
     * , 在所有 Java 提交中击败了
     * 31.97%
     * 的用户
     */
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//        int strLen = s.length();
//        // 最长回文串的起点
//        int maxStart = 0;
//        // 最长回文串的终点
//        int maxEnd = 0;
//        // 最长回文串的长度
//        int maxLen = 1;
//
//        boolean[][] dp = new boolean[strLen][strLen];
//
//        for (int r = 1; r < strLen; r++) {
//            for (int l = 0; l < r; l++) {
//                // 状态转移条件
//                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
//                    dp[l][r] = true;
//                    // 更新最长回文子串的长度
//                    if (r - l + 1 > maxLen) {
//                        maxLen = r - l + 1;
//                        maxStart = l;
//                        maxEnd = r;
//                    }
//                }
//            }
//        }
//        return s.substring(maxStart, maxEnd + 1);
//    }

    /**
     * Dynamic Programming(代码简洁版)
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 52 ms
     * , 在所有 Java 提交中击败了
     * 61.25%
     * 的用户
     * 内存消耗：
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 33.78%
     * 的用户
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        // 最长回文串的起点
        int maxStart = 0;
        // 最长回文串的终点
        int maxEnd = 0;
        // 最长回文串的长度
        int maxLen = 1;
        // 实测先转换成数组比直接用s.charAt(i)快一倍的时间
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                // 状态转移条件
                if (charArray[l] == charArray[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    // 更新最长回文子串的长度
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    @Test
    public void test() {
        String s = "babkkkkbkkkkkd";
        System.out.println(longestPalindrome(s));
    }


    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 140 ms
     * , 在所有 Java 提交中击败了
     * 26.91%
     * 的用户
     * 内存消耗：
     * 42.5 MB
     * , 在所有 Java 提交中击败了
     * 21.08%
     * 的用户
     */


    /**
     * Dynamic Programming
     * <p>
     * dp[i][j]数组表示：
     * 字符串s[i⋯j]是否为回文子串，如果是，dp[i][j] = true，如果不是，dp[i][j]=false。
     * <p>
     * 如何已经知道了dp[i+1][j-1]，如何计算dp[i][j]呢？
     * 如果s[i] == s[j]那么说明只要dp[i+1][j−1]是回文子串，那么是dp[i][j]也就是回文子串
     * 如果s[i] != s[j]那么说明dp[i][j]必定不是回文子串。
     */
//    public String longestPalindrome(String s) {
//        if (s == null || "".equals(s) || s.length() < 2) {
//            return s;
//        }
//        int strLen = s.length();
//        boolean[][] dp = new boolean[strLen][strLen];
//
//        // 先转化成字符数组，charArray[i]比s.charAt(i)快，后者每次都要检测下标是否越界
//        char[] charArray = s.toCharArray();
//
//        // 定义最长回文子串的长度
//        int maxLen = 1;
//        // 定义最长回文子串的左边界
//        int start = 0;
//
//        // 初始化二维数组的对角线都为true
//        for (int i = 0; i < strLen; i++) {
//            dp[i][i] = true;
//        }
//        // 由于i < j,故只需要计算对角线上方即可
//        for (int i = strLen - 2; i >= 0; i--) {
//            for (int j = i + 1; j < strLen; j++) {
//                if (charArray[i] == charArray[j]) {
//                    // 处理aa或者aba情况直接为true
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        // 执行状态转移
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                } else {
//                    dp[i][j] = false;
//                }
//                // >和>=都可以，>取最后一个最长回文子串，>=取第一个最长回文子串
//                if (dp[i][j] && j - i + 1 >= maxLen) {
//                    maxLen = j - i + 1;
//                    start = i;
//                }
//            }
//        }
//        return s.substring(start, start + maxLen);
//    }


    /**
     * 示例：babkkkkbkkkkkd
     * 大神版本的中心扩展
     * 不需要区分子串的长度是奇数还是偶数
     */
//    public String longestPalindrome(String s) {
//        if (s == null || "".equals(s) || s.length() < 2) {
//            return s;
//        }
//        char[] charArray = s.toCharArray();
//
//        // 保存最长回文子串起始位置
//        int[] result = new int[2];
//        for (int i = 0; i < s.length(); i++) {
//            // 找到下一个与当前字符不同的字符下标
//            i = findLongest(charArray, i, result);
//        }
//        return s.substring(result[0], result[1] + 1);
//    }
//
//    private int findLongest(char[] charArray, int low, int[] result) {
//        int high = low;
//        // 先查找相邻的相同字符
//        while (high < charArray.length - 1 && charArray[high] == charArray[high + 1]) {
//            high++;
//        }
//        // 记录中间部分的最后一个字符的下标
//        int index = high;
//        // 再以当前字符为中心向左右扩散
//        while (low > 0 && high < charArray.length - 1 && charArray[low - 1] == charArray[high + 1]) {
//            low--;
//            high++;
//        }
//        // 记录最大长度
//        if (high - low >= result[1] - result[0]) {
//            result[0] = low;
//            result[1] = high;
//        }
//        return index;
//    }


}
