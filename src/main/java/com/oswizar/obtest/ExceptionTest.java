package com.oswizar.obtest;

public class ExceptionTest {
    int age;

    public static void main(String[] args) {
        System.out.println(test().age);
    }

    public static ExceptionTest test() {
        ExceptionTest test = new ExceptionTest();
        try {
            test.age = 10;
            return test;
        } catch (Exception e) {
            test.age = 20;
            return test;
        } finally {
            test = new ExceptionTest();
            test.age = 30;
        }
    }
}

