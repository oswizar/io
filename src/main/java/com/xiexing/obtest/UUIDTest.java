package com.xiexing.obtest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s.replace("-",""));

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}
