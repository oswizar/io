package com.oswizar.io.obtest;

import java.util.*;

public class PriorityTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(99);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }

        Map map = new HashMap();
        map.put("aa", "33");
        map.put("bb", "22");


        String a = (String) map.get("ccc");

        System.out.println(a);

        System.out.println(list);
        int i = 0;

        int j = ++i;
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(j);


        System.out.println(System.currentTimeMillis());


    }

}
