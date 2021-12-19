package com.oswizar.io.designpattern.decorator.navbar;

/**
 * 公共导航功能， 所有权限都拥有的导航功能， 原始组件
 */
public class CommonNav implements INav {

    @Override
    public String showNavs() {
        return "问答--文章--精品课--冒泡--商城";
    }
}
