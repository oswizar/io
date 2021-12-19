package com.oswizar.io.concurrency;

import org.junit.Test;

import java.util.*;

public class MapTest {


    @Test
    public void concurrentMapTest() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        System.out.println(Integer.MAX_VALUE);
        synchronizedMap = null;

        System.out.println(synchronizedMap.hashCode());

        Map<String, Object> hashtable = new Hashtable<>();
        Object id = hashtable.put("id", 1);
        System.out.println(id);
        Object id1 = hashtable.put("id", 4);
        System.out.println(id1);
        hashtable.put("name", "tom");
        hashtable.put("age", 12);
        hashtable.put("major", "MBA");
        hashtable.put("score", 100);

        hashtable.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

}
