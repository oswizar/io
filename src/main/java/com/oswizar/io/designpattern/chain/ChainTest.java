package com.oswizar.io.designpattern.chain;

public class ChainTest {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();

        Member member = new Member("张三","0000","1管理员");

        memberService.login(member);

    }
}
