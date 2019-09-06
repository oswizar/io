package com.xiexing.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date: 2019/7/3 14:05
 * @author: oswizar
 * @description:
 */
public class StringStudy {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        System.out.println("=================================");

        String a = new String(new char[] {'h','e','l','l','o'});

        System.out.println(a);

        System.out.println(s.contains("LL"));


        String [] arr = {"a","b","c"};
        System.out.println(String.join("@@@",arr));
        System.out.println(Arrays.asList(arr));

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        System.out.println(list);


        byte [] bytes = {'h','a'};
        System.out.println(bytes);
        System.out.println(new String(bytes));

    }
}
