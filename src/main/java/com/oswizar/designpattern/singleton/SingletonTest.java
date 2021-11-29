package com.oswizar.designpattern.singleton;

import com.oswizar.entity.Course;

public class SingletonTest {

    public static void main(String[] args) {
        Object object1 = ContainerSingleton.getInstance(Course.class);
        Object object2 = ContainerSingleton.getInstance(Course.class);
        Object object3 = ContainerSingleton.getInstance(Course.class);

        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);
    }
}
