package com.oswizar.io.designpattern.decorator.navbar;

/**
 * 抽象装饰器， 用来扩展装饰器实例
 */
public abstract class AbsDecorator implements INav {

    protected INav nav;

    protected AbsDecorator(INav nav) {
        this.nav = nav;
    }

    @Override
    public abstract String showNavs();
}
