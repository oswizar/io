package com.oswizar.designpattern.proxy.staticproxy;

/**
 * @date: 2019/4/9 14:48
 * @author: oswizar
 * @description:
 */

/**
 * 代理对象
 */
public class UserDaoProxy implements IUserDao {

    private final UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;

    }
    @Override
    public void save() {
        System.out.println("Begin");
        target.save();
        System.out.println("End");
    }
}
