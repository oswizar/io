package com.oswizar.designpattern.decorator.navbar;

public class LogInVip implements IPermission {
    @Override
    public String showPermNavs() {
        return new GrowthWallNav(new QuestionNav(new TaskNav(new CommonNav()))).showNavs();
    }
}
