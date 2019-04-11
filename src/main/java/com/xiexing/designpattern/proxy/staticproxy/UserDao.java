package com.xiexing.designpattern.proxy.staticproxy;

/**
 * @date: 2019/4/9 14:45
 * @author: oswizar
 * @description:
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("UserDao...");
    }
}
