package com.xiexing.obtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class MapTest {

    @Test
    public void mapTest() {
        Map<String, Object> map = new HashMap<>();

//        Map<String, Object> map = null;

        map.put("key1", "小明");
        map.put("key2", "小冰");
        map.put("key3", "小华");
//        System.out.println(map.get("key4"));
//
//        if ("小明".equals(map.get("key1"))) {
//            System.out.println("ok");
//
//        } else {
//            System.out.println("fail");
//        }
//        String str = map.get("key1").toString();
//        log.info(str);
//        log.info("map : {}", map);
        map.entrySet().parallelStream().forEach(entry -> {
                    log.info(entry.getKey() + " : " + entry.getValue());
                }
        );

    }


    @Test
    public void mapNullTest() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("key1", "小明");
        map.put("key2", "小冰");
        map.put("key3", "小华");
        String code = String.valueOf(map.get("key"));
        System.out.println(code);


        if (code != null) {
            System.out.println("12345");

        }

        if ("null".equals(code)) {
            System.out.println("ok");

        } else {
            System.out.println("fail");
        }
        String str = map.get("key1");
        //log.info(str);
        //log.info("map : {}", map);
    }
}
