package com.oswizar.designpattern.decorator.navbar;

public class Admin implements IPermission {
    @Override
    public String showPermNavs() {
        return new UserManageNav(new GrowthWallNav(new QuestionNav(new TaskNav(new CommonNav())))).showNavs();
    }
}
