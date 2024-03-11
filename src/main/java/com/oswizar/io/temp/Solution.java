package com.oswizar.io.temp;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入: "(0123)"
 * <p>
 * 输出: ["(0, 123)", "(0, 1.23)", "(0, 12.3)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 */
class Solution {
    String s;

    public List<String> ambiguousCoordinates(String _s) {
        s = _s.substring(1, _s.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) { // 枚举逗号：在 i 的后面追加逗号
            List<String> a = search(0, i);
            List<String> b = search(i + 1, n - 1);
            for (String x : a) {
                for (String y : b) {
                    ans.add("(" + x + ", " + y + ")");
                }
            }
        }
        return ans;
    }

    List<String> search(int start, int end) {
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0') {
            ans.add(s.substring(start, end + 1));
        }
        for (int i = start; i < end; i++) { // 枚举小数点：在 i 后面追加小数点
            String a = s.substring(start, i + 1);
            String b = s.substring(i + 1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0') continue;
            if (b.charAt(b.length() - 1) == '0') continue;
            ans.add(a + "." + b);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution1 = new Solution();
        List<String> list = solution1.ambiguousCoordinates("(0123)");
        System.out.println(list);
    }
}
