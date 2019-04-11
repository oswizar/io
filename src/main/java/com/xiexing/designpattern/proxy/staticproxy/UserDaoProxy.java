package com.xiexing.designpattern.proxy.staticproxy;

/**
 * @date: 2019/4/9 14:48
 * @author: oswizar
 * @description:
 */
public class UserDaoProxy implements IUserDao {

    private UserDao userDao = new UserDao();

//    public UserDaoProxy(UserDao target) {
//        this.userDao = target;
//
//    }
    @Override
    public void save() {
        System.out.println("Begin");
        userDao.save();
        System.out.println("End");
    }
}
