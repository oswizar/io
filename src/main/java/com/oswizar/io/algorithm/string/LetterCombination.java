package com.oswizar.io.algorithm.string;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    
    public void show() {
        String str = "239";
        double a = 0.2;
        double b = 0.1;
        System.out.println(a + b);
        System.out.println(letterCombinations(str));
    }


    public List<String> letterCombinations(String digits) {
        // 定义返回结果集
        List<String> combinations = new ArrayList<>();
        // 边界处理
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        // 定义数字与字母的映射表
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // 回溯法(递归调用)
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    /**
     * @param combinations 结果集
     * @param phoneMap     数字字母映射表
     * @param digits       输入的数字
     * @param index        输入数字的下标
     * @param combination  中间拼接结果
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
                          StringBuilder combination) {
        // 中间拼接结果到达输入数字长度添加到结果集
        if (index == digits.length()) {
            combinations.add(combination.toString());

        } else {
            // 从前到后逐位取输入的数字
            char digit = digits.charAt(index);
            // 根据数字得到映射的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                // 逐位追加字符
                combination.append(letters.charAt(i));
                // 递归逐层追加字符
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 移除末尾的字符，用于拼接下一个字符
                combination.deleteCharAt(index);
            }
        }
    }
}


















