package com.oswizar.algorithm.stack;

import org.junit.Test;

import java.util.*;

public class StackAlgorithm {


    @Test
    public void stackTest() {
        Stack<String> stack = new Stack<>();

        String s = "{{";
        System.out.println(isValid(s));
        ;
    }


    /**
     * 有效的括号匹配(字符串只能包含指定的括号,不能含有空格或其他字符)
     *
     * @param s
     * @return 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.43%
     * 的用户
     * 内存消耗：
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 52.15%
     * 的用户
     */
//    public boolean isValid(String s) {
//        LinkedList<Character> stack = new LinkedList<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '[') {
//                stack.push(']');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (stack.isEmpty() || c != stack.pop()) {
//                return false;
//            }
//        }
//        return stack.isEmpty();
//    }


    // "()" "(]" "()[]{}"

    /**
     * 20. 有效的括号
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 78.45%
     * 的用户
     * 内存消耗：
     * 37.5 MB
     * , 在所有 Java 提交中击败了
     * 83.99%
     * 的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        // 字符串长度为奇数,直接返回false
        if (n % 2 == 1) {
            return false;
        }
        // 将指定的括号做映射
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');

        LinkedList<Character> stack = new LinkedList();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                stack.push(pairs.get(ch));
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void source() {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
    }


}
