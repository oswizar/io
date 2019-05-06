package com.xiexing.designpattern.proxy.cglib;

/**
 * @date: 2019/4/9 17:30
 * @author: oswizar
 * @description: cglib proxy
 */
public class CglibProxyFactoryTest {
    public static void main(String[] args) {
        // 1.创建目标对象
        PersonDao target = new PersonDao();
        // 2.创建代理对象
        PersonDao proxy = (PersonDao) new CglibProxyFactory(target).getProxyInstance();
        // 3.代理对象调用目标方法
        proxy.save();
    }
}
