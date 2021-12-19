package com.oswizar.io.designpattern.decorator.navbar;

/**
 * 作业导航装饰
 */
public class TaskNav extends AbsDecorator {

    public TaskNav(INav iNav) {
        super(iNav);
    }

    @Override
    public String showNavs() {
        // 装饰 作业 功能
        return nav.showNavs() + "--作业";
    }
}
