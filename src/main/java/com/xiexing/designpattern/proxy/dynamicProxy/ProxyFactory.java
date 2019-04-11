package com.xiexing.designpattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date: 2019/4/9 15:15
 * @author: oswizar
 * @description: dynamic class
 */
public class ProxyFactory {


    // object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // proxyFactory object
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Begin");
                        // run object method
                        Object returnValue = method.invoke(target, args);
                        System.out.println("End");
                        return returnValue;
                    }
                }
        );
    }
}
