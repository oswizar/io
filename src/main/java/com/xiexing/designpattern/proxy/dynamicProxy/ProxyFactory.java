package com.xiexing.designpattern.proxy.dynamicProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date: 2019/4/9 15:15
 * @author: oswizar
 * @description: dynamic class
 */
@Slf4j
public class ProxyFactory {

    // object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 获取动态代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                // 指定当前目标对象的类加载器
                target.getClass().getClassLoader(),
                // 指定当前目标对象实现的接口
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
