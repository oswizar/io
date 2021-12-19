package com.oswizar.io.designpattern.singleton;

public class LazyDCLSingleton {

    private static volatile LazyDCLSingleton instance;

    private LazyDCLSingleton() {
    }

    public static LazyDCLSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDCLSingleton.class) {
                if (instance == null) {
                    instance = new LazyDCLSingleton();
                }
            }
        }
        return instance;
    }
}
