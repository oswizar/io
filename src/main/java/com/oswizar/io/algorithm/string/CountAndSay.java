package com.oswizar.io.algorithm.string;

import org.junit.Test;

public class CountAndSay {


    /**
     * 38. 外观数列
     */
//    public String countAndSay(int n) {
//        // 初始化第一项
//        StringBuilder cur = new StringBuilder("1");
//        // 定义前一项
//        StringBuilder pre;
//        // 从第二项开始
//        for (int i = 1; i < n; i++) {
//            // 每次开始处理之前，先把当前项赋值给前一项
//            pre = cur;
//
//            // 初始化对前一项的描述结果
//            cur = new StringBuilder();
//
//            // 定义对前一项描述的左右双指针
//            int left = 0,right = 0;
//
//            // 对前一项进行描述
//            while (right < pre.length()) {
//                // 遇到相同的元素，右指针继续前行，只要不同就暂停右指针
//                while (right < pre.length() && pre.charAt(left) == pre.charAt(right)) {
//                    right++;
//                }
//                // 拼接当前相同元素的个数和当前元素
//                cur.append(right - left).append(pre.charAt(left));
//                // 更新左指针(左右指针指向同一元素)
//                left = right;
//            }
//        }
//        return cur.toString();
//    }
    @Test
    public void show() {
        System.out.println(countAndSay(30));

    }

    /**
     * 38. 外观数列(Recursion Edition)
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder ans = new StringBuilder();
        String pre = countAndSay(n - 1);
        int len = pre.length();
        int start = 0;
        for (int i = 1; i < len + 1; i++) {
            if (i == len) {
                ans.append(i - start).append(pre.charAt(start));
            } else if (pre.charAt(start) != pre.charAt(i)) {
                ans.append(i - start).append(pre.charAt(start));
                start = i;
            }
        }
        return ans.toString();
    }
}


//        while (end < len) {
//        while (end < len && pre.charAt(start) == pre.charAt(end)) {
//        end++;
//        }
//        ans.append(end - start).append(pre.charAt(start));
//        start = end;
//        }
