package com.xiexing.designpattern.proxy.cglib;

/**
 * @date: 2019/4/9 17:30
 * @author: oswizar
 * @description: cglib proxy
 */
public class TestCglibProxyFactory {
    public static void main(String[] args) {
        // 1.object
        PersonDao personDao = new PersonDao();
        // 2.proxy object
        PersonDao proxy = (PersonDao) new CglibProxyFactory(personDao).getProxyInstance();
        // 3.run proxy
        proxy.save();
    }
}
