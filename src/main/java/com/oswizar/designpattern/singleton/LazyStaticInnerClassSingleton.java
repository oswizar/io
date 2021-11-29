package com.oswizar.designpattern.singleton;

public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不允许非法访问");
        }
    }

    private final static class LazyHolder {
        private final static LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
