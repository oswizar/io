package com.oswizar.io.designpattern.chain;

public class LoginHandler extends Handler {

    @Override
    public void doHandler(Member member) {
        if (!"0000".equals(member.getPassword())) {
            System.out.println("密码不正确");
            return;
        }
        System.out.println("登录成功");
        next.doHandler(member);
    }
}
