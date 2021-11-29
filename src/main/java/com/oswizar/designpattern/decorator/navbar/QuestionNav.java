package com.oswizar.designpattern.decorator.navbar;

/**
 * 题库导航装饰
 */
public class QuestionNav extends AbsDecorator {

    public QuestionNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--题库";
    }
}
