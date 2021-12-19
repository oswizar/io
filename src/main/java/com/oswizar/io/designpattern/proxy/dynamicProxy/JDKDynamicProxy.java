package com.oswizar.io.designpattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy() {
    }

    public JDKDynamicProxy(Object object) {
        this.target = object;
    }

    public Object getProxy(Object object) {
        this.target = object;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("JDK动态代理Before");
    }

    private void after() {
        System.out.println("JDK动态代理After");
    }


}
