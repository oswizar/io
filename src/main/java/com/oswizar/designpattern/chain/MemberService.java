package com.oswizar.designpattern.chain;

public class MemberService {

    public void login(Member member) {

        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

//        validateHandler.setNext(loginHandler);
//        loginHandler.setNext(authHandler);
//
//        validateHandler.doHandler(member);

        // 使用建造者优化后
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(validateHandler)
                .addHandler(loginHandler)
                .addHandler(authHandler);

        Handler build = builder.build();

        build.doHandler(member);


    }


}
