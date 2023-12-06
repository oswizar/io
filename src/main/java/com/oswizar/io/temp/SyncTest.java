package com.oswizar.io.temp;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class SyncTest {

    private final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = dateFormat.parse("ffff2046-11-11 23:22:22ffff");
            int a = 1/0;
            System.out.println(a);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

