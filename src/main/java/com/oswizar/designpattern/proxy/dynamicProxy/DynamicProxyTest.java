package com.oswizar.designpattern.proxy.dynamicProxy;

/**
 * @date: 2019/4/9 16:34
 * @author: oswizar
 * @description: dynamicProxy Test
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        JDKDynamicProxy dynamicProxy = new JDKDynamicProxy();

        IUser proxyZhangSan = (IUser) dynamicProxy.getProxy(new ZhangSan());

        System.out.println(proxyZhangSan.getClass());
        proxyZhangSan.findLove();

        System.out.println();


    }
}
