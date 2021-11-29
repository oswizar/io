package com.oswizar.designpattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<Class<?>, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(Class<?> clazz) {
        Object instance = null;
        if (!ioc.containsKey(clazz)) {
            try {
                instance = clazz.newInstance();
                ioc.put(clazz, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        } else {
            return ioc.get(clazz);
        }
    }

}
