package com.oswizar.obtest;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarTest {

    final static private String  REG_NUMBER = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){2})?$";

    @Test
    public void showTest() {

//        String s = addPrefix("123", 2);
//        System.out.println(s);


//        var upList1 = List.of("刘能", "赵四", "谢广坤");
//        var upList2 = List.of("永强", "玉田", "刘英");
//        var upList3 = List.of("谢飞机", "兰妮", "兰娜");
//        var upListAll = List.of(upList1, upList2, upList3);
        // 用var接受局部变量的确非常简洁！
//        upListAll.stream().flatMap(Collection::stream).forEachOrdered(System.out::println);
        System.out.println(isNumber("12"));

        System.out.println(roundFloat(12.345f));


    }

    //金额验证
    public static boolean isNumber(String str){
        // 判断小数点后2位的数字的正则表达式
        Pattern p = Pattern.compile(REG_NUMBER);
        Matcher match=p.matcher(str);
        return match.matches();
    }


    /**
     * 将指定字符串 p 转换成 n 位，位数不足前面补 "0"
     * @param p
     * @param n
     */
    public String addPrefix(String p, int n) {
        int length = p.length();
        if (n < length) {
            return null;
        }
        char[] result = new char[n];
        char[] pArray = p.toCharArray();
        for (int j = 0, i = length; j < n; i--, j++) {
            // 前面不足补"0"
            if (j < n - length) {
                result[j] = '0';
            }
            // 按位复制字符
            if (j < length) {
                result[n - i] = pArray[j];
            }
        }
        return String.valueOf(result);
    }

    public float roundFloat(float num) {
        return (float) (Math.round(num * 100) / 100.0);
    }


    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add("2323");



        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        fillList(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("11111");
        fillList(list2);
    }

    public static <T> void fillList(List<T> list) {

        for (Object o : list) {
            System.out.println(o);

        }

        System.out.println(list);

        System.out.println("2".equals(null));
    }

    @Test
    public void print() {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
    }



}
