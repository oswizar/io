package com.oswizar.io.algorithm.string;

import org.junit.Test;

public class LongestCommonPrefix {

    @Test
    public void test() {
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"aaa", "aa"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);

    }

//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        // 直接选取第一个字符串初始化为最长前缀
//        String ans = strs[0];
//        // 将最长前缀与数组里的每个字符串进行比对
//        for (int i = 1; i < strs.length; i++) {
//            int j = 0;
//            // 比对字符串的每个字符
//            for (; j < ans.length() && j < strs[i].length(); j++) {
//                if (ans.charAt(j) != strs[i].charAt(j)) {
//                    break;
//                }
//            }
//            // 截取与之比对的字符串子串为新的最长前缀
//            ans = strs[i].substring(0, j);
//            // 每比对完一个字符串,如果已经为"",直接返回
//            if ("".equals(ans)) {
//                return "";
//            }
//        }
//        return ans;
//    }
//

    /**
     * 纵向扫描(官方版)
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int length = strs[0].length();
//        int count = strs.length;
//        for (int i = 0; i < length; i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < count; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }


    /**
     * 纵向扫描法:
     * 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
     * 如果相同则继续对下一列进行比较，
     * 如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 直接选取第一个字符串的长度为循环终止条件,因为最长前缀的size<=str[0].length()
        for (int i = 0; i < strs[0].length(); i++) {
            // 每个字符串的前一个字符和后一个字符比较
            for (int j = 0; j < strs.length - 1; j++) {
                // 防止类似["aa", "a"]后一个字符提前结束,故添加判断条件[i == strs[j + 1].length()]
                if (i == strs[j + 1].length() || (strs[j].charAt(i) != strs[j + 1].charAt(i))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 执行到此,说明数组的第一个字符串即为最长前缀
        return strs[0];
    }


}
