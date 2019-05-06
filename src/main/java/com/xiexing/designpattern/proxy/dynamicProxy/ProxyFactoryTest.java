package com.xiexing.designpattern.proxy.dynamicProxy;

import com.xiexing.designpattern.proxy.staticproxy.IUserDao;
import com.xiexing.designpattern.proxy.staticproxy.UserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * @date: 2019/4/9 16:34
 * @author: oswizar
 * @description: dynamicProxy Test
 */
@Slf4j
public class ProxyFactoryTest {

    public static void main(String[] args) {
        // object
        UserDao target = new UserDao();
        log.info(target.getClass().getClassLoader().toString());
        log.info(target.getClass().getInterfaces().toString());

        // 建立目标对象和代理对象的联系
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        log.info(proxy.getClass().toString());
        proxy.save();
        proxy.show();
    }
}
