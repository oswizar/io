package com.oswizar.io.algorithm.string;

import org.junit.Test;

import java.util.Objects;

public class StrStr {


    @Test
    public void show() {
        String haystack = "aabaab", needle = "aabaab";
//        String haystack = "aabaab", needle = "aab";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 28. 实现 strStr()
     */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (Objects.equals(needle, "")) {
            return 0;
        }
        for (int i = 0; (i < len1 - len2 + 1) && (len2 <= len1); i++) {
            // 截取haystack子串与needle比对
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
