package com.oswizar.io.designpattern.proxy.staticproxy;

/**
 * @date: 2019/4/9 14:52
 * @author: oswizar
 * @description: Test Proxy
 */

import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理测试类
 */
@Slf4j
public class ProxyTest {

    public static void main(String[] args) {
        UserDao target = new UserDao();
        IUserDao userDaoProxy = new UserDaoProxy(target);
        userDaoProxy.save();
    }
}
