package com.xiexing.designpattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @date: 2019/4/9 17:13
 * @author: oswizar
 * @description:
 */
public class CglibProxyFactory implements MethodInterceptor {

    // object
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 1.tool
        Enhancer en = new Enhancer();
        // 2.setting superClass
        en.setSuperclass(target.getClass());
        // 3.setting callback
        en.setCallback(this);
        // 4.create proxyClassObject
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Begin");
        Object returnValue = method.invoke(target,objects);
        System.out.println("End");
        return returnValue;
    }
}
