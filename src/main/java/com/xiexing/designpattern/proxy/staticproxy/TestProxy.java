package com.xiexing.designpattern.proxy.staticproxy;

/**
 * @date: 2019/4/9 14:52
 * @author: oswizar
 * @description: Test Proxy
 */
public class TestProxy {

    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        UserDaoProxy userDaoProxy = new UserDaoProxy();
        userDaoProxy.save();
    }
}
