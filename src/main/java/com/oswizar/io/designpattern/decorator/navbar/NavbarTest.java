package com.oswizar.io.designpattern.decorator.navbar;

public class NavbarTest {

    private static final int i = 0;

    public static void main(String[] args) {

        int a;

        IPermission notLogInUser = new NotLogInUser();
        System.out.println("未登录用户导航条：");
        System.out.println(notLogInUser.showPermNavs());
        System.out.println("===========================");

        IPermission logInUser = new LogInUser();
        System.out.println("已登录用户导航条：");
        System.out.println(logInUser.showPermNavs());
        System.out.println("===========================");

        IPermission logInVip = new LogInVip();
        System.out.println("已登录会员导航条：");
        System.out.println(logInVip.showPermNavs());
        System.out.println("===========================");

        IPermission admin = new Admin();
        System.out.println("管理员导航条：");
        System.out.println(admin.showPermNavs());
        System.out.println("===========================");

    }


}
