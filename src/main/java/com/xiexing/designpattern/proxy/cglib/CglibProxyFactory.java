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

    // 维护目标对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        // 1.工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(target.getClass());
        // 3.设置回调函数
        en.setCallback(this);
        // 4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Begin---");
        Object returnValue = method.invoke(target,objects);
        System.out.println("End---");
        return returnValue;
    }
}
