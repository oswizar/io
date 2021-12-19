package com.oswizar.io.interview.escape;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class H2O {


    private int state;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        lock.lock();
        try {
            while (state == 2) {
                condition.await();
            }
            state++;
            releaseHydrogen.run();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        lock.lock();
        try {
            while (state != 2) {
                condition.await();
            }
            releaseOxygen.run();
            state = 0;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }


//    private volatile int state;
//    private Object obj = new Object();
//
//    public H2O() {
//
//    }
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//
//        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//        synchronized (obj) {
//            while (state == 2) {
//                obj.wait();
//            }
//            state++;
//            releaseHydrogen.run();
//            obj.notifyAll();
//        }
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//
//        // releaseOxygen.run() outputs "O". Do not change or remove this line.
//        synchronized (obj) {
//            while (state != 2) {
//                obj.wait();
//            }
//            releaseOxygen.run();
//            state = 0;
//            obj.notifyAll();
//        }
//    }


//    private Semaphore h = new Semaphore(2);
//    private Semaphore o = new Semaphore(0);
//
//    public H2O() {
//
//    }
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//
//        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//        h.acquire();
//        releaseHydrogen.run();
//        o.release();
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//
//        // releaseOxygen.run() outputs "O". Do not change or remove this line.
//        o.acquire(2);// 每次消耗2个o许可证
//        releaseOxygen.run();
//        h.release(2);// 每次释放2个h许可证
//    }
}
