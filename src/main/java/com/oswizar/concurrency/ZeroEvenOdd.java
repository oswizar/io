package com.oswizar.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
//    private int n;
//
//    private volatile int state;
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 1; i <= n; i++) {
//            while (state != 0) {
//                Thread.yield();
//            }
//            printNumber.accept(0);
//            if (i % 2 == 0) {
//                state = 2;
//            } else {
//                state = 1;
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 2; i <= n; i += 2) {
//            while (state != 2) {
//                Thread.yield();
//            }
//            printNumber.accept(i);
//            state = 0;
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 1; i <= n; i += 2) {
//            while (state != 1) {
//                Thread.yield();
//            }
//            printNumber.accept(i);
//            state = 0;
//        }
//    }


    private int n;
    private Semaphore sZero = new Semaphore(1);
    private Semaphore sEven = new Semaphore(0);
    private Semaphore sOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            sZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                sEven.release();
            } else {
                sOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sEven.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sOdd.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
