package com.oswizar.io.concurrency;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {




    static Lock lock = new ReentrantLock();



    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();

        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                3,
                3,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        ThreadPoolExecutor myThreadPoolxxx = new ThreadPoolExecutor(
                3,
                3,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 5; i++) {
            myThreadPool.submit(() ->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        for (int i = 0; i < 5; i++) {
            myThreadPoolxxx.submit(() ->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        myThreadPoolxxx.shutdown();
        myThreadPool.shutdown();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t11111111");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t22222222");
                } finally {
//                    lock.unlock();
                }
            } finally {
//                lock.unlock();
            }

        }, "t1").start();


//        new Thread(() -> {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "\t11111111");
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "\t22222222");
//        }, "t2").start();
    }
}
