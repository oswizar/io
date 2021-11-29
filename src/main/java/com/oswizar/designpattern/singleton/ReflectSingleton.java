package com.oswizar.designpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectSingleton {

    public static void main(String[] args) {

        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        Class<EnumSingleton> clazz = EnumSingleton.class;
        try {
            Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            EnumSingleton instance1 = constructor.newInstance();
            EnumSingleton instance2 = constructor.newInstance();
            System.out.println(instance1);
            System.out.println(instance2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
