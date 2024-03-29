package com.oswizar.io.designpattern.decorator.navbar;

public class LogInUser implements IPermission {
    @Override
    public String showPermNavs() {
        return new QuestionNav(new CommonNav()).showNavs();
    }
}
