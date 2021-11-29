package com.oswizar.obtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class MapTest {

    public String doir() {
        return "llama";
    }

    public void print(String[] args) {
        this.doir();
    }

    @Test
    public void mapTest() {
        Map<String, Object> map = new HashMap<>(19);

        Map<Integer, Integer> testMap = new HashMap();
        System.out.println(testMap.hashCode());


//        Map<String, Object> map = null;

        map.put(null, null);
        map.put("key2", "小冰");
        map.put("key3", "小华");
        System.out.println(map.hashCode());

//        Iterator<String> iterator = map.keySet().iterator();
//        while(iterator.hasNext()) {
//            String next = iterator.next();
//            if ("key1".equals(next)) {
//                iterator.remove();
//            }
//
//        }
        List list = null;
        System.out.println(list);
        System.out.println(map);

//        map.entrySet().parallelStream().forEach(entry -> {
//                    log.info(entry.getKey() + " : " + entry.getValue());
//                }
//        );

        String ss = "[{\"123\" : \"456\"}]";
        JSONArray array = JSON.parseArray(ss);
        List<Map> maps = array.toJavaList(Map.class);
        System.out.println(maps);

        System.out.println(Calendar.getInstance().get(Calendar.YEAR));

    }


    @Test
    public void mapNullTest() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("key1", "小明");
        map.put("key2", "小冰");
        map.put("key3", "小华");
        String code = String.valueOf(map.get("key"));
        System.out.println(map.get("key"));
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
        int i = 1;


        System.out.println(Integer.parseInt("456"));
        i = ~i + 1;
        System.out.println(i);
        System.out.println(i<<1);


        DateFormat sf = new SimpleDateFormat("yyyyMMdd235959");
        Calendar c = Calendar.getInstance();
        System.out.println(sf.format(c.getTime()));





    }
}
