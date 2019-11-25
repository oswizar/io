/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Singleton
 * Author:   xiexing
 * Date:     2019/3/26 17:09
 * Description:
 */
package com.xiexing.designpattern.singleton;

public class Singleton {

    // 创建静态内部类
    private static class SingletonInner {
        // 在静态内部类里创建单例
        private static Singleton ourInstance = new Singleton();
    }

    // 私有构造函数
    private Singleton() {
    }

    // 延迟加载、按需创建
    public static Singleton getInstance() {
        return SingletonInner.ourInstance;
    }
}
///////////////////////////////////////////////////////////



