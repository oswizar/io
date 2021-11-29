package com.oswizar.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    /**
//     * 为foo设置信号量a,初始值设为1，因为foo必须先执行且不能连续执行
//     * 为bar设置信号量b,初始值设为0，只有当foo执行完成才能执行bar
//     */
//    Semaphore a = new Semaphore(1);
//    Semaphore b = new Semaphore(0);
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            a.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            b.release();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            b.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            a.release();
//        }
//    }


    private int n;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                condition.await();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }


}
