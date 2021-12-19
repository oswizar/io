package com.oswizar.io.algorithm.initial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

//    private static int num = 0;

    private static final ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService service1 = Executors.newFixedThreadPool(5);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                int num = local.get();
                local.set(num += 5);
                System.out.println(Thread.currentThread().getName() + "-" + num);
            });
        }
        for (Thread thread : threads) {
            service.submit(thread);
            service1.submit(thread);
//            thread.start();
        }
    }
}
