package com.xiexing.designpattern.proxy.dynamicProxy;

import com.xiexing.designpattern.proxy.staticproxy.IUserDao;
import com.xiexing.designpattern.proxy.staticproxy.UserDao;

/**
 * @date: 2019/4/9 16:34
 * @author: oswizar
 * @description: dynamicProxy Test
 */
public class TestProxyFactory {

    public static void main(String[] args) {
        // object
        UserDao target = new UserDao();
        System.out.println(target.getClass());

        // proxy object
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
