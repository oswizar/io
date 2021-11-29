package com.oswizar.designpattern.proxy.cglib;

import com.oswizar.designpattern.proxy.dynamicProxy.ZhangSan;
import lombok.extern.slf4j.Slf4j;

/**
 * @date: 2019/4/9 16:34
 * @author: oswizar
 * @description: dynamicProxy Test
 */
@Slf4j
public class DynamicProxyTest {

    public static void main(String[] args) {

        CglibDynamicProxy dynamicProxy = new CglibDynamicProxy();

        ZhangSan proxyZhangSan = (ZhangSan) dynamicProxy.getProxy(ZhangSan.class);

        System.out.println(proxyZhangSan.getClass());
        proxyZhangSan.findLove();



    }
}
