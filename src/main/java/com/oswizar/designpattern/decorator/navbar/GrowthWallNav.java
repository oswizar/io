package com.oswizar.designpattern.decorator.navbar;

/**
 * 成长墙导航装饰
 */
public class GrowthWallNav extends AbsDecorator {
    public GrowthWallNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--成长墙";
    }
}
