package com.oswizar.designpattern.singleton;

public class LazySimpleSingleton {

    private static LazySimpleSingleton instance;

    private LazySimpleSingleton() {}

    public static synchronized LazySimpleSingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
