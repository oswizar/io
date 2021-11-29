package com.oswizar.designpattern.chain;

import com.oswizar.util.StringUtils;

public class ValidateHandler extends Handler{
    @Override
    public void doHandler(Member member) {
        if (StringUtils.isBlank(member.getUsername()) || StringUtils.isBlank(member.getPassword())) {
            System.out.println("用户名或密码为空");
            return;
        }
        System.out.println("参数校验通过");
        next.doHandler(member);
    }
}
