package com.oswizar.io.algorithm.string;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString {


    @Test
    public void show() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }


    /**
     * 双指针迭代
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
