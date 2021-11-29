package com.oswizar.designpattern.decorator.navbar;

public class NotLogInUser implements IPermission {
    @Override
    public String showPermNavs() {
        return new CommonNav().showNavs();
    }
}

