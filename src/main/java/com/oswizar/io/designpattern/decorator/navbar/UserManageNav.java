package com.oswizar.io.designpattern.decorator.navbar;

/**
 * 用户管理导航装饰
 */
public class UserManageNav extends AbsDecorator {

    public UserManageNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--用户管理";
    }
}
