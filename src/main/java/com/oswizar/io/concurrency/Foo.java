package com.oswizar.io.concurrency;

import java.util.concurrent.Semaphore;

public class Foo {

    public Foo() {

    }

//    // 定义两个原子变量，firstDone为确保first()执行完成，secondDone为确保second()执行完成
//    AtomicInteger firstDone = new AtomicInteger(0);
//    AtomicInteger secondDone = new AtomicInteger(0);
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        // first执行完成后，自增firstDone
//        firstDone.getAndIncrement();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        // 若此时first()没有执行完成，就进入等待
//        while (firstDone.get() != 1) {
//
//        }
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        // second()执行完成后，自增secondDone
//        secondDone.getAndIncrement();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        // 若此时second()没有执行完成，就进入等待
//        while (secondDone.get() != 1) {
//
//        }
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }


    // 定义两个信号量，firstDone为确保first()执行完成，secondDone为确保second()执行完成
    Semaphore firstDone = new Semaphore(0);
    Semaphore secondDone = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // first执行完成后，释放firstDone
        firstDone.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 若此时first()没有执行完成，就进入等待
        firstDone.acquire();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // second()执行完成后，释放secondDone
        secondDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // 若此时second()没有执行完成，就进入等待
        secondDone.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
