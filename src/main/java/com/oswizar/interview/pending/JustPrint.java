package com.oswizar.interview.pending;

public class JustPrint {
    int count = 0;
    static Object obj1 = new Object();

    public static void main(String[] args) throws Exception {
        Thread a = new Thread(() -> System.out.println("ping"));
        a.start();
        Thread.sleep(1);
        System.out.println("pong");
    }
}


