package com.oswizar.algorithm.test;

public class MathTest {

    private MathTest() {}

//    public MathTest getInstance() {
//        if (instance == null) {
//            synchronized (MathContext.class) {
//                if (instance == null) {
//                    instance = new MathTest();
//                }
//            }
//        }
//        return instance;
//    }
    public MathTest getInstance() {
        return Inner.INSTANCE;
    }


    private static class Inner{
        public final static MathTest INSTANCE = new MathTest();
    }


}

