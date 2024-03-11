package com.oswizar.io.algorithm.slidingwindow;



import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
//        left = Math.max(left, map.get(s.charAt(i)) + 1);
        String s = "abcabcbb";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));
    }


    /**
     * 示例:
     * <p>
     * 012 345 67
     * abc abc bb
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        // 定义最长子串的长度
        int max = 0;
        // 定义滑动窗口的左边界(默认下标从0开始)
        int left = 0;

        // 用于标记最长子串的元素
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 用于检测最长子串
            if (map.containsKey(s.charAt(i))) {
                // 更新左边界为原左边界+1,左边界也要取最大值(防止特例:abba)
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 标记最长子串的元素
            map.put(s.charAt(i), i);
            // 更新最长子串的长度
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    
    public void messageFormat() {
        String s = "{0}斯蒂芬斯蒂芬124{1}";
        String a = "aaa";
        String b = "bbb";
        String format = MessageFormat.format(s, a, b);
        System.out.println(format);

    }
}
