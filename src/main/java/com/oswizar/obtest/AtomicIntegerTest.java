package com.oswizar.obtest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.getAndIncrement();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(() -> {
                        for (int i1 = 0; i1 < 10; i1++) {
                            increase();
                        }
                    }
            );
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }

}
