package com.oswizar.io.interview.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class ToHex {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('A', 10);
            put('B', 11);
            put('C', 12);
            put('D', 13);
            put('E', 14);
            put('F', 15);
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }};

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String src = input.substring(2);
        char[] srcArr = src.toCharArray();
        int length = srcArr.length;
        int res = 0, tmp;
        for (int i = 0, j = length - 1; j > -1; i++, j--) {
            char key = srcArr[j];
            int metric;
            if (map.containsKey(key)) {
                metric = map.get(key);
            } else {
                metric = Integer.parseInt(String.valueOf(key));
            }
            tmp = metric * (int) Math.pow(16, i);
            res = res + tmp;
        }
        System.out.println(res);
    }
}
